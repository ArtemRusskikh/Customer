package ru.pflb.store;


import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.pflb.store.entities.Customer;
import ru.pflb.store.entities.Order;
import ru.pflb.store.repository.CustomerRepository;
import ru.pflb.store.repository.OrderRepository;
import ru.pflb.store.service.CustomerService;
import ru.pflb.store.service.impl.CustomerServiceImpl;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CustomerTest {
    @Mock
    private CustomerRepository customerRepository;
    @Mock
    private OrderRepository orderRepository;
    @InjectMocks
    CustomerServiceImpl customerServiceImpl;


    @Test
    void  checkFindGetOrders() {

        Long id = 1L;
        Instant d = Instant.parse("2022-05-14T18:25:43.511Z");
        List list = new ArrayList<>();
        list.add(new Order(33L, "aa", "ss", d));
       // Customer customer1 = new Customer(1L, "qq", "ww", "ee", list);

        Mockito.when(orderRepository.findByCustomer(id)).thenReturn(list);
        assertEquals(list,customerServiceImpl.getOrders(id));
    }

    @Test
    void  checkGetAll() {

        Long id = 1L;
        Instant d = Instant.parse("2022-05-14T18:25:43.511Z");
        List list = new ArrayList<>();
        list.add(new Order(33L, "aa", "ss", d));
         Customer customer1 = new Customer(1L, "qq", "ww", "ee", list);
        List list2 = new ArrayList<>();
        list2.add(customer1);

        Mockito.when(customerRepository.findAll()).thenReturn(list2);
        assertEquals(list2,customerServiceImpl.getAll());
    }

    @Test
    void  checkGetCustomer() {

        Long id = 1L;
        Instant d = Instant.parse("2022-05-14T18:25:43.511Z");
        List list = new ArrayList<>();
        list.add(new Order(33L, "aa", "ss", d));
        Customer customer1 = new Customer(1L, "qq", "ww", "ee", list);
        List list2 = new ArrayList<>();
        list2.add(customer1);

        Mockito.when(customerRepository.getReferenceById(id)).thenReturn(customer1);
        assertEquals(customer1,customerServiceImpl.getCustomer(id));
    }

    @Test
    void checkAddCustomer (){

        Long id = 1L;
        Instant d = Instant.parse("2022-05-14T18:25:43.511Z");
        List list = new ArrayList<>();
        list.add(new Order(33L, "aa", "ss", d));
        Customer customer1 = new Customer(1L, "qq", "ww", "ee", list);
        CustomerServiceImpl myCustomerService = mock(CustomerServiceImpl.class);

        doNothing()
                .when(myCustomerService).regNewCustomer(isA(Customer.class));
                myCustomerService.regNewCustomer(customer1);
                verify(myCustomerService).regNewCustomer(customer1);
    }

    @Test
    void deleteOrder() {

        Long id = 1L;
        Instant d = Instant.parse("2022-05-14T18:25:43.511Z");
        List list = new ArrayList<>();
        list.add(new Order(33L, "aa", "ss", d));
        Customer customer1 = new Customer(1L, "qq", "ww", "ee", list);
        CustomerService myCustomerService1 = mock(CustomerService.class);

        Mockito.doReturn(true).when(myCustomerService1).deleteOrder(id);
        assertEquals(true, myCustomerService1.deleteOrder(id));
    }
}
