package com.optitask.reservation;
import com.optitask.customer.Customer;
import com.optitask.customer.CustomerRepository;
import com.optitask.robot.Robot;
import com.optitask.robot.RobotRepository;
import com.optitask.task.Task;
import com.optitask.task.TaskRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigDecimal;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)

public class ReservationRepositoryTest {

    @Autowired
    private RobotRepository robotRepository;

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ReservationRepository reservationRepository;

    @Test
    void shouldSaveAReservationAndGetAllInfoBack(){

        //FAKE DATA FOR ROBOT
        Robot robot = new Robot("Figure 03", "Household Tasks");
        Robot savedRobot = robotRepository.save(robot);

        //FAKE DATA FOR TASKS
        Task task = new Task(savedRobot, "Cleaning", new BigDecimal("25.00"));
        Task savedTask = taskRepository.save(task);

        //FAKE DATA FOR CUSTOMER
        Customer customer = new Customer("Tairrque", "Baker", "tbaker1312@gmail.com");
        Customer savedCustomer = customerRepository.save(customer);

        //FAKE DATA FOR RESERVATION
        Reservation reservation = new Reservation(savedCustomer, savedTask, "123 Main St", 2, new BigDecimal("50.00" ));
        Reservation savedReservation = reservationRepository.save(reservation);

        //ASSERTATIONS
        assertThat(savedReservation.getId()).isNotNull();
        assertThat(savedReservation.getTask().getName()).isEqualTo("Cleaning");
        assertThat(savedReservation.getLocation()).isEqualTo("123 Main St");
        assertThat(savedReservation.getDuration()).isEqualTo(2);
        assertThat(savedReservation.getTotalPrice()).isEqualByComparingTo(new BigDecimal("50.00"));
        assertThat(savedReservation.getCustomer().getFirstName()).isEqualTo("Tairrque");
        assertThat(savedReservation.getCustomer().getLastName()).isEqualTo("Baker");
        assertThat(savedReservation.getCustomer().getEmail()).isEqualTo("tbaker1312@gmail.com");


    }





}