package ru.pflb.store.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import ru.pflb.store.entities.Customer;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CustomerRequest {

    private Customer customer;
}
