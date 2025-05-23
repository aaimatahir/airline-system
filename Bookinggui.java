import java.awt.Choice;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Bookinggui<JDateChooser> extends JFrame implements ActionListener {
    JButton save,fetch,FetchFlight,bookflight;
    JLabel heading,text,lbldep,lblarrival;
    JLabel lblname,lblFcode,lblFNumber,lbldate;
    JLabel lblpassportno, phone, nationality,passportNumber;
    JLabel lblcnic, lblphone, lblnationality;
    JDateChooser dcdate;
    JLabel lblgender;
    JTextField cnic;
    Choice dep,arrival;
    FlightSchedule schedule;
   

    public Bookinggui () {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        heading = new JLabel("Book Flight");
        heading.setBounds(420, 20, 500, 35);
        heading.setFont(new Font("Times New Roman", Font.BOLD, 24));
        heading.setForeground(Color.BLUE);
        add(heading);

        lblcnic = new JLabel("CNIC");
        lblcnic.setBounds(60, 80, 150, 25);
        lblcnic.setFont(new Font("Times New Roman", Font.BOLD, 15));
        add(lblcnic);

        cnic = new JTextField();
        cnic.setBounds(220, 80, 150, 25);
        add(cnic);

        //fetch button
        fetch=new JButton("Fetch");
        fetch.setBackground(Color.BLACK);
        fetch.setForeground(Color.WHITE);
        fetch.setBounds(380,80,120,25);
        fetch.addActionListener(this);
        add(fetch);

        // for name
        lblname = new JLabel("Name");
        lblname.setBounds(60, 120, 150, 20);
        lblname.setFont(new Font("Times New Roman", Font.BOLD, 15));
        add(lblname);

        text = new JLabel();
        text.setBounds(220, 120, 130, 20);
        add(text);

        // for passport number
        lblpassportno = new JLabel("Passport Number");
        lblpassportno.setBounds(60, 160, 150, 20);
        lblpassportno.setFont(new Font("Times New Roman", Font.BOLD, 15));
        add(lblpassportno);

        passportNumber = new JLabel();
        passportNumber.setBounds(220, 160, 150, 20);
        add(passportNumber);

        lblphone = new JLabel("Phone Number");
        lblphone.setBounds(60, 200, 150, 25);
        lblphone.setFont(new Font("Times New Roman", Font.BOLD, 15));
        add(lblphone);

        phone = new JLabel();
        phone.setBounds(220, 200, 150, 20);
        add(phone);

        lblnationality = new JLabel("Nationality");
        lblnationality.setBounds(60, 240, 150, 20);
        lblnationality.setFont(new Font("Times New Roman", Font.BOLD, 15));
        add(lblnationality);

        nationality = new JLabel();
        nationality.setBounds(220, 240, 150, 20);
        add(nationality);

        lblgender = new JLabel("Gender");
        lblgender.setBounds(60, 280, 150, 20);
        lblgender.setFont(new Font("Times New Roman", Font.BOLD, 15));
        add(lblgender);

        lblgender = new JLabel();
        lblgender.setBounds(220, 280, 150, 20);
        add(lblgender);

        lbldep = new JLabel("Departure");
        lbldep.setBounds(60, 320, 150, 20);
        lbldep.setFont(new Font("Times New Roman", Font.BOLD, 15));
        add(lbldep);

        dep=new Choice();
        dep.setBounds(220,320,150,25);
        dep.add("New York");
        dep.add("Paris");
        dep.add("London");
        dep.add("Pakistan");
        add(dep);

        lblarrival = new JLabel("Arrival");
        lblarrival.setBounds(60, 370, 150, 20);
        lblarrival.setFont(new Font("Times New Roman", Font.BOLD, 15));
        add(lblarrival);

        arrival=new Choice();
        arrival.setBounds(220,370,150,25);
        arrival.add("London");
        arrival.add("Paris");
        arrival.add("Rome");
        arrival.add("Swedan");
        add(arrival);

        FetchFlight = new JButton("Fetch Flight");
        FetchFlight.setBackground(Color.BLACK);
        FetchFlight.setForeground(Color.WHITE);
        FetchFlight.setBounds(380, 320, 120, 25);
        FetchFlight.addActionListener(this);
        add(FetchFlight);

        lblFNumber = new JLabel("Flight Number");
        lblFNumber.setBounds(60, 410, 150, 25);
        lblFNumber.setFont(new Font("Times New Roman", Font.BOLD, 15));
        add(lblFNumber);

       lblFNumber = new JLabel();
       lblFNumber.setBounds(220, 410, 150, 25);
        add(lblFNumber);

         lblFcode = new JLabel("Flight Code");
        lblFcode.setBounds(60, 450, 150, 25);
        lblFcode.setFont(new Font("Times New Roman", Font.BOLD, 15));
        add(lblFcode);

        lblFcode = new JLabel();
        lblFcode.setBounds(220, 450, 150, 25);
        add(lblFcode);

        lbldate = new JLabel("Date of Travel");
        lbldate.setBounds(60, 490, 150, 25);
        lbldate.setFont(new Font("Times New Roman", Font.BOLD, 15));
        add(lbldate);

         
        ((Component) dcdate).setBounds(220, 490, 150, 25);  
        add((Component) dcdate);


        bookflight = new JButton("Book Flight");
        bookflight.setBackground(Color.BLACK);
        bookflight.setForeground(Color.WHITE);
        bookflight.setBounds(220, 550, 150, 25);
        bookflight.addActionListener(this);
        add(bookflight);

        schedule = new FlightSchedule();
        initializeSchedule(schedule);
        
        setSize(1100, 650);
        setLocation(120, 25);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        
    }
   
    
   private void initializeSchedule(FlightSchedule schedule) {
        schedule.addFlight(new ScheduledFlight("FL123", "F387", "New York", "London"));
        schedule.addFlight(new ScheduledFlight("FL456", "F367", "London", "Paris"));
        schedule.addFlight(new ScheduledFlight("FL789", "F457", "Paris", "Rome"));
        schedule.addFlight(new ScheduledFlight("PK4004", "F3007", "Pakistan", "Swedan"));
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == fetch) {
            String cnicValue = cnic.getText().trim();
            
            // Check if CNIC field is empty
            if (cnicValue.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter a CNIC.", "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
    
            System.out.println("Searching for CNIC: " + cnicValue);
    
            // Find passenger by CNIC
            Passenger passenger = passengerdb.findPassengerByCNIC(cnicValue);
    
            // Update GUI with passenger details or show an error if not found
            if (passenger != null) {
                text.setText(passenger.getName());
                passportNumber.setText(passenger.getPassportNumber());
                phone.setText(passenger.getPhoneNumber());
                nationality.setText(passenger.getNationality());
                lblgender.setText(passenger.getGender());
                JOptionPane.showMessageDialog(null, "Passenger details fetched successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "No passenger found with the given CNIC.", "Not Found", JOptionPane.WARNING_MESSAGE);
               
            }
        }
        
        
        else if (ae.getSource() == FetchFlight) {
            String depValue = dep.getSelectedItem();
            String arrivalValue = arrival.getSelectedItem();

            ScheduledFlight matchedFlight = null;
            for (ScheduledFlight flight : schedule.getFlights()) {
                if (flight.getDeparture().equals(depValue) && flight.getArrival().equals(arrivalValue)) {
                    matchedFlight = flight;
                    break;
                }
            }

            if (matchedFlight != null) {
                lblFNumber.setText(matchedFlight.getFlightNumber());
                lblFcode.setText(matchedFlight.getFlightcode());
                JOptionPane.showMessageDialog(null, "Flight found!", "Success", JOptionPane.INFORMATION_MESSAGE);
            } else {
                lblFNumber.setText("");
                lblFcode.setText("");
                JOptionPane.showMessageDialog(null, "No matching flight found.", "Not Found", JOptionPane.WARNING_MESSAGE);
            }
        } else if (ae.getSource() == bookflight) {
            bookFlight();
        }
    }

    private void bookFlight() {
        if (cnic.getText().isEmpty() || text.getText().isEmpty() ||
            passportNumber.getText().isEmpty() || phone.getText().isEmpty() ||
            nationality.getText().isEmpty() || lblgender.getText().isEmpty() ||
            lblFNumber.getText().isEmpty() || lblFcode.getText().isEmpty() ||
            ((Booking) dcdate).getDate() == null) {
            
            JOptionPane.showMessageDialog(this, "Please fill in all fields and select a flight before booking.",
                    "Incomplete Information", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String dateStr = dateFormat.format(((Booking) dcdate).getDate());
        
        Booking newBooking = new Booking(
            cnic.getText(),
            text.getText(),
            passportNumber.getText(),
            phone.getText(),
            nationality.getText(),
            lblgender.getText(),
            lblFNumber.getText(),
            lblFcode.getText(),
            dep.getSelectedItem(),
            arrival.getSelectedItem(),
            dateStr
        );
        
       
        boolean success= saveBookingToFile(newBooking);
        
        if (success) {
            JOptionPane.showMessageDialog(this, "Flight booked successfully!");
        } else {
            
            JOptionPane.showMessageDialog(this, "Error booking flights");
        }
        
        clearForm();
    }
    private boolean saveBookingToFile(Booking newBooking) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Booking.txt", true))) {
            String bookingStr = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s",
            newBooking.getCNIC(),
            newBooking.getName(),
            newBooking.getPassportNumber(),
            newBooking.getPhoneNumber(),
            newBooking.getNationality(),
            newBooking.getGender(),
            newBooking.getFlightNumber(),
            newBooking.getFlightCode(),
            newBooking.getDeparture(),
            newBooking.getArrival(),
            newBooking.getDate()
            );
            System.out.println("Writing to file: " + bookingStr); // Debug log
            writer.write(bookingStr);
            writer.newLine();
            writer.flush(); // Ensure data is written immediately
            System.out.println("Booking details saved successfully");
            return true;
        } catch (IOException e) {
            System.out.println("Error occurred while saving details: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    private void clearForm() {
        cnic.setText("");
        text.setText("");
        passportNumber.setText("");
        phone.setText("");
        nationality.setText("");
        lblgender.setText("");
        lblFNumber.setText("");
        lblFcode.setText("");
        dep.select(0);
        arrival.select(0);
        
    }

    @SuppressWarnings("rawtypes")
    public static void main(String[] args) {
        new Bookinggui();
    }
}
