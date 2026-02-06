package com.aiu.hotelrestapi.domain;

public class RoomPricingService {

    // polymorphism: accepts base type Room
    public double calculatePrice(Room room, int nights) {
        return room.getPricePerNight() * nights;
    }
}
