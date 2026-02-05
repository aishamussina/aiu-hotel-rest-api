package com.aiu.hotelrestapi.repo;

import com.aiu.hotelrestapi.entity.GuestEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestRepository extends JpaRepository<GuestEntity, Integer> {
}
