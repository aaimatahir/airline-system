class Ticket {
    private Passenger passenger;
    private Flight flight;
    private double price;
    private String seatNumber;  // Seat number for the ticket

    public Ticket(Passenger passenger, Flight flight, double price, String seatNumber) {
        this.passenger = passenger;
        this.flight = flight;
        this.price = price;
        this.seatNumber = seatNumber;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public Flight getFlight() {
        return flight;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    @Override
    public String toString() {
        return "Ticket for " + passenger.getName() + " on flight " + flight.getFlightNumber() + " costing $" + price + " with seat " + seatNumber;
    }
}






