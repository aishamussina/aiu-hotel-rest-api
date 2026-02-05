package com.aiu.hotelrestapi.controller;

import com.aiu.hotelrestapi.entity.GuestEntity;
import com.aiu.hotelrestapi.repo.GuestRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/guests")
public class GuestController {

    private final GuestRepository repo;

    public GuestController(GuestRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<GuestEntity> getAll() {
        return repo.findAll();
    }

    @PostMapping
    public GuestEntity create(@RequestBody GuestEntity guest) {
        guest.setId(null);
        return repo.save(guest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        repo.deleteById(id);
    }
}
