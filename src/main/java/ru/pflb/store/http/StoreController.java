package ru.pflb.store.http;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.pflb.store.entities.Customer;
import ru.pflb.store.service.StoreService;

import java.util.List;

@Service
@RestController
public class StoreController {

    private final StoreService storeService;

    @Autowired
    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    @PostMapping(value = "new_customer")
    public ResponseEntity<?> addCustomer(@RequestBody Customer customer){
        storeService.regNewCustomer(customer);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "getAll")
    public ResponseEntity<List<Customer>> getAll(){
        final List<Customer> customers = storeService.getAll();
        return customers != null && !customers.isEmpty()
                ? new ResponseEntity<>(customers, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
