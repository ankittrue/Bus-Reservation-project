package com.Bus.Reservation.Bus.Reservation.entity;
//
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import java.util.List;
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@Entity
//public class Route {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//
//    // Other fields and annotations...
//
//
//    private String fromLocation;
//    private String toLocation;
//    private String fromDate;
//    private String toDate;
//    private String totalDuration;
//    private String fromTime;
//    private String toTime;
//    @Column(name = "bus_id", unique = true, nullable = false )
//    private Long busId;
////    @OneToOne(fetch = FetchType.LAZY)
////    @JoinColumn(name = "bus_id",unique = true, nullable = false ) //referencedColumnName = "id"
////    private Bus bus;
//
////    @OneToMany(mappedBy = "route", fetch = FetchType.LAZY)  //, cascade = CascadeType.ALL
////    private List<SubRoute> subRoutes;
//
//
//
//    // constructors, getters, and setters
//}
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Route {
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

    @Column(name = "bus_id") //, unique = true, nullable = false
    private Long busId;

    // Getters and setters (or lombok annotations for getters/setters) should be here
}

