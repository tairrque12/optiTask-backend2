package com.optitask.customer;

import org.springframework.stereotype.Service;
import java.util.List;

// SERVICE LAYER - This is where all business logic lives
// It sits between the Controller (API) and the Repository (Database)
// Controller calls Service, Service calls Repository
// Never skip this layer - no business logic in Controller or Repository

@Service
public class CustomerService {

    // The repository this service needs to talk to the database
    // Final means it can never be swapped out after Spring injects it
    private final CustomerRepository customerRepository;

    // Spring sees this constructor and automatically injects the repository
    // You never create this manually
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;

    }
    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

}