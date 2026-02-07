package com.aiu.hotelrestapi.domain;

import com.aiu.hotelrestapi.entity.RoomEntity;

public class RoomRttiInspector {

    public static String inspect(RoomEntity room) {

        // RTTI using instanceof
        if (room instanceof RoomEntity) {
            return "RTTI: RoomEntity detected at runtime";
        }

        return "RTTI: Unknown type";
    }
}
