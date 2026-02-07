let rooms = [];
let currentUser = null;

async function apiFetch(url, options) {
    const res = await fetch(url, {
        headers: { "Content-Type": "application/json" },
        ...options
    });

    const text = await res.text();
    let data = null;
    try { data = text ? JSON.parse(text) : null; } catch { data = text; }

    if (!res.ok) throw new Error(typeof data === "string" ? data : JSON.stringify(data));
    return data;
}

/* ---------- LOGIN ---------- */
function openLogin() {
    document.getElementById("loginMsg").textContent = "";
    document.getElementById("loginBg").style.display = "flex";
}
function closeLogin() {
    document.getElementById("loginBg").style.display = "none";
}
function bgClose(ev, id){
    if (ev.target && ev.target.id === id) {
        closeLogin();
    }
}

async function doLogin() {
    const name = document.getElementById("name").value.trim();
    const age = Number(document.getElementById("age").value);
    const phone = document.getElementById("phone").value.trim();

    try {
        const created = await apiFetch("/api/guests", {
            method: "POST",
            body: JSON.stringify({ name, age, phone })
        });

        currentUser = created;
        document.getElementById("userLine").textContent = `Signed in as: ${created.name} (id=${created.id})`;
        document.getElementById("loginMsg").textContent = "Success ✅";
        setTimeout(closeLogin, 600);
    } catch (e) {
        document.getElementById("loginMsg").textContent = "Error: " + e.message;
    }
}

/* ---------- BOOKING / ROOMS ---------- */
function openBooking() {
    const section = document.getElementById("roomsSection");
    section.style.display = "block";
    section.scrollIntoView({ behavior: "smooth" });
    loadRooms();
}

async function loadRooms() {
    try {
        rooms = await apiFetch("/api/rooms");
        renderRooms();
    } catch (e) {
        alert("Failed to load rooms: " + e.message);
    }
}

function renderRooms() {
    const grid = document.getElementById("grid");
    grid.innerHTML = "";

    const q = (document.getElementById("q").value || "").toLowerCase().trim();
    const avail = document.getElementById("avail").value;
    const sort = document.getElementById("sort").value;

    let list = [...rooms];

    // search
    if (q) {
        list = list.filter(r =>
            String(r.roomNumber ?? "").toLowerCase().includes(q) ||
            String(r.roomType ?? "").toLowerCase().includes(q)
        );
    }

    // filter
    if (avail === "true") list = list.filter(r => r.available === true);
    if (avail === "false") list = list.filter(r => r.available === false);

    // sort
    if (sort === "num") list.sort((a,b) => (a.roomNumber ?? 0) - (b.roomNumber ?? 0));
    if (sort === "price") list.sort((a,b) => Number(a.pricePerNight ?? 0) - Number(b.pricePerNight ?? 0));
    if (sort === "type") list.sort((a,b) => String(a.roomType ?? "").localeCompare(String(b.roomType ?? "")));

    list.forEach(r => {
        const card = document.createElement("div");
        card.className = "card";

        const ok = r.available === true;
        const tag = ok
            ? `<span class="tag ok">Available</span>`
            : `<span class="tag no">Not available</span>`;

        card.innerHTML = `
      <div style="display:flex; justify-content:space-between; align-items:flex-start; gap:10px;">
        <div>
          <div style="font-size:18px; font-weight:800;">Room ${r.roomNumber}</div>
          <div style="color:#666; margin-top:4px;">Type: <b>${r.roomType}</b></div>
        </div>
        ${tag}
      </div>

      <div class="price">Price: ${r.pricePerNight} / night</div>

      <button ${ok ? "" : "disabled"}>Book</button>
      <div style="margin-top:8px; font-size:12px; color:#666;">
        Uses REST: <b>GET /api/rooms</b>
      </div>
    `;

        card.querySelector("button").addEventListener("click", () => {
            if (!currentUser) {
                alert("Please Sign in first.");
                openLogin();
                return;
            }
            alert(`Booked room ${r.roomNumber} for ${currentUser.name} ✅ (demo)`);
        });

        grid.appendChild(card);
    });
}

/* expose to HTML */
window.openLogin = openLogin;
window.closeLogin = closeLogin;
window.doLogin = doLogin;
window.openBooking = openBooking;
window.loadRooms = loadRooms;
window.renderRooms = renderRooms;
window.bgClose = bgClose;
