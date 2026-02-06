package com.aiu.hotelrestapi.controller.jdbc;

import com.aiu.hotelrestapi.entity.RoomEntity;
import com.aiu.hotelrestapi.service.jdbc.RoomJdbcService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jdbc/rooms")
public class RoomJdbcController {

    private final RoomJdbcService service;

    public RoomJdbcController(RoomJdbcService service) {
        this.service = service;
    }

    @GetMapping
    public List<RoomEntity> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public RoomEntity getById(@PathVariable Integer id) {
        return service.getById(id);
    }

    @PostMapping
    public RoomEntity create(@RequestBody RoomEntity room) {
        return service.create(room);
    }

    @PutMapping("/{id}")
    public RoomEntity update(@PathVariable Integer id, @RequestBody RoomEntity room) {
        return service.update(id, room);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}
