package ru.pflb.store.service;

import ru.pflb.store.entities.Customer;

import java.util.List;

public interface StoreService {

    void regNewCustomer(Customer customer);

    Customer getCustomer(long customer_id);

    List<Customer> getAll();
}
