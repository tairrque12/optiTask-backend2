package com.optitask.customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CustomerController.class)
public class CustomerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private CustomerService customerService;

    @Test
    void shouldSendCustomerInfoBack() throws Exception {
        Customer customer = new Customer("Tairrque", "Baker", "tbaker1312@gmail.com");
        when(customerService.createCustomer(any(Customer.class))).thenReturn(customer);

        mockMvc.perform(post("/api/customers")
                .contentType(org.springframework.http.MediaType.APPLICATION_JSON)
                .content("{\"firstName\": \"Tairrque\", \"lastName\": \"Baker\",\"email\": \"tbaker1312@gmail.com\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName").value("Tairrque"))
                .andExpect(jsonPath("$.lastName").value("Baker"))
                .andExpect(jsonPath("$.email").value("tbaker1312@gmail.com"));


    }
}
