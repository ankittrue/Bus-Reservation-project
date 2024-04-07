package com.Bus.Reservation.Bus.Reservation.controller;

import com.Bus.Reservation.Bus.Reservation.entity.Bus;
import com.Bus.Reservation.Bus.Reservation.entity.Passenger;
import com.Bus.Reservation.Bus.Reservation.entity.Route;
import com.Bus.Reservation.Bus.Reservation.entity.SubRoute;
import com.Bus.Reservation.Bus.Reservation.repository.BusRepository;
import com.Bus.Reservation.Bus.Reservation.repository.PassengerRepository;
import com.Bus.Reservation.Bus.Reservation.repository.RouteRepository;
import com.Bus.Reservation.Bus.Reservation.repository.SubRouteRepository;
import com.Bus.Reservation.Bus.Reservation.util.EmailService;
import com.Bus.Reservation.Bus.Reservation.util.ExcelService;
import com.Bus.Reservation.Bus.Reservation.util.PdfTicketGeneratorService;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/reservation")
public class ReservationController {
    @Autowired
    private PassengerRepository passengerRepository;
    @Autowired
    private BusRepository busRepository;
    @Autowired
    private RouteRepository routeRepository;
    @Autowired
    private SubRouteRepository subRouteRepository;
    @Autowired
    private PdfTicketGeneratorService pdfTicketGeneratorService;
    @Autowired
    private EmailService emailService;
    @Autowired
    private ExcelService excelService;
    //http://localhost:8080/api/reservation?busId=1&routeId=1
    @PostMapping
    public ResponseEntity<String> bookTicket(
            @RequestParam Long busId,
            @RequestParam Long routeId,
            @RequestBody Passenger passenger

    ){
        boolean busIsPresent=false;
        boolean routeIsPresent=false;
        boolean subRouteIsPresent=false;
        Optional<Bus> byId = busRepository.findById(busId);
        if (byId.isPresent()){
            busIsPresent=true;
            Bus bus = byId.get();
        }
        Optional<Route> byRouteId = routeRepository.findById(routeId);
        if (byRouteId.isPresent()){
            routeIsPresent=true;
            Bus bus = byId.get();
        }
        Optional<SubRoute> bySubRouteId = subRouteRepository.findById(routeId);
        if (byRouteId.isPresent()){
            subRouteIsPresent=true;
            Bus bus = byId.get();
        }
if (busIsPresent&&routeIsPresent || busIsPresent&&subRouteIsPresent){
    //add passenger Details
    Passenger p = new Passenger();
    p.setFirstName(passenger.getFirstName());
    p.setLastName(passenger.getLastName());
    p.setEmail(passenger.getEmail());
    p.setMobile(passenger.getMobile());
    p.setRouteId(routeId);
    p.setBusId(busId);
    Passenger savedPassenger = passengerRepository.save(p);
    byte[] pdfBytes = pdfTicketGeneratorService.generateTicket(savedPassenger, byRouteId.get().getFromLocation(), byRouteId.get().getToLocation(), byRouteId.get().getFromDate());
    emailService.sendEmailWithAttachment(passenger.getEmail(), "Booking Confirm.. ", "your reservation id "+savedPassenger.getId(), pdfBytes, "ticket");
}
        return new ResponseEntity<>("done..", HttpStatus.CREATED);
    }


        @GetMapping("/passengers/excel")
        public ResponseEntity<byte[]> generateExcel() throws IOException {
            List<Passenger> passengers = passengerRepository.findAll(); // Fetch passengers from the database

            // Create Excel workbook and sheet
            try (Workbook workbook = new XSSFWorkbook()) {
                Sheet sheet = workbook.createSheet("Passenger Data");

                // Create header row
                Row headerRow = sheet.createRow(0);
                headerRow.createCell(0).setCellValue("ID");
                headerRow.createCell(1).setCellValue("First Name");
                headerRow.createCell(2).setCellValue("Last Name");
                headerRow.createCell(3).setCellValue("Email");
                headerRow.createCell(4).setCellValue("Mobile");
                headerRow.createCell(5).setCellValue("Bus ID");
                headerRow.createCell(6).setCellValue("Route ID");

                // Populate data rows
                int rowNum = 1;
                for (Passenger passenger : passengers) {
                    Row row = sheet.createRow(rowNum++);
                    row.createCell(0).setCellValue(passenger.getId());
                    row.createCell(1).setCellValue(passenger.getFirstName());
                    row.createCell(2).setCellValue(passenger.getLastName());
                    row.createCell(3).setCellValue(passenger.getEmail());
                    row.createCell(4).setCellValue(passenger.getMobile());
                    row.createCell(5).setCellValue(passenger.getBusId());
                    row.createCell(6).setCellValue(passenger.getRouteId());
                }

                // Write workbook to ByteArrayOutputStream
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                workbook.write(outputStream);

                // Set response headers
                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
                headers.setContentDispositionFormData("attachment", "passenger_data.xlsx");

                return new ResponseEntity<>(outputStream.toByteArray(), headers, HttpStatus.OK);
            }
        }
    }


