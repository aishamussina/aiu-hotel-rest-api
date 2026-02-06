package com.aiu.hotelrestapi.service.jdbc;

import com.aiu.hotelrestapi.entity.GuestEntity;

import java.util.List;

public interface GuestJdbcService {
    List<GuestEntity> getAll();
    GuestEntity getById(Integer id);
    GuestEntity create(GuestEntity guest);
    GuestEntity update(Integer id, GuestEntity guest);
    void delete(Integer id);
}
