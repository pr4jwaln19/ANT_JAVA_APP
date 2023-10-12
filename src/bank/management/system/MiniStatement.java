package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class MiniStatement extends JFrame {

    String pinnumber;

    MiniStatement(String pinnumber) {
        this.pinnumber = pinnumber;

        setTitle("Mini Statement");
        setLayout(new BorderLayout());

        JLabel bank = new JLabel("State Bank of India | SBI");
        bank.setFont(new Font("Raleway", Font.BOLD, 16));
        bank.setHorizontalAlignment(JLabel.CENTER);
        add(bank, BorderLayout.NORTH);

        JTextArea mini = new JTextArea(10, 30);
        mini.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(mini);
        add(scrollPane, BorderLayout.CENTER);

        JLabel balance = new JLabel();
        add(balance, BorderLayout.SOUTH);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("SELECT * FROM login WHERE pinNumber = '" + pinnumber + "' ");
            if (rs.next()) {
                String cardNumber = rs.getString("cardNumber");
                cardNumber = cardNumber.substring(0, 4) + "XXXXXXXX" + cardNumber.substring(8);
                JLabel card = new JLabel("Card Number: " + cardNumber);
                add(card, BorderLayout.WEST);
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            Conn con = new Conn();
            int bal = 0;
            ResultSet rs = con.s.executeQuery("SELECT * FROM bank WHERE pin = '" + pinnumber + "' ORDER BY dateR DESC LIMIT 5");
            while (rs.next()) {
                mini.append(rs.getString("dateR") + "\t" + rs.getString("type") + "\t" + rs.getString("amount") + "\n");

                if (rs.getString("type").equals("Deposit")) {
                    bal += Integer.parseInt(rs.getString("amount"));
                } else {
                    bal -= Integer.parseInt(rs.getString("amount"));
                }
            }

            balance.setText("Your current Account Balance is Rs." + bal);

        } catch (Exception e) {
            System.out.println(e);
        }

        setSize(400, 600);
        setLocation(20, 20);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MiniStatement("");
    }
}

