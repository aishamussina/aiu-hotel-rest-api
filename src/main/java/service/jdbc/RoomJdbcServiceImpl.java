package com.aiu.hotelrestapi.service.jdbc;

import com.aiu.hotelrestapi.entity.RoomEntity;
import com.aiu.hotelrestapi.repo.jdbc.BaseJdbcRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RoomJdbcServiceImpl implements RoomJdbcService {

    private final BaseJdbcRepository<RoomEntity, Integer> repo;

    public RoomJdbcServiceImpl(BaseJdbcRepository<RoomEntity, Integer> repo) {
        this.repo = repo;
    }

    @Override
    public List<RoomEntity> getAll() {
        return repo.findAll();
    }

    @Override
    public RoomEntity getById(Integer id) {
        return repo.findById(id).orElseThrow(() ->
                new RuntimeException("Room not found: " + id));
    }

    @Override
    public RoomEntity create(RoomEntity room) {
        return repo.create(room);
    }

    @Override
    public RoomEntity update(Integer id, RoomEntity room) {
        return repo.update(id, room);
    }

    @Override
    public void delete(Integer id) {
        repo.delete(id);
    }
}
