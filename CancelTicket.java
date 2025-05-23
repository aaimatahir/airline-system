import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.util.Random;

public class CancelTicket extends JFrame implements ActionListener {
    JButton save,fetch,cancelflight;
    JLabel heading,text,lbldep,lblarrival,lblcancelno;
    JLabel lblname,lblFcode,lblFNumber,lbldate;
    JLabel lblcnic;
    JTextField cnic;
    FlightSchedule schedule;
    

    public CancelTicket() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        Random random =new Random();

        heading = new JLabel("Cancel Flight");
        heading.setBounds(120, 10, 250, 15);
        heading.setFont(new Font("Times New Roman", Font.BOLD, 24));
        add(heading);
        lblcnic = new JLabel("CNIC");
        lblcnic.setBounds(60, 80, 150, 25);
        lblcnic.setFont(new Font("Times New Roman", Font.BOLD, 15));
        add(lblcnic);

        cnic = new JTextField();
        cnic.setBounds(220, 80, 150, 25);
        add(cnic);

        //fetch button
        fetch=new JButton("Show Details ");
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

       lblcancelno = new JLabel("Cancelation Number");
       lblcancelno.setBounds(60, 170, 150, 25);
       lblcancelno.setFont(new Font("Times New Roman", Font.BOLD, 15));
        add(lblcancelno);
              try{
    
       lblcancelno= new JLabel(""+random.nextInt(1000000));
        lblcancelno.setBounds(220, 170, 150, 20);
         add(lblcancelno);
        }catch(Exception e){
          e.printStackTrace();
}
        
        lbldep = new JLabel("Departure");
        lbldep.setBounds(60, 210, 150, 20);
        lbldep.setFont(new Font("Times New Roman", Font.BOLD, 15));
        add(lbldep);

        lbldep = new JLabel();
        lbldep.setBounds(220, 210, 150, 25);
        add(lbldep);

        lblarrival = new JLabel("Arrival");
        lblarrival.setBounds(60, 250, 150, 20);
        lblarrival.setFont(new Font("Times New Roman", Font.BOLD, 15));
        add(lblarrival);
        
        lblarrival = new JLabel();
        lblarrival.setBounds(220, 250, 150, 25);
        add(lblarrival);

         lblFcode = new JLabel("Flight Code");
        lblFcode.setBounds(60, 300, 150, 25);
        lblFcode.setFont(new Font("Times New Roman", Font.BOLD, 15));
        add(lblFcode);

        lblFcode = new JLabel();
        lblFcode.setBounds(220, 300, 150, 25);
        add(lblFcode);

        lbldate = new JLabel("Date of Travel");
        lbldate.setBounds(60, 350, 150, 25);
        lbldate.setFont(new Font("Times New Roman", Font.BOLD, 15));
        add(lbldate);

        lbldate = new JLabel();
        lbldate.setBounds(220, 350, 150, 25);
        add(lbldate);

        cancelflight = new JButton("Cancel Flight");
        cancelflight.setBackground(Color.BLACK);
        cancelflight.setForeground(Color.WHITE);
        cancelflight.setBounds(220, 400, 150, 25);
        cancelflight.addActionListener(this);
        add(cancelflight);

        
        setSize(800, 550);
        setLocation(120, 25);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        
    }
   
 
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == fetch) {
            String cnicValue = cnic.getText().trim();
            
            if (cnicValue.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter a CNIC.", "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Booking booking = findBookingByCNIC(cnicValue);

            if (booking != null) {
                text.setText(booking.getName());
                lbldep.setText(booking.getDeparture());
                lblarrival.setText(booking.getArrival());
                lbldate.setText(booking.getDate());
                lblFcode.setText(booking.getFlightCode());
              
                JOptionPane.showMessageDialog(null, "Booking details fetched successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "No booking found with the given CNIC.", "Not Found", JOptionPane.WARNING_MESSAGE);
                clearFields();
            }
        } else if (ae.getSource() == cancelflight) {
            cancelFlight();
        }
    }

    private Booking findBookingByCNIC(String cnic) {
        try (BufferedReader reader = new BufferedReader(new FileReader("Booking.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 11 && parts[0].equals(cnic)) {
                    return new Booking(parts[0], parts[1], parts[2], parts[3], parts[4], parts[5], parts[6], parts[7], parts[8], parts[9], parts[10]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void cancelFlight() {
        if (cnic.getText().isEmpty() || text.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fetch booking details first.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to cancel this flight?", "Confirm Cancellation", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            if (removeBookingFromFile(cnic.getText())) {
                JOptionPane.showMessageDialog(null, "Flight cancelled successfully. Cancellation number: " + lblcancelno.getText(), "Success", JOptionPane.INFORMATION_MESSAGE);
                clearFields();
            } else {
                JOptionPane.showMessageDialog(null, "Error cancelling flight.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private boolean removeBookingFromFile(String cnic) {
        File inputFile = new File("Booking.txt");
        File tempFile = new File("TempBooking.txt");

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {

            String currentLine;
            while ((currentLine = reader.readLine()) != null) {
                String trimmedLine = currentLine.trim();
                if (trimmedLine.startsWith(cnic + ",")) continue;
                writer.write(currentLine + System.getProperty("line.separator"));
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        return inputFile.delete() && tempFile.renameTo(inputFile);
    }

    private void clearFields() {
        cnic.setText("");
        text.setText("");
        lbldep.setText("");
        lblarrival.setText("");
        lbldate.setText("");
       lblFcode.setText("");
       lblcancelno.setText("");
    }

    public static void main(String[] args) {
        new CancelTicket();
    }
}
