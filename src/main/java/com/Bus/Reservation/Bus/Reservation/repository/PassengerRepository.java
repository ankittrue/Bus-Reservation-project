package com.Bus.Reservation.Bus.Reservation.repository;

import com.Bus.Reservation.Bus.Reservation.entity.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {
}
