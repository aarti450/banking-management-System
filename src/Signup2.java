package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Signup2 extends JFrame implements ActionListener {

    JComboBox comboBox, comboBox2, comboBox3, comboBox4, comboBox5;
    JTextField textPan, textAadhar;
    JRadioButton r1, r2, e1, e2;
    JButton next;
    String formno;

    Signup2(String formno) {
        super("APPLICATION FORM - PAGE 2");

        this.formno = formno;
        setLayout(null);
        getContentPane().setBackground(new Color(252, 208, 76));
        setSize(850, 750);
        setLocation(450, 80);

        // Logo
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        JLabel image = new JLabel(new ImageIcon(i2));
        image.setBounds(25, 10, 100, 100);
        add(image);

        // Headings
        JLabel l1 = new JLabel("Page 2: Additional Details");
        l1.setFont(new Font("Raleway", Font.BOLD, 26));
        l1.setBounds(250, 30, 600, 40);
        add(l1);

        JLabel lForm = new JLabel("Form No: " + formno);
        lForm.setFont(new Font("Raleway", Font.BOLD, 14));
        lForm.setBounds(700, 10, 150, 30);
        add(lForm);

        // Religion
        JLabel l3 = new JLabel("Religion :");
        l3.setFont(new Font("Raleway", Font.BOLD, 18));
        l3.setBounds(100, 120, 150, 30);
        add(l3);

        String religion[] = {"Hindu", "Muslim", "Sikh", "Christian", "Other"};
        comboBox = new JComboBox(religion);
        comboBox.setBackground(Color.WHITE);
        comboBox.setBounds(350, 120, 320, 30);
        add(comboBox);

        // Category
        JLabel l4 = new JLabel("Category :");
        l4.setFont(new Font("Raleway", Font.BOLD, 18));
        l4.setBounds(100, 170, 150, 30);
        add(l4);

        String category[] = {"General", "OBC", "SC", "ST", "Other"};
        comboBox2 = new JComboBox(category);
        comboBox2.setBackground(Color.WHITE);
        comboBox2.setBounds(350, 170, 320, 30);
        add(comboBox2);

        // Income
        JLabel l5 = new JLabel("Income :");
        l5.setFont(new Font("Raleway", Font.BOLD, 18));
        l5.setBounds(100, 220, 150, 30);
        add(l5);

        String income[] = {"Null", "<50,000", "<2,50,000", "<5,00,000", "Upto 10,00,000", "Above 10,00,000"};
        comboBox3 = new JComboBox(income);
        comboBox3.setBackground(Color.WHITE);
        comboBox3.setBounds(350, 220, 320, 30);
        add(comboBox3);

        // Education
        JLabel l6 = new JLabel("Educational :");
        l6.setFont(new Font("Raleway", Font.BOLD, 18));
        l6.setBounds(100, 270, 150, 30);
        add(l6);

        String educational[] = {"Non-Graduate", "Graduate", "Post-Graduate", "Doctorate", "Others"};
        comboBox4 = new JComboBox(educational);
        comboBox4.setBackground(Color.WHITE);
        comboBox4.setBounds(350, 270, 320, 30);
        add(comboBox4);

        // Occupation
        JLabel l7 = new JLabel("Occupation :");
        l7.setFont(new Font("Raleway", Font.BOLD, 18));
        l7.setBounds(100, 320, 150, 30);
        add(l7);

        String occupation[] = {"Salaried", "Self-Employed", "Business", "Student", "Retired", "Other"};
        comboBox5 = new JComboBox(occupation);
        comboBox5.setBackground(Color.WHITE);
        comboBox5.setBounds(350, 320, 320, 30);
        add(comboBox5);

        // PAN
        JLabel l8 = new JLabel("PAN Number :");
        l8.setFont(new Font("Raleway", Font.BOLD, 18));
        l8.setBounds(100, 370, 150, 30);
        add(l8);

        textPan = new JTextField();
        textPan.setFont(new Font("Raleway", Font.PLAIN, 14));
        textPan.setBounds(350, 370, 320, 30);
        add(textPan);

        // Aadhar
        JLabel l9 = new JLabel("Aadhar Number :");
        l9.setFont(new Font("Raleway", Font.BOLD, 18));
        l9.setBounds(100, 420, 200, 30);
        add(l9);

        textAadhar = new JTextField();
        textAadhar.setFont(new Font("Raleway", Font.PLAIN, 14));
        textAadhar.setBounds(350, 420, 320, 30);
        add(textAadhar);

        // Senior Citizen
        JLabel l10 = new JLabel("Senior Citizen :");
        l10.setFont(new Font("Raleway", Font.BOLD, 18));
        l10.setBounds(100, 470, 200, 30);
        add(l10);

        r1 = new JRadioButton("Yes");
        r1.setBackground(new Color(252, 208, 76));
        r1.setFont(new Font("Raleway", Font.PLAIN, 14));
        r1.setBounds(350, 470, 100, 30);
        add(r1);

        r2 = new JRadioButton("No");
        r2.setBackground(new Color(252, 208, 76));
        r2.setFont(new Font("Raleway", Font.PLAIN, 14));
        r2.setBounds(460, 470, 100, 30);
        add(r2);

        ButtonGroup seniorGroup = new ButtonGroup();
        seniorGroup.add(r1);
        seniorGroup.add(r2);

        // Existing Account
        JLabel l11 = new JLabel("Existing Account :");
        l11.setFont(new Font("Raleway", Font.BOLD, 18));
        l11.setBounds(100, 520, 200, 30);
        add(l11);

        e1 = new JRadioButton("Yes");
        e1.setBackground(new Color(252, 208, 76));
        e1.setFont(new Font("Raleway", Font.PLAIN, 14));
        e1.setBounds(350, 520, 100, 30);
        add(e1);

        e2 = new JRadioButton("No");
        e2.setBackground(new Color(252, 208, 76));
        e2.setFont(new Font("Raleway", Font.PLAIN, 14));
        e2.setBounds(460, 520, 100, 30);
        add(e2);

        ButtonGroup existingGroup = new ButtonGroup();
        existingGroup.add(e1);
        existingGroup.add(e2);

        // Next Button
        next = new JButton("Next");
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setBounds(570, 600, 100, 30);
        next.addActionListener(this);
        add(next);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String rel = (String) comboBox.getSelectedItem();
        String cate = (String) comboBox2.getSelectedItem();
        String inc = (String) comboBox3.getSelectedItem();
        String edu = (String) comboBox4.getSelectedItem();
        String occ = (String) comboBox5.getSelectedItem();
        String pan = textPan.getText();
        String aadhar = textAadhar.getText();

        String scitizen = r1.isSelected() ? "Yes" : "No";
        String eAccount = e1.isSelected() ? "Yes" : "No";

        try {
            if (pan.equals("") || aadhar.equals("")) {
                JOptionPane.showMessageDialog(null, "Please fill all the fields.");
            } else {
                Con c1 = new Con();
                String q = "INSERT INTO signuptwo VALUES('" + formno + "','" + rel + "','" + cate + "','" + inc + "','" +
                        edu + "','" + occ + "','" + pan + "','" + aadhar + "','" + scitizen + "','" + eAccount + "')";
                c1.statement.executeUpdate(q);
                new Signup3(formno);
                setVisible(false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new Signup2("");
    }
}

