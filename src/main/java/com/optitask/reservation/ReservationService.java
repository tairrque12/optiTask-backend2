package com.optitask.reservation;


import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public Reservation createReservation(Reservation reservation){
        BigDecimal totalPrice = reservation.getTask().getBasePrice()
                .multiply(BigDecimal.valueOf(reservation.getDuration()));

        reservation.setTotalPrice(totalPrice);
        return reservationRepository.save(reservation);
    }
}