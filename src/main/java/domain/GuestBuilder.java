package com.aiu.hotelrestapi.domain;

import com.aiu.hotelrestapi.entity.GuestEntity;

public class GuestBuilder {

    private final GuestEntity guest = new GuestEntity();

    public GuestBuilder name(String name) {
        guest.setName(name);
        return this;
    }

    public GuestBuilder age(Integer age) {
        guest.setAge(age);
        return this;
    }

    public GuestBuilder phone(String phone) {
        guest.setPhone(phone);
        return this;
    }

    public GuestEntity build() {
        return guest;
    }
}
