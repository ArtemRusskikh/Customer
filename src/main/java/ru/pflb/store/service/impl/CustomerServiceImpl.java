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
    public List<Order> getOrders(long customer_id) {
        return orderRepository.findAll();
    }

    @Override
    public boolean deleteOrder(long order_id) {
        orderRepository.deleteById(order_id);
        return true;
    }

}
