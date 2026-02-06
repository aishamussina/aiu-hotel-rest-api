package com.aiu.hotelrestapi.domain;

public abstract class Room {
    private int roomNumber;
    private double pricePerNight;
    private boolean available;

    public Room(int roomNumber, double pricePerNight, boolean available) {
        this.roomNumber = roomNumber;
        this.pricePerNight = pricePerNight;
        this.available = available;
    }

    public int getRoomNumber() { return roomNumber; }
    public void setRoomNumber(int roomNumber) { this.roomNumber = roomNumber; }

    public double getPricePerNight() { return pricePerNight; }
    public void setPricePerNight(double pricePerNight) { this.pricePerNight = pricePerNight; }

    public boolean isAvailable() { return available; }
    public void setAvailable(boolean available) { this.available = available; }

    public abstract String getRoomType();
}
