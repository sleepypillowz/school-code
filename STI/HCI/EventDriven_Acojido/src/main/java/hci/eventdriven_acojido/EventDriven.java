package hci.eventdriven_acojido;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class EventDriven extends JFrame {

    //Setting Variables
    private JFrame mainFrame;
    private JPanel controlPanel;
    
    private JLabel labelFirstName;
    private JLabel labelLastName;
    private JLabel labelMiddleName;
    private JLabel labelMobileNumber;
    private JLabel labelEmailAddress;
    
    private JTextField firstName;
    private JTextField lastName;
    private JTextField middleName;
    private JTextField mobileNumber;
    private JTextField emailAddress;
    
    private JButton submit;
    private JButton clearall;
        
    private void EventDriven() {

        //Create GUI
        mainFrame = new JFrame("INPUT");   //Program 1 Title
        controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());

        //Create Objects and define
        //JLabel
        labelFirstName = new JLabel("First Name:");
        labelLastName = new JLabel("Last Name:");
        labelMiddleName = new JLabel("Middle Name:");
        labelMobileNumber = new JLabel("Mobile Number:");
        labelEmailAddress = new JLabel("Email Address");

        //JTextField
        firstName = new JTextField(12);
        lastName = new JTextField(12);
        middleName = new JTextField(12);
        mobileNumber = new JTextField(12);
        emailAddress = new JTextField(12);

        //JButton
        submit = new JButton("Submit");
        clearall = new JButton("Cler All");

        //Event Listener
        submit.addActionListener(new btnSubmit());

        //Add to Frame GUI Design
        //First name
        controlPanel.add(labelFirstName);
        controlPanel.add(firstName);

        //Last Name
        controlPanel.add(labelLastName);
        controlPanel.add(lastName);

        //Middle Name
        controlPanel.add(labelMiddleName);
        controlPanel.add(middleName);

        //Mobile Number
        controlPanel.add(labelMobileNumber);
        controlPanel.add(mobileNumber);

        //Email Address
        controlPanel.add(labelEmailAddress);
        controlPanel.add(emailAddress);

        //Buttons
        controlPanel.add(submit);
        controlPanel.add(clearall);

        //Frame
        mainFrame.add(controlPanel);
        mainFrame.setSize(200, 300);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
    }

    class btnSubmit implements ActionListener {

        public btnSubmit() {

        }

        @Override
        public void actionPerformed(ActionEvent e) {
            submit.setEnabled(false);
        }
    }

    public static void main(String[] args) {
        EventDriven ed = new EventDriven();
        ed.EventDriven();
    }
}
