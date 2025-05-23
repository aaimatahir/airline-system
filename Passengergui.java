import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Passengergui extends JFrame implements ActionListener {
    private JButton save;
    private JTextField text, cnic, age, phoneNumber;
    private JRadioButton rmale, rfemale;

    public Passengergui() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Add Passenger Details");
        heading.setBounds(300, 30, 300, 30);
        heading.setFont(new Font("Times New Roman", Font.BOLD, 24));
        heading.setForeground(Color.BLUE);
        add(heading);

        JLabel lblname = new JLabel("Name");
        lblname.setBounds(60, 80, 150, 25);
        lblname.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(lblname);

        text = new JTextField();
        text.setBounds(220, 80, 150, 25);
        add(text);

        JLabel gender = new JLabel("Gender");
        gender.setBounds(60, 170, 150, 25);
        gender.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(gender);

        ButtonGroup genderGroup = new ButtonGroup();

        rmale = new JRadioButton("Male");
        rmale.setBounds(220, 170, 70, 25);
        rmale.setBackground(Color.WHITE);
        add(rmale);

        rfemale = new JRadioButton("Female");
        rfemale.setBounds(300, 170, 70, 25);
        rfemale.setBackground(Color.WHITE);
        add(rfemale);

        genderGroup.add(rmale);
        genderGroup.add(rfemale);

        JLabel lblcnic = new JLabel("CNIC");
        lblcnic.setBounds(60, 220, 150, 25);
        lblcnic.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(lblcnic);

        cnic = new JTextField();
        cnic.setBounds(220, 220, 150, 25);
        add(cnic);

        JLabel lblphone = new JLabel("Phone Number");
        lblphone.setBounds(60, 270, 150, 25);
        lblphone.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(lblphone);

        phoneNumber = new JTextField();
        phoneNumber.setBounds(220, 270, 150, 25);
        add(phoneNumber);

        JLabel lbage = new JLabel("Age");
        lbage.setBounds(60, 320, 150, 25);
        lbage.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(lbage);

        age = new JTextField();
        age.setBounds(220, 320, 150, 25);
        add(age);

        save = new JButton("Save");
        save.setBackground(Color.BLACK);
        save.setForeground(Color.WHITE);
        save.setBounds(220, 400, 150, 30);
        save.addActionListener(this);
        add(save);

        setSize(900, 600);
        setLocation(230, 70);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == save) {
            // Get values from the form
            String name = text.getText().trim();
            String ageValue = age.getText().trim();
            String cnicValue = cnic.getText().trim();
            String phoneNumberValue = phoneNumber.getText().trim();
            String genderValue = null;

            if (rmale.isSelected()) {
                genderValue = "Male";
            } else if (rfemale.isSelected()) {
                genderValue = "Female";
            }

            // Input validation
            if (name.isEmpty() || ageValue.isEmpty() || cnicValue.isEmpty() || phoneNumberValue.isEmpty() || genderValue == null) {
                JOptionPane.showMessageDialog(null, "Please fill all the fields.", "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Example: Create Passenger object with the obtained values
            Passenger passenger = new Passenger(name, ageValue, phoneNumberValue, cnicValue, genderValue);

            // Commented out for now: Save passenger to the database
            // if (passengerdb.findPassengerByCNIC(cnicValue) != null) {
            //    JOptionPane.showMessageDialog(null, "A passenger with this CNIC already exists.", "Duplicate Entry", JOptionPane.WARNING_MESSAGE);
            //    return;
            // }
            // passengerdb.addPassenger(passenger);

            // Output to console (for testing)
            System.out.println("Added passenger: " + passenger);

            // Clear fields after saving
            clearFields();

            JOptionPane.showMessageDialog(null, "Passenger Details Added Successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void clearFields() {
        text.setText("");
        age.setText("");
        cnic.setText("");
        phoneNumber.setText("");
        rmale.setSelected(false);
        rfemale.setSelected(false);
    }

    public static void main(String[] args) {
        new Passengergui();
    }
}
