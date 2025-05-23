import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;

public class flightgui extends JFrame {

    public flightgui() {
        // Setting up the GUI window
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        FlightSchedule schedule = new FlightSchedule();
        initializeSchedule(schedule);

        // Create a table model and set column names
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new Object[]{"Flight Number","Flight Code", "Departure", "Arrival"});

        for (ScheduledFlight flight : schedule.getFlights()) {
            model.addRow(new Object[]{
                flight.getFlightNumber(),
                flight.getFlightcode(),
                flight.getDeparture(),
                flight.getArrival(),
               
            });
        }

        // Create a JTable with the model
        JTable table = new JTable(model);
        table.setBackground(Color.WHITE);
        JScrollPane scrollPane = new JScrollPane(table); // Add the table to a scroll pane
        scrollPane.setBounds(2, 25, 800, 500);  // Set the bounds for the scroll pane
        add(scrollPane); // Add the scroll pane (containing the table) to the frame

        // Setting frame properties
        setSize(800, 500);
        setLocation(250, 100);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }

    // Initialize the schedule with sample data
    private void initializeSchedule(FlightSchedule schedule) {
        schedule.addFlight(new ScheduledFlight("FL123", "F387","New York", "London"));
        schedule.addFlight(new ScheduledFlight("FL456", "F367","London", "Paris"));
        schedule.addFlight(new ScheduledFlight("FL789", "F457","Paris", "Rome"));
        schedule.addFlight(new ScheduledFlight("Pk4004","F3007","Pakistan", "Swedan"));
 
    }

   
    public static void main(String[] args) {
        new flightgui();
    }
}
