package com.optitask.reservation;

import com.optitask.customer.Customer;
import com.optitask.customer.CustomerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ReservationController.class)
public class ReservationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private ReservationService reservationService;

    @MockitoBean
    private CustomerService customerService;

    @Test
    void shouldCreateReservation() throws Exception {
        Customer customer = new Customer("Tairrque", "Baker", "tbaker@gmail.com");
        Reservation reservation = new Reservation(customer, null, "123 Main St", 2);
        reservation.setTotalPrice(new BigDecimal("50.00"));

        when(reservationService.createReservation(any(Reservation.class))).thenReturn(reservation);

        mockMvc.perform(post("/api/reservations")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"location\":\"123 Main St\",\"duration\":2}"))
                .andExpect(status().isOk());
    }

    @Test
    void shouldGetReservationsByCustomer() throws Exception {
        Customer customer = new Customer("Tairrque", "Baker", "tbaker@gmail.com");
        Reservation reservation = new Reservation(customer, null, "123 Main St", 2);
        reservation.setTotalPrice(new BigDecimal("50.00"));

        when(customerService.getCustomerById(1L)).thenReturn(customer);
        when(reservationService.getReservationsByCustomer(customer)).thenReturn(List.of(reservation));

        mockMvc.perform(get("/api/reservations/customer/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].location").value("123 Main St"));
    }

    @Test
    void shouldDeleteReservation() throws Exception {
        mockMvc.perform(delete("/api/reservations/1"))
                .andExpect(status().isOk());
    }
}