package com.aiu.hotelrestapi.domain;

public class SingleRoom extends Room {
    public SingleRoom(int roomNumber, double pricePerNight, boolean available) {
        super(roomNumber, pricePerNight, available);
    }

    @Override
    public String getRoomType() {
        return "Single";
    }
}
