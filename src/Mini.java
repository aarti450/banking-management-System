package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Mini extends JFrame implements ActionListener {
    String pin;
    JButton button;

    Mini(String pin) {
        this.pin = pin;

        // Window setup
        setTitle("Mini Statement");
        getContentPane().setBackground(new Color(255, 204, 204));
        setSize(400, 600);
        setLocation(20, 20);
        setLayout(null);

        // Labels
        JLabel bankLabel = new JLabel("Indian Bank");
        bankLabel.setFont(new Font("System", Font.BOLD, 20));
        bankLabel.setBounds(130, 10, 200, 30);
        add(bankLabel);

        JLabel titleLabel = new JLabel("Transaction History");
        titleLabel.setFont(new Font("System", Font.BOLD, 15));
        titleLabel.setBounds(120, 45, 200, 20);
        add(titleLabel);

        JLabel cardLabel = new JLabel();
        cardLabel.setBounds(20, 80, 350, 20);
        cardLabel.setFont(new Font("System", Font.PLAIN, 13));
        add(cardLabel);

        JLabel transactionLabel = new JLabel();
        transactionLabel.setBounds(20, 110, 350, 300);
        transactionLabel.setFont(new Font("System", Font.PLAIN, 12));
        add(transactionLabel);

        JLabel balanceLabel = new JLabel();
        balanceLabel.setFont(new Font("System", Font.BOLD, 13));
        balanceLabel.setBounds(20, 430, 350, 20);
        add(balanceLabel);

        // Get Card Number
        try {
            Con c = new Con();
            ResultSet rs = c.statement.executeQuery("SELECT * FROM login WHERE pin = '" + pin + "'");
            while (rs.next()) {
                String card = rs.getString("card_number");
                // Show partial card number (e.g., 1234XXXXXXXX1234)
                cardLabel.setText("Card Number: " + card.substring(0, 4) + "XXXXXXXX" + card.substring(12));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        // Fetch Transaction History
        try {
            long balance = 0;
            Con c = new Con();
            ResultSet rs = c.statement.executeQuery("SELECT * FROM bank WHERE pin = '" + pin + "'");

            StringBuilder html = new StringBuilder("<html>");
            while (rs.next()) {
                String date = rs.getString("date");
                String type = rs.getString("type");
                String amount = rs.getString("amount");

                html.append(date)
                        .append("&nbsp;&nbsp;&nbsp;&nbsp;")
                        .append(type)
                        .append("&nbsp;&nbsp;&nbsp;&nbsp;Rs.")
                        .append(amount)
                        .append("<br><br>");

                // Update balance
                if (type.equalsIgnoreCase("Deposit")) {
                    balance += Long.parseLong(amount);
                } else if (type.equalsIgnoreCase("Withdrawal")) {
                    balance -= Long.parseLong(amount);
                }
            }
            html.append("</html>");
            transactionLabel.setText(html.toString());
            balanceLabel.setText("Your Total Balance is Rs " + balance);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        // Exit button
        button = new JButton("Exit");
        button.setBounds(150, 500, 100, 30);
        button.setBackground(Color.BLACK);
        button.setForeground(Color.WHITE);
        button.addActionListener(this);
        add(button);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
    }

    public static void main(String[] args) {

        new Mini("");
    }
}

