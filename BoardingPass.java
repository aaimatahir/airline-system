import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
    
    public class BoardingPass extends JFrame implements ActionListener {
        JButton save,enter,FetchFlight,bookflight;
        JLabel heading,text,lbldep,lblarrival;
        JLabel lblname,lblFcode,lblFNumber,lbldate;
        JLabel lblpassportno, phone, nationality,passportNumber;
        JLabel lblcnic, lblnationality;
        
        JLabel lblgender;
        JTextField cnic;
  
       
        public BoardingPass () {
            getContentPane().setBackground(Color.WHITE);
            setLayout(null);
    
            heading = new JLabel("Boarding Pass");
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
            enter=new JButton("Enter");
            enter.setBackground(Color.BLACK);
            enter.setForeground(Color.WHITE);
            enter.setBounds(380,80,120,25);
            enter.addActionListener(this);
            add(enter);
    
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

    
            lblnationality = new JLabel("Nationality");
            lblnationality.setBounds(60, 200, 150, 20);
            lblnationality.setFont(new Font("Times New Roman", Font.BOLD, 15));
            add(lblnationality);
    
            lblnationality = new JLabel();
            lblnationality.setBounds(220, 200, 150, 20);
            add(lblnationality);
    
            lbldep = new JLabel("Departure");
            lbldep.setBounds(60, 250, 150, 20);
            lbldep.setFont(new Font("Times New Roman", Font.BOLD, 15));
            add(lbldep);

            lbldep = new JLabel();
            lbldep.setBounds(220, 250, 150, 25);
             add(lbldep);
    
    
            lblarrival = new JLabel("Arrival");
            lblarrival.setBounds(60, 300, 150, 20);
            lblarrival.setFont(new Font("Times New Roman", Font.BOLD, 15));
            add(lblarrival);

            lblarrival = new JLabel();
            lblarrival.setBounds(220, 300, 150, 25);
             add(lblarrival);
    
    
            lblFNumber = new JLabel("Flight Number");
            lblFNumber.setBounds(60, 350, 150, 25);
            lblFNumber.setFont(new Font("Times New Roman", Font.BOLD, 15));
            add(lblFNumber);
    
           lblFNumber = new JLabel();
           lblFNumber.setBounds(220, 350, 150, 25);
            add(lblFNumber);
    
             lblFcode = new JLabel("Flight Code");
            lblFcode.setBounds(60, 400, 150, 25);
            lblFcode.setFont(new Font("Times New Roman", Font.BOLD, 15));
            add(lblFcode);
    
            lblFcode = new JLabel();
            lblFcode.setBounds(220, 400, 150, 25);
            add(lblFcode);
    
            lbldate = new JLabel("Date of Travel");
            lbldate.setBounds(60, 450, 150, 25);
            lbldate.setFont(new Font("Times New Roman", Font.BOLD, 15));
            add(lbldate);

            lbldate = new JLabel();
            lbldate.setBounds(220, 450, 150, 25);
            add(lbldate);
    
         
            
            setSize(1100, 650);
            setLocation(120, 25);
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            setVisible(true);
            
        }
       
 
        public void actionPerformed(ActionEvent ae) {
            if (ae.getSource() == enter) {
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
                    lblFNumber.setText(booking.getFlightNumber());
                    lblnationality.setText(booking.getNationality());
                    passportNumber.setText(booking.getPassportNumber());
                  
                    JOptionPane.showMessageDialog(null, "Booking details fetched successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "No booking found with the given CNIC.", "Not Found", JOptionPane.WARNING_MESSAGE);
                }
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

        public static void main(String[] args) {
            new BoardingPass();
        }
    }

