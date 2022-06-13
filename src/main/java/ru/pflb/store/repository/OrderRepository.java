package ru.pflb.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.pflb.store.entities.Customer;
import ru.pflb.store.entities.Order;

import java.time.Instant;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order,Long> {


    @Query(value = "SELECT * FROM ORDERS o WHERE o.customer_id = ?1", nativeQuery = true)
    List<Order> findByCustomer(Long customer_id);

}
