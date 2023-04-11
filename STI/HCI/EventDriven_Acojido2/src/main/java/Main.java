import java.awt.Dimension;
import java.awt.FlowLayout;  
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;  
import javax.swing.JFrame;  
import javax.swing.JLabel;  
import javax.swing.JPanel; 
import javax.swing.JTextField;



public class Main {
    
    
    public static void main(String[] args) {
        //Create GUI
        JFrame frame = new JFrame("INPUT");   //Program 1 Title
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());  
        
        //Create Objects and define
        
        //JLabel
        JLabel labelFirstName = new JLabel("First Name:");
        JLabel labelLastName = new JLabel("Last Name:");
        JLabel labelMiddleName = new JLabel("Middle Name:");
        JLabel labelMobileNumber = new JLabel("Mobile Number:");
        JLabel labelEmailAddress = new JLabel("Email Address");
        
        //JTextField
        JTextField firstName = new JTextField(12);
        JTextField lastName = new JTextField(12); 
        JTextField middleName = new JTextField(12); 
        JTextField mobileNumber = new JTextField(12); 
        JTextField emailAdress = new JTextField(12);  
        
        //JButton
        JButton submit = new JButton("Submit");
        JButton clearall = new JButton("Cler All");   
        
        //Listener
        submit.addActionListener(new ButtonClickListener()); 
        
        //Add to Frame GUI Design
        
        //First name
        panel.add(labelFirstName);
        panel.add(firstName);
        
        //Last Name
        panel.add(labelLastName);   
        panel.add(lastName);
        
        //Middle Name
        panel.add(labelMiddleName);
        panel.add(middleName);
        
        
        //Mobile Number
        panel.add(labelMobileNumber);
        panel.add(mobileNumber);
        
        
        //Email Address
        panel.add(labelEmailAddress);
        panel.add(emailAdress);
        
        
        //Buttons
        panel.add(submit);
        panel.add(clearall);
        
        //Frame
        frame.add(panel); 
        frame.setSize(200, 300);  
        frame.setLocationRelativeTo(null);  
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        frame.setVisible(true);
        

    }

    private static class ButtonClickListener implements ActionListener {

        public ButtonClickListener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Hello");
        }
    }
    

}

