package ru.pflb.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.pflb.store.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Long> {



}
