package com.Bus.Reservation.Bus.Reservation.util;

import com.Bus.Reservation.Bus.Reservation.entity.Passenger;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import org.springframework.stereotype.Service;
import com.itextpdf.text.pdf.PdfWriter;

import com.itextpdf.text.Document;
import java.io.ByteArrayOutputStream;

@Service
public class PdfTicketGeneratorService {
    public byte[] generateTicket(Passenger passenger, String fromLocation, String toLocation, String fromDate) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        Document document = new Document();

        try {

            PdfWriter.getInstance(document, outputStream);
            document.open();
            document.add(new Paragraph("Passenger Details:"));
            document.add(new Paragraph("FirstName: " + passenger.getFirstName()));
            document.add(new Paragraph("LastName: " + passenger.getLastName()));
            document.add(new Paragraph("Email: " + passenger.getEmail()));
            document.add(new Paragraph("Mobile: " + passenger.getMobile()));
            document.add(new Paragraph("BusID: " + passenger.getBusId()));
            document.add(new Paragraph("RouteID: " + passenger.getRouteId()));
            document.add((new Paragraph("FromLocation: " +fromLocation)));
            document.add((new Paragraph("ToLocation: " +toLocation)));
            document.add((new Paragraph("FromDate: " +fromDate)));
            document.close();

        } catch (DocumentException e) {
            e.printStackTrace();
            // Handle exception
        }
        return outputStream.toByteArray();
    }
}