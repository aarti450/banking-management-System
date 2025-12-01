package bank.management.system;

import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Signup extends JFrame implements ActionListener {

    // Components
    JRadioButton r1, r2, r3, m1, m2, m3;
    JButton next;
    JTextField textName, textFname, textEmail, textAdd, textCity, textPin, textState;
    JDateChooser dateChooser;

    // Random form number generator
    Random ran = new Random();
    long first4 = (Math.abs(ran.nextLong()) % 9000L) + 1000L;
    String formno = "" + first4;

    Signup() {
        super("APPLICATION FORM");

        // Frame settings
        setLayout(null);
        getContentPane().setBackground(new Color(222, 255, 228));
        setSize(850, 800);
        setLocation(350, 10);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Logo
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        JLabel image = new JLabel(new ImageIcon(i2));
        image.setBounds(25, 10, 100, 100);
        add(image);

        // Heading
        JLabel label1 = new JLabel("APPLICATION FORM NO. " + formno);
        label1.setFont(new Font("Raleway", Font.BOLD, 30));
        label1.setBounds(160, 20, 600, 40);
        add(label1);

        JLabel label2 = new JLabel("Page 1: Personal Details");
        label2.setFont(new Font("Raleway", Font.BOLD, 22));
        label2.setBounds(250, 70, 600, 30);
        add(label2);

        // Labels and fields
        JLabel labelName = new JLabel("Name :");
        labelName.setFont(new Font("Raleway", Font.BOLD, 20));
        labelName.setBounds(100, 150, 200, 30);
        add(labelName);

        textName = new JTextField();
        textName.setFont(new Font("Raleway", Font.PLAIN, 14));
        textName.setBounds(300, 150, 400, 30);
        add(textName);

        JLabel labelFname = new JLabel("Father's Name :");
        labelFname.setFont(new Font("Raleway", Font.BOLD, 20));
        labelFname.setBounds(100, 200, 200, 30);
        add(labelFname);

        textFname = new JTextField();
        textFname.setFont(new Font("Raleway", Font.PLAIN, 14));
        textFname.setBounds(300, 200, 400, 30);
        add(textFname);

        JLabel labelDob = new JLabel("Date of Birth :");
        labelDob.setFont(new Font("Raleway", Font.BOLD, 20));
        labelDob.setBounds(100, 250, 200, 30);
        add(labelDob);

        dateChooser = new JDateChooser();
        dateChooser.setForeground(new Color(105, 105, 105));
        dateChooser.setBounds(300, 250, 400, 30);
        add(dateChooser);

        JLabel labelGender = new JLabel("Gender :");
        labelGender.setFont(new Font("Raleway", Font.BOLD, 20));
        labelGender.setBounds(100, 300, 200, 30);
        add(labelGender);

        r1 = new JRadioButton("Male");
        r1.setBackground(new Color(222, 255, 228));
        r1.setFont(new Font("Raleway", Font.PLAIN, 14));
        r1.setBounds(300, 300, 100, 30);
        add(r1);

        r2 = new JRadioButton("Female");
        r2.setBackground(new Color(222, 255, 228));
        r2.setFont(new Font("Raleway", Font.PLAIN, 14));
        r2.setBounds(450, 300, 100, 30);
        add(r2);

        r3 = new JRadioButton("Other");
        r3.setBackground(new Color(222, 255, 228));
        r3.setFont(new Font("Raleway", Font.PLAIN, 14));
        r3.setBounds(600, 300, 100, 30);
        add(r3);

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(r1);
        genderGroup.add(r2);
        genderGroup.add(r3);

        JLabel labelEmail = new JLabel("Email :");
        labelEmail.setFont(new Font("Raleway", Font.BOLD, 20));
        labelEmail.setBounds(100, 350, 200, 30);
        add(labelEmail);

        textEmail = new JTextField();
        textEmail.setFont(new Font("Raleway", Font.PLAIN, 14));
        textEmail.setBounds(300, 350, 400, 30);
        add(textEmail);

        JLabel labelMs = new JLabel("Marital Status :");
        labelMs.setFont(new Font("Raleway", Font.BOLD, 20));
        labelMs.setBounds(100, 400, 200, 30);
        add(labelMs);

        m1 = new JRadioButton("Married");
        m1.setBackground(new Color(222, 255, 228));
        m1.setFont(new Font("Raleway", Font.PLAIN, 14));
        m1.setBounds(300, 400, 100, 30);
        add(m1);

        m2 = new JRadioButton("Unmarried");
        m2.setBackground(new Color(222, 255, 228));
        m2.setFont(new Font("Raleway", Font.PLAIN, 14));
        m2.setBounds(450, 400, 120, 30);
        add(m2);

        m3 = new JRadioButton("Other");
        m3.setBackground(new Color(222, 255, 228));
        m3.setFont(new Font("Raleway", Font.PLAIN, 14));
        m3.setBounds(600, 400, 100, 30);
        add(m3);

        ButtonGroup maritalGroup = new ButtonGroup();
        maritalGroup.add(m1);
        maritalGroup.add(m2);
        maritalGroup.add(m3);

        JLabel labelAdd = new JLabel("Address :");
        labelAdd.setFont(new Font("Raleway", Font.BOLD, 20));
        labelAdd.setBounds(100, 450, 200, 30);
        add(labelAdd);

        textAdd = new JTextField();
        textAdd.setFont(new Font("Raleway", Font.PLAIN, 14));
        textAdd.setBounds(300, 450, 400, 30);
        add(textAdd);

        JLabel labelCity = new JLabel("City :");
        labelCity.setFont(new Font("Raleway", Font.BOLD, 20));
        labelCity.setBounds(100, 500, 200, 30);
        add(labelCity);

        textCity = new JTextField();
        textCity.setFont(new Font("Raleway", Font.PLAIN, 14));
        textCity.setBounds(300, 500, 400, 30);
        add(textCity);

        JLabel labelPin = new JLabel("Pin Code :");
        labelPin.setFont(new Font("Raleway", Font.BOLD, 20));
        labelPin.setBounds(100, 550, 200, 30);
        add(labelPin);

        textPin = new JTextField();
        textPin.setFont(new Font("Raleway", Font.PLAIN, 14));
        textPin.setBounds(300, 550, 400, 30);
        add(textPin);

        JLabel labelState = new JLabel("State :");
        labelState.setFont(new Font("Raleway", Font.BOLD, 20));
        labelState.setBounds(100, 600, 200, 30);
        add(labelState);

        textState = new JTextField();
        textState.setFont(new Font("Raleway", Font.PLAIN, 14));
        textState.setBounds(300, 600, 400, 30);
        add(textState);

        next = new JButton("Next");
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setBounds(620, 680, 100, 30);
        next.addActionListener(this);
        add(next);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String name = textName.getText();
        String fname = textFname.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = r1.isSelected() ? "Male" : r2.isSelected() ? "Female" : "Other";
        String email = textEmail.getText();
        String marital = m1.isSelected() ? "Married" : m2.isSelected() ? "Unmarried" : "Other";
        String address = textAdd.getText();
        String city = textCity.getText();
        String pincode = textPin.getText();
        String state = textState.getText();

        try {
            if (name.equals("") || fname.equals("") || dob.equals("") || email.equals("") || address.equals("") ||
                    city.equals("") || pincode.equals("") || state.equals("")) {
                JOptionPane.showMessageDialog(null, "Please fill all the required fields.");
            } else {
                Con con1 = new Con();
                String q = "INSERT INTO signup VALUES('" + formno + "','" + name + "','" + fname + "','" + dob + "','" +
                        gender + "','" + email + "','" + marital + "','" + address + "','" + city + "','" + pincode + "','" + state + "')";
                con1.statement.executeUpdate(q);
                new Signup2(formno);
                setVisible(false);
            }
        } catch (Exception E) {
            E.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new Signup();
    }
}
