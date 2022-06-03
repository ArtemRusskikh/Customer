package ru.pflb.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.pflb.store.entities.Order;

public interface OrderRepository extends JpaRepository<Order,Long> {
}
