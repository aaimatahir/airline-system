import java.util.ArrayList;
import java.util.List;

class ScheduledFlight {
    private String flightNumber;
    private String departure;
    private String arrival;
    private String flightcode;

    public ScheduledFlight(String flightNumber,String flightcode, String departure, String arrival) {
        this.flightNumber = flightNumber;
        this.departure = departure;
        this.arrival = arrival;
        this.flightcode=flightcode;
    }
    public String getFlightcode() { return flightcode; }
    public String getFlightNumber() { return flightNumber; }
    public String getDeparture() { return departure; }
    public String getArrival() { return arrival; }
}

class FlightSchedule {
    private List<ScheduledFlight> flights = new ArrayList<>();

    public void addFlight(ScheduledFlight flight) {
        flights.add(flight);
    }
    public List<ScheduledFlight> getFlights() {
        return flights;
    }

    public void displaySchedule() {
        System.out.println("Scheduled Flights:");
        System.out.printf("%-15s | %-15s | %-15s | %-20s\n", 
                          "Flight Number", "Flight Code", "Departure", "Arrival");
        System.out.println("-------------------------------------------------------------------------------------");
        for (ScheduledFlight flight : flights) {
            System.out.printf("%-15s | %-15s | %-15s | %-20s\n",
                flight.getFlightNumber(),
                flight.getFlightcode(),   
                flight.getDeparture(),
                flight.getArrival()
            );
        }
    }
    
}
public class Flightdb {
    public static void main(String[] args) {
        FlightSchedule schedule = new FlightSchedule();

        // Add sample scheduled flights
        schedule.addFlight(new ScheduledFlight("FL123","F387", "New York", "London"));
        schedule.addFlight(new ScheduledFlight("FL456","F367", "London", "Paris"));
        schedule.addFlight(new ScheduledFlight("FL789","F457", "Paris", "Rome"));

        // Display the schedule
        schedule.displaySchedule();
    }
}
