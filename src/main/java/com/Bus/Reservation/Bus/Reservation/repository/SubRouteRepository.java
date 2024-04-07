package com.Bus.Reservation.Bus.Reservation.repository;


import com.Bus.Reservation.Bus.Reservation.entity.SubRoute;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubRouteRepository extends JpaRepository<SubRoute, Long> {
    static List<SubRoute> findByFromLocationAndToLocationAndFromDate(String fromLocation, String toLocation, String fromDate) {
        return null;
    }
}
