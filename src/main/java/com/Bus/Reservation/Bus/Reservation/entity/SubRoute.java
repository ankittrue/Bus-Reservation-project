package com.Bus.Reservation.Bus.Reservation.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class SubRoute {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fromLocation;
    private String toLocation;
    private String fromDate;
    private String toDate;
    private String totalDuration;
    private String fromTime;
    private String toTime;
    @Column(name = "route_id") //, nullable = false
    private Long  routeId;
    private Long busId;

//    @ManyToOne
//    @JoinColumn(name = "route_id")
//    private Route route;

    // constructors, getters, and setters
}
