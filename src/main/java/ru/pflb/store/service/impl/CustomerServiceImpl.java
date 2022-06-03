package ru.pflb.store.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.pflb.store.entities.Customer;
import ru.pflb.store.entities.Order;
import ru.pflb.store.repository.OrderRepository;
import ru.pflb.store.repository.CustomerRepository;
import ru.pflb.store.service.CustomerService;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private OrderRepository orderRepository;


    @Override
    @Transactional
    public void regNewCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public Customer getCustomer(long customer_id) {
        return customerRepository.getReferenceById(customer_id);
    }

    @Override
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }


    @Override
    public void addNewOrder(long customer_id, Order order) {

        orderRepository.save(order);

    }

    @Override
    public List<Order> getOrders(long customer_id) {
        return orderRepository.findAll();
    }

    @Override
    public boolean deleteOrder(long customer_id, long id) {
        orderRepository.deleteById(id);
        return true;
    }




}
