package com.aiu.hotelrestapi.demo;

import com.aiu.hotelrestapi.domain.Room;
import com.aiu.hotelrestapi.domain.RoomFactory;
import com.aiu.hotelrestapi.domain.RoomPricingService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class OopDemoRunner implements CommandLineRunner {

    @Override
    public void run(String... args) {

        System.out.println("=== OOP DEMO (Inheritance + Polymorphism) ===");

        List<Room> rooms = List.of(
                RoomFactory.create("single", 101, 15000, true),
                RoomFactory.create("double", 102, 25000, false)
        );


        RoomPricingService pricingService = new RoomPricingService();

        for (Room r : rooms) {
            System.out.println(
                    r.getRoomType() +
                            " room " + r.getRoomNumber() +
                            " total for 2 nights = " +
                            pricingService.calculatePrice(r, 2)
            );
        }

        System.out.println("=== END OOP DEMO ===");
    }
}
