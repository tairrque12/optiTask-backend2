package com.optitask.reservation;

import com.optitask.customer.Customer;
import com.optitask.task.Task;
import com.optitask.task.TaskRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final TaskRepository taskRepository;

    public ReservationService(ReservationRepository reservationRepository, TaskRepository taskRepository) {
        this.reservationRepository = reservationRepository;
        this.taskRepository = taskRepository;
    }

    public Reservation createReservation(Reservation reservation) {
        // FETCH FULL TASK FROM DB SO WE HAVE THE BASE PRICE
        Task fullTask = taskRepository.findById(reservation.getTask().getId())
                .orElseThrow(() -> new RuntimeException("Task not found"));
        reservation.setTask(fullTask);

        // MULTIPLY HOURLY PRICE BY THE DURATION
        BigDecimal totalPrice = fullTask.getBasePrice()
                .multiply(BigDecimal.valueOf(reservation.getDuration()));

        // SET TOTAL PRICE ON RESERVATION
        reservation.setTotalPrice(totalPrice);

        // SAVE AND RETURN
        return reservationRepository.save(reservation);
    }

    // GET ALL RESERVATIONS FOR A SPECIFIC CUSTOMER
    public List<Reservation> getReservationsByCustomer(Customer customer) {
        return reservationRepository.findByCustomer(customer);
    }

    // DELETE A RESERVATION BY ID
    public void deleteReservation(Long id) {
        reservationRepository.deleteById(id);
    }
}