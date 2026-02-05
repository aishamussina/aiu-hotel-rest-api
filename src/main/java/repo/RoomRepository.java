package com.aiu.hotelrestapi.repo;

import com.aiu.hotelrestapi.entity.RoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<RoomEntity, Integer> {
}
