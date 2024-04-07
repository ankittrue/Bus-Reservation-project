package com.Bus.Reservation.Bus.Reservation.service;

import com.Bus.Reservation.Bus.Reservation.entity.Bus;
import com.Bus.Reservation.Bus.Reservation.entity.Route;
import com.Bus.Reservation.Bus.Reservation.exception.ResourceNotFound;
import com.Bus.Reservation.Bus.Reservation.repository.BusRepository;
import com.Bus.Reservation.Bus.Reservation.repository.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RouteService {
    @Autowired
    private RouteRepository routeRepository;
    @Autowired
    private BusRepository busRepository;


    public  Route createRoute(Long busId, Route route){
        Bus bus = busRepository.findById(busId).orElseThrow(
                () -> new ResourceNotFound("Bus Not Added")
        );
        Route r = routeRepository.findByBusId(route.getBusId());
        if (r!=null){
            throw  new ResourceNotFound("Route was already added");
        }
        if (r==null){
            routeRepository.save(route);
            return route;
        }
        return null;
    }


}
