package com.Bus.Reservation.Bus.Reservation.payload;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.DatabaseMetaData;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BusDto {
    private String busNumber;
    private String busType;
    private double price;
    private int totalSeats;
    private int availableSeats;
    private Long busId;
   // private DriverDto driver;
//    private RouteDto route;
//    private List<SubRouteDto> subRoutes;
}