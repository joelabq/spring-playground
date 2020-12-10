package com.example.springplayground;

import java.util.Date;
import java.util.List;

 public class Flights {
    private Date departs;
    private List<Ticket> tickets;


    public Date getDeparts() { return this.departs; }

    public void setDeparts(Date departs) { this.departs = departs; }

    public List<Ticket> getTickets() { return this.tickets; }

    public void setTickets(List<Ticket> tickets) { this.tickets = tickets; }

    static class Ticket{

        private Passenger passenger;
        private int price;

        public Passenger getPassenger() { return this.passenger; }

        public void setPassenger(Passenger passenger) { this.passenger = passenger; }

        public int getPrice() { return this.price; }

        public void setPrice(int price) { this.price = price; }
    }

     static class Passenger {
        private String firstName;
         private String lastName;

         public String getFirstName() { return this.firstName;  }

         public void setFirstName(String firstName) { this.firstName = firstName;  }

         public String getLastName() {  return this.lastName;  }

         public void setLastName(String lastName) {    this.lastName = lastName; }
     }



    
}



