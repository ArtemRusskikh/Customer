package ru.pflb.store.service;

import ru.pflb.store.entities.Customer;
import ru.pflb.store.entities.Order;

import java.util.List;

public interface CustomerService {

    void regNewCustomer(Customer customer);

    Customer getCustomer(long customer_id);

    List<Customer> getAll();


    List<Order> getOrders(long customer_id);

    boolean deleteOrder(long order_id);

}
