package com.Bus.Reservation.Bus.Reservation.service;

import com.Bus.Reservation.Bus.Reservation.entity.Bus;
import com.Bus.Reservation.Bus.Reservation.entity.Driver;
import com.Bus.Reservation.Bus.Reservation.entity.Route;
import com.Bus.Reservation.Bus.Reservation.entity.SubRoute;
import com.Bus.Reservation.Bus.Reservation.payload.BusDto;
import com.Bus.Reservation.Bus.Reservation.payload.SubRouteDto;
import com.Bus.Reservation.Bus.Reservation.repository.BusRepository;
import com.Bus.Reservation.Bus.Reservation.repository.DriverRepository;
import com.Bus.Reservation.Bus.Reservation.repository.RouteRepository;
import com.Bus.Reservation.Bus.Reservation.repository.SubRouteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BusService {

    @Autowired
    private BusRepository busRepository;

//    @Autowired
//    private RouteRepository routeRepository;
//
//    @Autowired
//    private SubRouteRepository subRouteRepository;
//
//    @Autowired
//    private DriverRepository driverRepository;


    @Transactional
    public Bus addBus(BusDto busDto) {
        // Create and save the Route entity first
//        Route route = new Route();
//        route.setFromLocation(busDto.getRoute().getFromLocation());
//        route.setToLocation(busDto.getRoute().getToLocation());
//        route.setFromDate(busDto.getRoute().getFromDate());
//        route.setToDate(busDto.getRoute().getToDate());
//        route.setTotalDuration(busDto.getRoute().getTotalDuration());
//        route.setFromTime(busDto.getRoute().getFromTime());
//        route.setToTime(busDto.getRoute().getToTime());
//        Route savedRoute = routeRepository.save(route);
//
//        Driver driver = new Driver();
//        driver.setDriverName(busDto.getDriver().getDriverName());
//        driver.setDriverLicenseNumber(busDto.getDriver().getDriverLicenseNumber());
//        driver.setAdharNumber(busDto.getDriver().getAdharNumber());
//        driver.setAddress(busDto.getDriver().getAddress());
//        driver.setContactNumber(busDto.getDriver().getContactNumber());
//        driver.setAlternateContactNumber(busDto.getDriver().getAlternateContactNumber());
//        driver.setEmailId(busDto.getDriver().getEmailId());
//        Driver savedDriver = driverRepository.save(driver);


        // Create and save the Bus entity with the saved Route
        Bus bus = new Bus();
        bus.setBusId(busDto.getBusId());
        bus.setBusNumber(busDto.getBusNumber());
        bus.setBusType(busDto.getBusType());
        bus.setPrice(busDto.getPrice());
        bus.setTotalSeats(busDto.getTotalSeats());
        bus.setAvailableSeats(busDto.getAvailableSeats());
       // bus.setRoute(route); // Set the saved Route entity
        Bus savedBus = busRepository.save(bus); //
        return savedBus;
       // Route routeUpdate = routeRepository.findById(savedRoute.getId()).get();
        //routeUpdate.setBus(savedBus);
        //routeRepository.save(routeUpdate);
        // Save SubRoutes if available
//        if (busDto.getSubRoutes() != null && !busDto.getSubRoutes().isEmpty()) {
//            for (SubRouteDto subRouteDto : busDto.getSubRoutes()) {
//                SubRoute subRoute = new SubRoute();
//                subRoute.setFromLocation(subRouteDto.getFromLocation());
//                subRoute.setToLocation(subRouteDto.getToLocation());
//                subRoute.setFromDate(subRouteDto.getFromDate());
//                subRoute.setToDate(subRouteDto.getToDate());
//                subRoute.setTotalDuration(subRouteDto.getTotalDuration());
//                subRoute.setFromTime(subRouteDto.getFromTime());
//                subRoute.setToTime(subRouteDto.getToTime());
//                subRoute.setRoute(route); // Set the saved Route entity
//                SubRoute saved = subRouteRepository.save(subRoute);
    //       }
  //}
    }
}
