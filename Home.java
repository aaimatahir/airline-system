import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Home extends JFrame implements ActionListener{
    public Home(){
        try{
        setLayout(null);
   JLabel heading =new JLabel("PAKISTAN INTERNATIONAL AIRLINES");
        heading.setBounds(360,50,1000,40);
        heading.setForeground(Color.GREEN);
        heading.setFont(new Font("Times new Roman",Font.PLAIN,36));
        //to show it on the top of image
      

        JMenuBar menuBar=new JMenuBar();
        setJMenuBar(menuBar);
        JMenu Flight =new JMenu("Flight");
        menuBar.add(Flight);

        JMenuItem flightDetails=new JMenuItem("Flight Details");
        flightDetails.addActionListener(this);
        //add in details menu
        Flight.add(flightDetails);

        JMenu Passenger =new JMenu("Passenger");
        menuBar.add(Passenger);

        JMenuItem PassengerDetails=new JMenuItem("Passenger Details");
        PassengerDetails.addActionListener(this);
        //add in details menu
        Passenger.add(PassengerDetails);

        JMenu Bookings =new JMenu("Bookings");
        menuBar.add(Bookings);

        JMenuItem BookingDetails=new JMenuItem("Booking Details");
        BookingDetails.addActionListener(this);
        //add in details menu
        Bookings.add(BookingDetails);

        JMenu cancel =new JMenu("Cancelation");
        menuBar.add(cancel);

        JMenuItem TicketDetails=new JMenuItem("Flight Cancelation");
        TicketDetails.addActionListener(this);
        //add in details menu
        cancel.add(TicketDetails);

        
        JMenu Ticket =new JMenu("Generate Boarding Pass ");
        menuBar.add(Ticket);

        JMenuItem BoardingPass =new JMenuItem("Boarding Pass");
        BoardingPass.addActionListener(this);
        Ticket.add(BoardingPass);

       //set to full screen
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);

    }
           catch(Exception e){
           System.out.println("The Resource not found");
           e.printStackTrace();
        }
       
    }
    public void actionPerformed(ActionEvent e){
        String Text=e.getActionCommand();
        if(Text.equals("Passenger Details")){
             new Passengergui();
        }else if(Text.equals("Flight Details")){
           new flightgui();
        }
        else if(Text.equals("Booking Details")){
            new Bookinggui();
        }
        else if(Text.equals("Flight Cancelation")){
            new CancelTicket();
        }
        else if(Text.equals("Boarding Pass")){
            try {
                System.out.println("Opening Boarding Pass...");
                new BoardingPass();
            } catch (Exception ex) {
                System.out.println("Error opening Boarding Pass:");
                ex.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new Home();
    }
}