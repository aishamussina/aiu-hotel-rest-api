package com.aiu.hotelrestapi.controller;

import com.aiu.hotelrestapi.entity.GuestEntity;
import com.aiu.hotelrestapi.repo.GuestRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/guests/pool")
public class GuestPoolController {

    private final GuestRepository repo;
    private final List<GuestEntity> pool = new ArrayList<>();

    public GuestPoolController(GuestRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/refresh")
    public String refresh() {
        pool.clear();
        pool.addAll(repo.findAll());
        return "Pool refreshed. Size = " + pool.size();
    }

    @GetMapping
    public List<GuestEntity> getPool() {
        return pool;
    }

    @GetMapping("/filter")
    public List<GuestEntity> filter(@RequestParam int minAge) {
        return pool.stream()
                .filter(g -> g.getAge() != null && g.getAge() >= minAge)
                .collect(Collectors.toList());
    }

    @GetMapping("/search")
    public List<GuestEntity> search(@RequestParam String q) {
        String query = q.toLowerCase();
        return pool.stream()
                .filter(g -> g.getName() != null && g.getName().toLowerCase().contains(query))
                .collect(Collectors.toList());
    }

    @GetMapping("/sort/age")
    public List<GuestEntity> sortByAge() {
        return pool.stream()
                .sorted(Comparator.comparing(GuestEntity::getAge))
                .collect(Collectors.toList());
    }
}
