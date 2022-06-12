package ru.pflb.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.pflb.store.entities.Order;

import java.time.Instant;

public interface OrderRepository extends JpaRepository<Order,Long> {


}
