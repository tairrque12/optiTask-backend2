package com.optitask.customer;

import com.optitask.customer.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)

public class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    //Customer Creates Account Customer Saved
    void shouldSaveAndRetrieveCustomer(){
        Customer customer = new Customer("Tairrque", "Baker", "tbaker1312@gmail.com");
        Customer saved = customerRepository.save(customer);

        assertThat(saved.getId()).isNotNull();
        assertThat(saved.getFirstName()).isEqualTo("Tairrque");
        assertThat(saved.getLastName()).isEqualTo("Baker");
        assertThat(saved.getEmail()).isEqualTo("tbaker1312@gmail.com");
    }
}
