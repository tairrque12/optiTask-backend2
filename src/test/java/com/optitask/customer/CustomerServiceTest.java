package com.optitask.customer;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceTest {

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerService customerService;

    @Test
    void shouldSaveCustomerAndReturnThemBack(){
        Customer customer = new Customer("Tairrque", "Baker", "tbaker1312@gmail.com");
        when(customerRepository.save(customer)).thenReturn(customer);

        Customer saved = customerService.createCustomer(customer);

        assertThat(saved.getFirstName()).isEqualTo("Tairrque");
        assertThat(saved.getEmail()).isEqualTo("tbaker1312@gmail.com");
        assertThat(saved.getLastName()).isEqualTo("Baker");


    }
}
