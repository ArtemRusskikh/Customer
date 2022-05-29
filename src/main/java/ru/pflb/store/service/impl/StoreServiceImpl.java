package ru.pflb.store.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.pflb.store.entities.Customer;
import ru.pflb.store.repository.CustomerRepository;
import ru.pflb.store.service.StoreService;

import java.sql.ClientInfoStatus;
import java.util.ArrayList;
import java.util.List;

@Service
public class StoreServiceImpl implements StoreService {

    @Autowired
    private CustomerRepository customerRepository;


    @Override
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

}
