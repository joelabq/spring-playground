package com.example.springplayground;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class FlightController {
    @GetMapping("/flights/flight")
    public Flights flightsJSON(){

         Calendar departDate = new Calendar.Builder().setTimeZone(TimeZone.getTimeZone("UTC")).setDate(2017,3,21).setTimeOfDay(14,34,00).build();
         Flights flight = new Flights();
         Flights.Passenger passenger = new Flights.Passenger();
         Flights.Ticket ticket = new Flights.Ticket();
         passenger.setFirstName("Some Name");
         passenger.setLastName("Some other name");
         ticket.setPassenger(passenger);
         ticket.setPrice(200);

         flight.setDeparts(departDate.getTime());
         List<Flights.Ticket> tickets = new ArrayList<>();
         tickets.add(ticket);
         flight.setTickets(tickets);



          return flight;
    }
}
