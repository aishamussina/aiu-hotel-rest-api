package com.aiu.hotelrestapi.service.jdbc;

import com.aiu.hotelrestapi.entity.GuestEntity;
import com.aiu.hotelrestapi.exception.GuestNotFoundException;
import com.aiu.hotelrestapi.exception.InvalidGuestException;
import com.aiu.hotelrestapi.repo.jdbc.BaseJdbcRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuestJdbcServiceImpl implements GuestJdbcService {

    private final BaseJdbcRepository<GuestEntity, Integer> repo; // DIP + Generics

    public GuestJdbcServiceImpl(BaseJdbcRepository<GuestEntity, Integer> repo) {
        this.repo = repo;
    }

    @Override
    public List<GuestEntity> getAll() {
        return repo.findAll();
    }

    @Override
    public GuestEntity getById(Integer id) {
        return repo.findById(id)
                .orElseThrow(() -> new GuestNotFoundException("Guest not found with id = " + id));
    }

    @Override
    public GuestEntity create(GuestEntity guest) {
        validate(guest);
        guest.setId(null);
        return repo.create(guest);
    }

    @Override
    public GuestEntity update(Integer id, GuestEntity guest) {
        validate(guest);
        return repo.update(id, guest);
    }

    @Override
    public void delete(Integer id) {
        repo.delete(id);
    }

    private void validate(GuestEntity guest) {
        if (guest.getName() == null || guest.getName().isBlank()) throw new InvalidGuestException("Name is required");
        if (guest.getAge() == null || guest.getAge() < 0) throw new InvalidGuestException("Age must be >= 0");
        if (guest.getPhone() == null || guest.getPhone().isBlank()) throw new InvalidGuestException("Phone is required");
    }
}
