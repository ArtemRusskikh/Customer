package ru.pflb.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.pflb.store.entities.Customer;
import ru.pflb.store.entities.Order;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer,Long> {

//    @Query(value = "SELECT c.orders FROM CUSTOMERS c WHERE c.customer_id = 1", nativeQuery = true)
//    List<Customer> findByCustomer(Long customer_id);

}
