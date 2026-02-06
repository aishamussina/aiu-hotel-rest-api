package com.aiu.hotelrestapi.service;

import com.aiu.hotelrestapi.entity.GuestEntity;
import java.util.List;

public interface GuestService {
    List<GuestEntity> getAll();
    GuestEntity getById(Integer id);
    GuestEntity create(GuestEntity guest);
    void delete(Integer id);
}
