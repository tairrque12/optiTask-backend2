package com.optitask.reservation;

import com.optitask.customer.Customer;
import com.optitask.reservation.ReservationRepository;
import com.optitask.reservation.ReservationService;
import com.optitask.robot.Robot;
import com.optitask.task.Task;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.OngoingStubbing;

import java.math.BigDecimal;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ReservationServiceTest {

    @Mock
    private ReservationRepository reservationRepository;

    @InjectMocks
    private ReservationService reservationService;

    @Test
    void shouldCorrectlyCalculateTotalPrice(){
        //FAKE ROBOT DATA
        Robot robot = new Robot("Figure 03", "HouseHold Tasks");

        //FAKE TASK DATA
        Task task = new Task(robot, "Dishes", new BigDecimal("25.00"));

        //FAKE CUSTOMER DATA
        Customer customer = new Customer("Tairrque", "Baker", "tbaker1312@gmail.com");

        //RESERVATION DATA
        Reservation reservation = new Reservation(customer, task, "123 Main St.", 2);

        //PROGRAMMES FAKE REPO
        when(reservationRepository.save(reservation)).thenReturn(reservation);

        Reservation saved = reservationService.createReservation(reservation);

        //ASSERTION
        assertThat(saved.getTotalPrice()).isEqualByComparingTo(new BigDecimal("50.00"));






    }
}