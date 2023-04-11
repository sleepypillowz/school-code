package hci.eventdriven_acojido;

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class EventDriven extends JFrame {

    //Setting Variables
    private JFrame inputFrame;
    private JFrame outputFrame;

    private JPanel inputPane;
    private JPanel outputPane;

    private JLabel labelFirstName;
    private JLabel labelLastName;
    private JLabel labelMiddleName;
    private JLabel labelMobileNumber;
    private JLabel labelEmailAddress;

    private JLabel outputLabelFirstName;
    private JLabel outputLabelLastName;
    private JLabel outputLabelMiddleName;
    private JLabel outputLabelMobileNumber;
    private JLabel outputLabelEmailAddress;

    private JTextField firstName;
    private JTextField lastName;
    private JTextField middleName;
    private JTextField mobileNumber;
    private JTextField emailAddress;

    private JButton buttonSubmit;
    private JButton buttonClearAll;

    private JButton buttonOkay;

    private Font f2;

    private void EventDriven() {

        //Create Objects and define
        //GUI
        inputFrame = new JFrame("INPUT");
        outputFrame = new JFrame("OUTPUT");

        inputPane = new JPanel();
        inputPane.setLayout(new FlowLayout());

        outputPane = new JPanel();
        outputPane.setLayout(new FlowLayout());

        //JLabel
        labelFirstName = new JLabel("First Name:");
        labelLastName = new JLabel("Last Name:");
        labelMiddleName = new JLabel("Middle Name:");
        labelMobileNumber = new JLabel("Mobile Number:");
        labelEmailAddress = new JLabel("Email Address:");

        //JTextField
        firstName = new JTextField(14);
        lastName = new JTextField(14);
        middleName = new JTextField(14);
        mobileNumber = new JTextField(14);
        emailAddress = new JTextField(14);

        //JButton
        buttonSubmit = new JButton("Submit");
        buttonClearAll = new JButton("Clear All");

        //Event Listener
        buttonSubmit.addActionListener(new btnSubmit());
        buttonClearAll.addActionListener(new clearAll());

        //Add to Frame GUI Design     
        inputPane.add(labelFirstName);
        inputPane.add(firstName);
        inputPane.add(labelLastName);
        inputPane.add(lastName);
        inputPane.add(labelMiddleName);
        inputPane.add(middleName);
        inputPane.add(labelMobileNumber);
        inputPane.add(mobileNumber);
        inputPane.add(labelEmailAddress);
        inputPane.add(emailAddress);
        inputPane.add(buttonSubmit);
        inputPane.add(buttonClearAll);

        //Frame Default
        inputFrame.add(inputPane);
        inputFrame.setSize(225, 310);
        inputFrame.setLocationRelativeTo(null);
        inputFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        inputFrame.setVisible(true);

    }

    class btnSubmit implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            //Disable Button
            buttonSubmit.setEnabled(false);

            //Storing User Input
            String valueFirstName = firstName.getText();
            String valueLastName = lastName.getText();
            String valueMiddleName = middleName.getText();
            String valueMobileNumber = mobileNumber.getText();
            String valueEmailAddress = emailAddress.getText();

            //Declaring objects & Showing User Input 
            outputLabelFirstName = new JLabel("First Name: " + valueFirstName);
            outputLabelLastName = new JLabel("Last Name: " + valueLastName);
            outputLabelMiddleName = new JLabel("Middle Name: " + valueMiddleName);
            outputLabelMobileNumber = new JLabel("Mobile No.: " + valueMobileNumber);
            outputLabelEmailAddress = new JLabel("Email Add: " + valueEmailAddress);
            buttonOkay = new JButton("Okay");
            buttonOkay.setAlignmentX(Component.CENTER_ALIGNMENT);

            ///Font Style
            f2 = new Font(Font.SANS_SERIF, Font.PLAIN, 12);
            outputLabelFirstName.setFont(f2);
            outputLabelLastName.setFont(f2);
            outputLabelMiddleName.setFont(f2);
            outputLabelMobileNumber.setFont(f2);
            outputLabelEmailAddress.setFont(f2);

            //Event Listener
            buttonOkay.addActionListener(new clearAll());
            buttonOkay.addActionListener(new btnOkay());

            //Add to GUI2
            outputPane.add(outputLabelFirstName);
            outputPane.add(outputLabelLastName);
            outputPane.add(outputLabelMiddleName);
            outputPane.add(outputLabelMobileNumber);
            outputPane.add(outputLabelEmailAddress);
            outputPane.add(buttonOkay);

            //Frame Default
            outputFrame.add(outputPane);
            outputFrame.setSize(310, 230);
            outputFrame.setLocationRelativeTo(null);
            outputFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            outputFrame.setVisible(true);

        }
    }

    class clearAll implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            //Replace Text with empty string
            firstName.setText("");
            lastName.setText("");
            middleName.setText("");
            mobileNumber.setText("");
            emailAddress.setText("");
        }
    }

    class btnOkay implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            //Remove Old GUI2
            outputPane.remove(outputLabelFirstName);
            outputPane.remove(outputLabelLastName);
            outputPane.remove(outputLabelMiddleName);
            outputPane.remove(outputLabelMobileNumber);
            outputPane.remove(outputLabelEmailAddress);
            outputPane.remove(buttonOkay);

            //GUI1 Button reEnabled & GUI2 Hidden
            buttonSubmit.setEnabled(true);
            outputFrame.setVisible(false);
        }
    }

    public static void main(String[] args) {

        //Instantiate Object & Use
        EventDriven ed = new EventDriven();
        ed.EventDriven();
    }
}
