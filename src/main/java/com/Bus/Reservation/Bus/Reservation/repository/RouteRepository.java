package com.Bus.Reservation.Bus.Reservation.repository;

import com.Bus.Reservation.Bus.Reservation.entity.Route;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RouteRepository extends JpaRepository<Route, Long> {
//List<Route> findByFromLocationAndFromDate(String fromLocation, String toLocation);
    Route findByBusId(Long busId);
    List<Route> findByFromLocationAndToLocationAndFromDate(String fromLocation, String toLocation, String fromDate);
}
