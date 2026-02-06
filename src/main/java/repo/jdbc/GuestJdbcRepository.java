package com.aiu.hotelrestapi.repo.jdbc;

import com.aiu.hotelrestapi.entity.GuestEntity;
import com.aiu.hotelrestapi.exception.GuestNotFoundException;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class GuestJdbcRepository implements BaseJdbcRepository<GuestEntity, Integer> {

    private final DataSource dataSource;

    public GuestJdbcRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public GuestEntity create(GuestEntity entity) {
        String sql = "INSERT INTO guests(name, age, phone) VALUES (?, ?, ?) RETURNING id";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, entity.getName());
            ps.setInt(2, entity.getAge());
            ps.setString(3, entity.getPhone());

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    GuestEntity created = new GuestEntity();
                    created.setId(rs.getInt("id"));
                    created.setName(entity.getName());
                    created.setAge(entity.getAge());
                    created.setPhone(entity.getPhone());
                    return created;
                }
            }
            throw new SQLException("Insert did not return id");

        } catch (SQLException e) {
            throw new RuntimeException("JDBC create guest failed: " + e.getMessage(), e);
        }
    }

    @Override
    public Optional<GuestEntity> findById(Integer id) {
        String sql = "SELECT id, name, age, phone FROM guests WHERE id = ?";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (!rs.next()) return Optional.empty();

                GuestEntity g = new GuestEntity();
                g.setId(rs.getInt("id"));
                g.setName(rs.getString("name"));
                g.setAge(rs.getInt("age"));
                g.setPhone(rs.getString("phone"));
                return Optional.of(g);
            }

        } catch (SQLException e) {
            throw new RuntimeException("JDBC find guest failed: " + e.getMessage(), e);
        }
    }

    @Override
    public List<GuestEntity> findAll() {
        String sql = "SELECT id, name, age, phone FROM guests ORDER BY id";
        List<GuestEntity> list = new ArrayList<>();

        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                GuestEntity g = new GuestEntity();
                g.setId(rs.getInt("id"));
                g.setName(rs.getString("name"));
                g.setAge(rs.getInt("age"));
                g.setPhone(rs.getString("phone"));
                list.add(g);
            }
            return list;

        } catch (SQLException e) {
            throw new RuntimeException("JDBC list guests failed: " + e.getMessage(), e);
        }
    }

    @Override
    public GuestEntity update(Integer id, GuestEntity entity) {
        String sql = "UPDATE guests SET name = ?, age = ?, phone = ? WHERE id = ?";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, entity.getName());
            ps.setInt(2, entity.getAge());
            ps.setString(3, entity.getPhone());
            ps.setInt(4, id);

            int rows = ps.executeUpdate();
            if (rows == 0) throw new GuestNotFoundException("Guest not found with id = " + id);

            GuestEntity updated = new GuestEntity();
            updated.setId(id);
            updated.setName(entity.getName());
            updated.setAge(entity.getAge());
            updated.setPhone(entity.getPhone());
            return updated;

        } catch (SQLException e) {
            throw new RuntimeException("JDBC update guest failed: " + e.getMessage(), e);
        }
    }

    @Override
    public void delete(Integer id) {
        String sql = "DELETE FROM guests WHERE id = ?";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            int rows = ps.executeUpdate();
            if (rows == 0) throw new GuestNotFoundException("Guest not found with id = " + id);

        } catch (SQLException e) {
            throw new RuntimeException("JDBC delete guest failed: " + e.getMessage(), e);
        }
    }
}
