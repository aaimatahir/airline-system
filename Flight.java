import java.util.ArrayList;
import java.util.List;

public class Flight {
   
    private String flightNumber;
    private String origin;
    private String destination;
    private String departureTime;
    private List<Passenger> passengers;
    private List<String> availableSeats;  // List of available seats

    public Flight(String flightNumber, String origin, String destination, String departureTime, List<String> seats) {
        this.flightNumber = flightNumber;
        this.origin = origin;
        this.destination = destination;
        this.departureTime = departureTime;
        this.passengers = new ArrayList<>();
        this.availableSeats = new ArrayList<>(seats);  // Initialize with given seat list
    }

    public void addPassenger(Passenger passenger, String seatNumber) {
        passengers.add(passenger);
        availableSeats.remove(seatNumber);  // Remove seat once booked
    }

    public boolean isSeatAvailable(String seatNumber) {
        return availableSeats.contains(seatNumber);
    }

    public List<String> getAvailableSeats() {
        return availableSeats;
    }

    public void removePassenger(Passenger passenger) {
        passengers.remove(passenger);
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDestination() {
        return destination;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

  

    @Override
    public String toString() {
        return "Flight " + flightNumber + " from " + origin + " to " + destination + " at " + departureTime;
       
    }
}
