package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;
import javax.swing.*;

public class Withdrawl extends JFrame implements ActionListener {
    String pin;
    TextField textField;
    JButton b1, b2;

    Withdrawl(String pin) {
        this.pin = pin;

        // Background image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1550, 830, Image.SCALE_DEFAULT);
        JLabel l3 = new JLabel(new ImageIcon(i2));
        l3.setBounds(0, 0, 1550, 830);
        add(l3);

        // Labels
        JLabel label1 = new JLabel("MAXIMUM WITHDRAWAL IS RS.10,000");
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("System", Font.BOLD, 16));
        label1.setBounds(460, 180, 700, 35);
        l3.add(label1);

        JLabel label2 = new JLabel("PLEASE ENTER YOUR AMOUNT");
        label2.setForeground(Color.WHITE);
        label2.setFont(new Font("System", Font.BOLD, 16));
        label2.setBounds(460, 220, 400, 35);
        l3.add(label2);

        // Input field
        textField = new TextField();
        textField.setBackground(new Color(65, 125, 128));
        textField.setForeground(Color.WHITE);
        textField.setBounds(460, 260, 320, 25);
        textField.setFont(new Font("Raleway", Font.BOLD, 22));
        l3.add(textField);

        // Withdraw button
        b1 = new JButton("WITHDRAW");
        b1.setBounds(700, 362, 150, 35);
        b1.setBackground(new Color(65, 125, 128));
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        l3.add(b1);

        // Back button
        b2 = new JButton("BACK");
        b2.setBounds(700, 406, 150, 35);
        b2.setBackground(new Color(65, 125, 128));
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        l3.add(b2);

        // Frame settings
        setLayout(null);
        setSize(1550, 1080);
        setLocation(0, 0);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            String amountText = textField.getText().trim();

            if (amountText.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter the Amount you want to withdraw");
                return;
            }

            long amount = 0;
            try {
                amount = Long.parseLong(amountText);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Please enter a valid number amount");
                return;
            }

            if (amount <= 0) {
                JOptionPane.showMessageDialog(null, "Please enter a valid withdrawal amount");
                return;
            }

            if (amount > 10000) {
                JOptionPane.showMessageDialog(null, "Maximum withdrawal limit is Rs. 10,000");
                return;
            }

            try {
                Con c = new Con();
                ResultSet resultSet = c.statement.executeQuery("SELECT * FROM bank WHERE pin = '" + pin + "'");
                long balance = 0;

                // Calculate current balance
                while (resultSet.next()) {
                    String type = resultSet.getString("type");
                    long amt = Long.parseLong(resultSet.getString("amount"));

                    if (type.equalsIgnoreCase("Deposit")) {
                        balance += amt;
                    } else if (type.equalsIgnoreCase("Withdrawal")) {
                        balance -= amt;
                    }
                }

                if (balance < amount) {
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return;
                }

                // Insert the withdrawal record
                Date date = new Date();
                String query = "INSERT INTO bank VALUES('" + pin + "', '" + date + "', 'Withdrawal', '" + amount + "')";
                c.statement.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Rs. " + amount + " Debited Successfully");

                setVisible(false);
                new main_Class(pin);

            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            }
        } else if (e.getSource() == b2) {
            setVisible(false);
            new main_Class(pin);
        }
    }

    public static void main(String[] args) {
        new Withdrawl("");
    }
}

