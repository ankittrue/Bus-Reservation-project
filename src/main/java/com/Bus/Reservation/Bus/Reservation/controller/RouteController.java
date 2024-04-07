package com.Bus.Reservation.Bus.Reservation.controller;

import com.Bus.Reservation.Bus.Reservation.entity.Route;
import com.Bus.Reservation.Bus.Reservation.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/route")
public class RouteController {
    @Autowired
    private RouteService routeService;

    @PostMapping("/{busId}")
    public ResponseEntity<Route> addRoute(@PathVariable Long busId, @RequestBody Route route) {
        Route createdRoute = routeService.createRoute(busId, route);
        return new ResponseEntity<>(createdRoute, HttpStatus.CREATED);
    }
}
