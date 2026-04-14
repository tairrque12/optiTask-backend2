package com.optitask.reservation;


import com.optitask.customer.Customer;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public Reservation createReservation(Reservation reservation){
        BigDecimal totalPrice = reservation.getTask().getBasePrice()
                //MULTIPLY HOURLY PRICE BY THE DURATION
                .multiply(BigDecimal.valueOf(reservation.getDuration()));
        //TAKE THE TOTAL PRICE AND SET IT TO RESERVATION SO THAT RESERVATION KNOWS TOTAL PRICE
        reservation.setTotalPrice(totalPrice);
        //HANDS THE COMPLETED RESERVATION TO THE REPO
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