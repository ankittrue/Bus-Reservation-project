package com.Bus.Reservation.Bus.Reservation.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "bus")
@JsonIgnoreProperties({"hibernateLazyInitializer}", "handler"})
public class Bus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String busNumber;
    private String busType;
    private double price;
    private int totalSeats;
    private int availableSeats;
    private Long busId;

//    @ManyToOne // Many buses can have one route
//    @JoinColumn(name = "route_id") // Foreign key column in the bus table
   // private Route route;

//    @OneToOne(mappedBy = "bus", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private Driver driver;
}

