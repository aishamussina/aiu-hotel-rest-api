package com.aiu.hotelrestapi.service;

import com.aiu.hotelrestapi.entity.GuestEntity;
import com.aiu.hotelrestapi.exception.GuestNotFoundException;
import com.aiu.hotelrestapi.exception.InvalidGuestException;
import com.aiu.hotelrestapi.repo.GuestRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class  GuestServiceImpl implements GuestService {

    private final GuestRepository repo;

    public GuestServiceImpl(GuestRepository repo) {
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
        if (guest.getName() == null || guest.getName().isBlank()) {
            throw new InvalidGuestException("Name is required");
        }
        if (guest.getAge() == null || guest.getAge() < 0) {
            throw new InvalidGuestException("Age must be >= 0");
        }
        if (guest.getPhone() == null || guest.getPhone().isBlank()) {
            throw new InvalidGuestException("Phone is required");
        }

        GuestEntity toSave = new com.aiu.hotelrestapi.domain.GuestBuilder()
                .name(guest.getName())
                .age(guest.getAge())
                .phone(guest.getPhone())
                .build();

        toSave.setId(null);
        return repo.save(toSave);


    }

    @Override
    public void delete(Integer id) {
        if (!repo.existsById(id)) {
            throw new GuestNotFoundException("Guest not found with id = " + id);
        }
        repo.deleteById(id);
    }
}
