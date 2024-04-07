package com.Bus.Reservation.Bus.Reservation.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String driverName;
    private String driverLicenseNumber;
    private String adharNumber;
    private String address;
    private String contactNumber;
    private String alternateContactNumber;
    private String emailId;

    @OneToOne
    @JoinColumn(name = "bus_id")
    private Bus bus;
}