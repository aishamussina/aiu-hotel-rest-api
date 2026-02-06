package com.aiu.hotelrestapi.controller.jdbc;

import com.aiu.hotelrestapi.entity.GuestEntity;
import com.aiu.hotelrestapi.service.jdbc.GuestJdbcService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jdbc/guests")
public class GuestJdbcController {

    private final GuestJdbcService service;

    public GuestJdbcController(GuestJdbcService service) {
        this.service = service;
    }

    @GetMapping
    public List<GuestEntity> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public GuestEntity getById(@PathVariable Integer id) {
        return service.getById(id);
    }

    @PostMapping
    public GuestEntity create(@RequestBody GuestEntity guest) {
        return service.create(guest);
    }

    @PutMapping("/{id}")
    public GuestEntity update(@PathVariable Integer id, @RequestBody GuestEntity guest) {
        return service.update(id, guest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}
