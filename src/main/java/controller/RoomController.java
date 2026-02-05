package com.aiu.hotelrestapi.controller;

import com.aiu.hotelrestapi.entity.RoomEntity;
import com.aiu.hotelrestapi.repo.RoomRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rooms")
public class RoomController {

    private final RoomRepository repo;

    public RoomController(RoomRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<RoomEntity> getAll() {
        return repo.findAll();
    }

    @PostMapping
    public RoomEntity create(@RequestBody RoomEntity room) {
        return repo.save(room);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        repo.deleteById(id);
    }
}
