package com.aiu.hotelrestapi.controller;

import com.aiu.hotelrestapi.entity.GuestEntity;
import com.aiu.hotelrestapi.service.GuestService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/guests")
public class GuestController {

    private final GuestService service;

    public GuestController(GuestService service) {
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

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}
