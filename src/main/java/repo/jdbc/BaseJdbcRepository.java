package com.aiu.hotelrestapi.repo.jdbc;

import java.util.List;
import java.util.Optional;

public interface BaseJdbcRepository<T, ID> {
    T create(T entity);
    Optional<T> findById(ID id);
    List<T> findAll();
    T update(ID id, T entity);
    void delete(ID id);
}
