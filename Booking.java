import java.util.ArrayList;

import java.util.List;
class bookingdb {
 
    private static List<Booking> bookings;

    private bookingdb() {
        bookings = new ArrayList<>();
    }

    public static boolean addBooking(Booking booking) {
        return bookings.add(booking);
    }

    public List<Booking> getAllBookings() {
        return new ArrayList<>(bookings);
    }

} 
class Booking {
    private String cnic;
    private String name;
    private String passportNumber;
    private String phoneNumber;
    private String nationality;
    private String gender;
    private String flightNumber;
    private String flightCode;
    private String departure;
    private String arrival;
    private String date;

    public Booking(String cnic, String name, String passportNumber, String phoneNumber, String nationality, String gender,
                   String flightNumber, String flightCode, String departure, String arrival, String date) {
        this.cnic = cnic;
        this.name = name;
        this.passportNumber = passportNumber;
        this.phoneNumber = phoneNumber;
        this.nationality = nationality;
        this.gender = gender;
        this.flightNumber = flightNumber;
        this.flightCode = flightCode;
        this.departure = departure;
        this.arrival = arrival;
        this.date = date;
    }

  
    public String getCNIC() { return cnic; }
    public String getName() { return name; }
    public String getPassportNumber() { return passportNumber; }
    public String getPhoneNumber() { return phoneNumber; }
    public String getNationality() { return nationality; }
    public String getGender() { return gender; }
    public String getFlightNumber() { return flightNumber; }
    public String getFlightCode() { return flightCode; }
    public String getDeparture() { return departure; }
    public String getArrival() { return arrival; }
    public String getDate() { return date; }
    @Override
    public String toString() {
        return String.join(",", cnic, name, passportNumber, phoneNumber, nationality, gender, flightNumber, flightCode, departure, arrival, date);
    }

   

  
}
