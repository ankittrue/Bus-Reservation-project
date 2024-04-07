package com.Bus.Reservation.Bus.Reservation.repository;

import com.Bus.Reservation.Bus.Reservation.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverRepository extends JpaRepository<Driver, Long> {
}
