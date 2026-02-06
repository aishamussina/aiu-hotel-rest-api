package com.aiu.hotelrestapi.service.jdbc;

import com.aiu.hotelrestapi.entity.RoomEntity;
import java.util.List;

public interface RoomJdbcService {

    List<RoomEntity> getAll();

    RoomEntity getById(Integer id);

    RoomEntity create(RoomEntity room);

    RoomEntity update(Integer id, RoomEntity room);

    void delete(Integer id);
}
