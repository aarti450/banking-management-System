package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Random;

public class Signup3 extends JFrame implements ActionListener {

    JRadioButton savingAccount, fixedDeposit, currentAccount, recurringDeposit;
    JCheckBox atmCard, internetBanking, mobileBanking, emailAlerts, chequeBook, eStatement, declaration;
    JButton submit, cancel;
    String formno;

    Signup3(String formno) {
        this.formno = formno;
        setLayout(null);
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 3");

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        JLabel image = new JLabel(new ImageIcon(i2));
        image.setBounds(150, 0, 100, 100);
        add(image);

        JLabel formnoLabel = new JLabel("Form No:");
        formnoLabel.setFont(new Font("Raleway", Font.BOLD, 14));
        formnoLabel.setBounds(700, 10, 100, 30);
        add(formnoLabel);

        JLabel formnoValue = new JLabel(formno);
        formnoValue.setFont(new Font("Raleway", Font.BOLD, 14));
        formnoValue.setBounds(770, 10, 100, 30);
        add(formnoValue);


        JLabel label1 = new JLabel("Page 3: Account Details");
        label1.setFont(new Font("Raleway", Font.BOLD, 22));
        label1.setBounds(280, 40, 400, 40);
        add(label1);

        JLabel type = new JLabel("Account Type :");
        type.setFont(new Font("Raleway", Font.BOLD, 18));
        type.setBounds(100, 140, 200, 30);
        add(type);

        savingAccount = new JRadioButton("Saving Account");
        savingAccount.setFont(new Font("Raleway", Font.PLAIN, 14));
        savingAccount.setBackground(new Color(204, 255, 255));
        savingAccount.setBounds(330, 140, 150, 30);
        add(savingAccount);

        fixedDeposit = new JRadioButton("Fixed Deposite Account");
        fixedDeposit.setFont(new Font("Raleway", Font.PLAIN, 14));
        fixedDeposit.setBackground(new Color(204, 255, 255));
        fixedDeposit.setBounds(530, 140, 250, 30);
        add(fixedDeposit);

        currentAccount = new JRadioButton("Current Account");
        currentAccount.setFont(new Font("Raleway", Font.PLAIN, 14));
        currentAccount.setBackground(new Color(204, 255, 255));
        currentAccount.setBounds(330, 180, 150, 30);
        add(currentAccount);

        recurringDeposit = new JRadioButton("Recurring Deposite Account");
        recurringDeposit.setFont(new Font("Raleway", Font.PLAIN, 14));
        recurringDeposit.setBackground(new Color(204, 255, 255));
        recurringDeposit.setBounds(530, 180, 250, 30);
        add(recurringDeposit);

        ButtonGroup groupAccount = new ButtonGroup();
        groupAccount.add(savingAccount);
        groupAccount.add(fixedDeposit);
        groupAccount.add(currentAccount);
        groupAccount.add(recurringDeposit);

        JLabel card = new JLabel("Card Number :");
        card.setFont(new Font("Raleway", Font.BOLD, 18));
        card.setBounds(100, 250, 200, 30);
        add(card);

        JLabel number = new JLabel("XXXX-XXXX-XXXX-4841");
        number.setFont(new Font("Raleway", Font.BOLD, 18));
        number.setBounds(330, 250, 300, 30);
        add(number);

        JLabel cardDetail = new JLabel("(Your 16-digit Card Number)");
        cardDetail.setFont(new Font("Raleway", Font.PLAIN, 12));
        cardDetail.setBounds(100, 280, 200, 20);
        add(cardDetail);

        JLabel cardDetail2 = new JLabel("(It would appear on atm card/cheque Book and Statements)");
        cardDetail2.setFont(new Font("Raleway", Font.PLAIN, 12));
        cardDetail2.setBounds(330, 280, 400, 20);
        add(cardDetail2);

        JLabel pin = new JLabel("PIN :");
        pin.setFont(new Font("Raleway", Font.BOLD, 18));
        pin.setBounds(100, 320, 200, 30);
        add(pin);

        JLabel pnumber = new JLabel("XXXX");
        pnumber.setFont(new Font("Raleway", Font.BOLD, 18));
        pnumber.setBounds(330, 320, 200, 30);
        add(pnumber);

        JLabel pinDetail = new JLabel("(4-digit Password)");
        pinDetail.setFont(new Font("Raleway", Font.PLAIN, 12));
        pinDetail.setBounds(100, 350, 200, 20);
        add(pinDetail);

        JLabel services = new JLabel("Services Required :");
        services.setFont(new Font("Raleway", Font.BOLD, 18));
        services.setBounds(100, 400, 200, 30);
        add(services);

        atmCard = new JCheckBox("ATM CARD");
        atmCard.setBackground(new Color(204, 255, 255));
        atmCard.setFont(new Font("Raleway", Font.PLAIN, 14));
        atmCard.setBounds(330, 400, 200, 30);
        add(atmCard);

        internetBanking = new JCheckBox("Internet Banking");
        internetBanking.setBackground(new Color(204, 255, 255));
        internetBanking.setFont(new Font("Raleway", Font.PLAIN, 14));
        internetBanking.setBounds(530, 400, 200, 30);
        add(internetBanking);

        mobileBanking = new JCheckBox("Mobile Banking");
        mobileBanking.setBackground(new Color(204, 255, 255));
        mobileBanking.setFont(new Font("Raleway", Font.PLAIN, 14));
        mobileBanking.setBounds(330, 440, 200, 30);
        add(mobileBanking);

        emailAlerts = new JCheckBox("EMAIL Alerts");
        emailAlerts.setBackground(new Color(204, 255, 255));
        emailAlerts.setFont(new Font("Raleway", Font.PLAIN, 14));
        emailAlerts.setBounds(530, 440, 200, 30);
        add(emailAlerts);

        chequeBook = new JCheckBox("Cheque Book");
        chequeBook.setBackground(new Color(204, 255, 255));
        chequeBook.setFont(new Font("Raleway", Font.PLAIN, 14));
        chequeBook.setBounds(330, 480, 200, 30);
        add(chequeBook);

        eStatement = new JCheckBox("E-Statement");
        eStatement.setBackground(new Color(204, 255, 255));
        eStatement.setFont(new Font("Raleway", Font.PLAIN, 14));
        eStatement.setBounds(530, 480, 200, 30);
        add(eStatement);

        declaration = new JCheckBox("I here by declare that the above entered details correct to the best of my knowledge.");
        declaration.setBackground(new Color(204, 255, 255));
        declaration.setFont(new Font("Raleway", Font.PLAIN, 12));
        declaration.setBounds(100, 530, 700, 20);
        add(declaration);

        submit = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Raleway", Font.BOLD, 14));
        submit.setBounds(250, 580, 100, 30);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Raleway", Font.BOLD, 14));
        cancel.setBounds(420, 580, 100, 30);
        cancel.addActionListener(this);
        add(cancel);

        getContentPane().setBackground(new Color(204, 255, 255));
        setSize(850, 750);
        setLocation(350, 0);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            String accountType = null;
            if (savingAccount.isSelected()) accountType = "Saving Account";
            else if (fixedDeposit.isSelected()) accountType = "Fixed Deposite Account";
            else if (currentAccount.isSelected()) accountType = "Current Account";
            else if (recurringDeposit.isSelected()) accountType = "Recurring Deposite Account";

            Random random = new Random();
            String cardNumber = "" + Math.abs((random.nextLong() % 90000000L) + 5040936000000000L);
            String pinNumber = "" + Math.abs((random.nextLong() % 9000L) + 1000L);

            String facility = "";
            if (atmCard.isSelected()) facility += " ATM Card";
            if (internetBanking.isSelected()) facility += " Internet Banking";
            if (mobileBanking.isSelected()) facility += " Mobile Banking";
            if (emailAlerts.isSelected()) facility += " EMAIL Alerts";
            if (chequeBook.isSelected()) facility += " Cheque Book";
            if (eStatement.isSelected()) facility += " E-Statement";

            try {
                if (accountType == null) {
                    JOptionPane.showMessageDialog(null, "Account type is required");
                } else {
                    Con c = new Con();
                    String query1 = "insert into signupthree values('" + formno + "', '" + accountType + "', '" + cardNumber + "', '" + pinNumber + "', '" + facility + "')";
                    String query2 = "insert into login values('" + formno + "', '" + cardNumber + "', '" + pinNumber + "')";
                    c.statement.executeUpdate(query1);
                    c.statement.executeUpdate(query2);
                    JOptionPane.showMessageDialog(null, "Card Number: " + cardNumber + "\nPIN: " + pinNumber);
                    setVisible(false);
                    new Deposit(pinNumber).setVisible(true);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == cancel) {
            setVisible(false);
            new Login().setVisible(true);
        }
    }

    public static void main(String[] args) {

        new Signup3("");
    }
}
