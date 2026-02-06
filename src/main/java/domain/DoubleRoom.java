package com.aiu.hotelrestapi.domain;

public class DoubleRoom extends Room {
    public DoubleRoom(int roomNumber, double pricePerNight, boolean available) {
        super(roomNumber, pricePerNight, available);
    }

    @Override
    public String getRoomType() {
        return "Double";
    }
}
