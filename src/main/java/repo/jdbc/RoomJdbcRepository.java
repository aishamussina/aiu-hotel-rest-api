package com.aiu.hotelrestapi.repo.jdbc;

import com.aiu.hotelrestapi.entity.RoomEntity;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class RoomJdbcRepository implements BaseJdbcRepository<RoomEntity, Integer> {

    private final DataSource dataSource;

    public RoomJdbcRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public RoomEntity create(RoomEntity room) {
        String sql = "INSERT INTO rooms(room_number, room_type, price_per_night, available) VALUES (?, ?, ?, ?)";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, room.getRoomNumber());
            ps.setString(2, room.getRoomType());
            ps.setBigDecimal(3, room.getPricePerNight());
            ps.setBoolean(4, room.getAvailable());

            ps.executeUpdate();
            return room;

        } catch (SQLException e) {
            throw new RuntimeException("Create room failed: " + e.getMessage(), e);
        }
    }

    @Override
    public Optional<RoomEntity> findById(Integer id) {
        String sql = "SELECT * FROM rooms WHERE room_number = ?";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (!rs.next()) return Optional.empty();

                RoomEntity r = new RoomEntity();
                r.setRoomNumber(rs.getInt("room_number"));
                r.setRoomType(rs.getString("room_type"));
                r.setPricePerNight(rs.getBigDecimal("price_per_night"));
                r.setAvailable(rs.getBoolean("available"));
                return Optional.of(r);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<RoomEntity> findAll() {
        List<RoomEntity> list = new ArrayList<>();
        String sql = "SELECT * FROM rooms ORDER BY room_number";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                RoomEntity r = new RoomEntity();
                r.setRoomNumber(rs.getInt("room_number"));
                r.setRoomType(rs.getString("room_type"));
                r.setPricePerNight(rs.getBigDecimal("price_per_night"));
                r.setAvailable(rs.getBoolean("available"));
                list.add(r);
            }
            return list;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public RoomEntity update(Integer id, RoomEntity room) {
        String sql = "UPDATE rooms SET room_type=?, price_per_night=?, available=? WHERE room_number=?";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, room.getRoomType());
            ps.setBigDecimal(2, room.getPricePerNight());
            ps.setBoolean(3, room.getAvailable());
            ps.setInt(4, id);

            ps.executeUpdate();
            return room;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Integer id) {
        String sql = "DELETE FROM rooms WHERE room_number=?";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
