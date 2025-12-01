package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

public class BalanceEnquiry extends JFrame implements ActionListener {
    String pin;
    JLabel label2;
    JButton b1;

    BalanceEnquiry(String pin) {
        this.pin = pin;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1550, 830, Image.SCALE_DEFAULT);
        JLabel l3 = new JLabel(new ImageIcon(i2));
        l3.setBounds(0, 0, 1550, 830);
        add(l3);

        JLabel label1 = new JLabel("Your Current Balance is Rs ");
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("System", Font.BOLD, 16));
        label1.setBounds(430, 180, 700, 35);
        l3.add(label1);

        label2 = new JLabel();
        label2.setForeground(Color.WHITE);
        label2.setFont(new Font("System", Font.BOLD, 16));
        label2.setBounds(430, 220, 400, 35);
        l3.add(label2);

        b1 = new JButton("Back");
        b1.setBounds(700, 406, 150, 35);
        b1.setBackground(new Color(65, 125, 128));
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        l3.add(b1);

        // 🔹 Always use long for safety
        long balance = 0;

        try {
            Con c = new Con();
            ResultSet resultSet = c.statement.executeQuery("SELECT * FROM bank WHERE pin = '" + pin + "'");
            while (resultSet.next()) {
                String type = resultSet.getString("type");
                long amount = Long.parseLong(resultSet.getString("amount"));

                if (type.equalsIgnoreCase("Deposit")) {
                    balance += amount;
                } else if (type.equalsIgnoreCase("Withdrawal")) {
                    balance -= amount;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
        label2.setText("" + balance);
        setLayout(null);
        setSize(1550, 1080);
        setLocation(0, 0);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new main_Class(pin);
    }
    public static void main(String[] args) {
        new BalanceEnquiry("");
    }
}
