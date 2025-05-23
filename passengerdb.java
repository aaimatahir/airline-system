import java.util.ArrayList;
import java.util.List;

public class passengerdb {
    private static List<Passenger> passengers = new ArrayList<>();

    public static void addPassenger(Passenger passenger) {
        passengers.add(passenger);
        System.out.println("Passenger added to the database successfully.");
    }

    public static List<Passenger> getAllPassengers() {
        return new ArrayList<>(passengers);
    }

    public static void displayAllPassengers() {
        System.out.println("All Passengers:");
        for (Passenger p : passengers) {
            System.out.println(p);
        }
    }

    public static Passenger findPassengerByCNIC(String cnic) {
        System.out.println("Searching for CNIC: " + cnic);
        for (Passenger p : passengers) {
            System.out.println("Comparing with CNIC: " + p.getCnic());
            if (p.getCnic().equals(cnic)) {
                return p;
            }
        }
        return null;
    }
    public static void main(String[] args) {
        // Adding test passengers
        passengerdb.addPassenger(new Passenger("John Doe", "123456", 19, "123-456-7890", "3201", "Male"));
        passengerdb.addPassenger(new Passenger("Jane Doe", "654321", 29, "098-765-4321", "3202", "Female"));
    
        // Launch the GUI
        new Passengergui();
        new Bookinggui();
    }
    
}
