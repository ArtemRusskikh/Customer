package ru.pflb.store.http;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import ru.pflb.store.entities.Customer;
import ru.pflb.store.entities.Order;
import ru.pflb.store.repository.OrderInsertRepository;
import ru.pflb.store.service.CustomerService;
import ru.pflb.store.service.WebHookService;

import java.util.List;

@Service
@RestController
public class CustomerController {

    private final CustomerService customerService;
    private final WebHookService webHookService;
    private final OrderInsertRepository orderInsertRepository;

    @Autowired
    public CustomerController(CustomerService customerService, WebHookService webHookService, OrderInsertRepository orderInsertRepository) {
        this.customerService = customerService;
        this.webHookService = webHookService;
        this.orderInsertRepository = orderInsertRepository;
    }

    @PostMapping(value = "new_customer")
    public ResponseEntity<?> addCustomer(@RequestBody Customer customer){
        webHookService.getWebHook();
        customerService.regNewCustomer(customer);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
//    @PutMapping(value = "update_customer")
//    public ResponseEntity<?> updateCustomer(@RequestBody Customer customer){
//        webHookService.getWebHook();
//        customerService.updateCustomer(customer);
//        return new ResponseEntity<>(HttpStatus.CREATED);
//    }

    @PutMapping(value = "update_customer/{customer_id}")
    public ResponseEntity<?> updateCustomer(@RequestBody Order order, @PathVariable long customer_id){
        orderInsertRepository.insertWithQuery(order,customer_id);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "orders/getAllOrders/{customer_id}")
    public ResponseEntity<List<Order>> getAll(@PathVariable long customer_id){
        final List<Order> orders = customerService.getOrders(customer_id);
        return orders != null && !orders.isEmpty()
                ? new ResponseEntity<>(orders, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @DeleteMapping(value = "/customer/orders/delete/{order_id}")
    public ResponseEntity<?> deleteOrder(@PathVariable long order_id) {
        final boolean deleted = customerService.deleteOrder(order_id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
    @GetMapping(value = "getAllCustomers")
    public ResponseEntity<List<Customer>> getAllCustomers(){
        final List<Customer> customers = customerService.getAll();
        return customers != null && !customers.isEmpty()
                ? new ResponseEntity<>(customers, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
