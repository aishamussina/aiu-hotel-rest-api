package com.aiu.hotelrestapi.domain;

public class RoomFactory {

    public static Room create(String type, int number, double price, boolean available) {

        if (type == null) {
            throw new IllegalArgumentException("Room type is null");
        }

        return switch (type.toLowerCase()) {
            case "single" -> new SingleRoom(number, price, available);
            case "double" -> new DoubleRoom(number, price, available);
            default -> throw new IllegalArgumentException("Unknown room type: " + type);
        };
    }
}
