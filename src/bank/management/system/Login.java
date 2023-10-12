package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    
       JButton login, clear, signup;
       JTextField cardTextField;
       JPasswordField pinTextField;
    
       Login(){
           
           setTitle("Automated Teller Machine");
           
           setLayout(null);
           
           ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/atmlogo1.jpg"));
           Image i2= i1.getImage().getScaledInstance(120, 120, Image.SCALE_DEFAULT);
           ImageIcon i3= new ImageIcon(i2);
           JLabel label= new JLabel(i3);
           label.setBounds(40, 10, 120,120);
           add(label);
           
           JLabel text = new JLabel("WELCOME TO ATM !!");
           text.setFont(new Font("Osward", Font.BOLD, 38));
           text.setBounds(180,50,440,30);
           add(text);
           
           JLabel cardno = new JLabel("Card No: ");
           cardno.setFont(new Font("Raleway", Font.BOLD, 28));
           cardno.setBounds(180,150,200,30);
           add(cardno);
           
           cardTextField= new JTextField();
           cardTextField.setBounds(400,150,230,33);
           cardTextField.setFont(new Font("Arial",Font.BOLD,14));
           add(cardTextField);
           
           JLabel pin = new JLabel("PIN: ");
           pin.setFont(new Font("Raleway", Font.BOLD, 28));
           pin.setBounds(180,200,250,30);
           add(pin);
           
           pinTextField= new JPasswordField();
           pinTextField.setBounds(400,200,230,33);
           pinTextField.setFont(new Font("Arial",Font.BOLD,14));
           add(pinTextField);
           
           login= new JButton("SIGN IN");
           login.setBounds(400,300,100,30);
           login.setBackground(Color.BLACK);
           login.setForeground(Color.WHITE);
           login.addActionListener(this);
           add(login);
           
           clear= new JButton("CLEAR");
           clear.setBounds(530,300,100,30);
           clear.setBackground(Color.BLACK);
           clear.setForeground(Color.WHITE);
           clear.addActionListener(this);
           add(clear);
           
           signup= new JButton("SIGN UP");
           signup.setBounds(465,350,100,30);
           signup.setBackground(Color.BLACK);
           signup.setForeground(Color.WHITE);
           signup.addActionListener(this);
           add(signup);
           
           getContentPane().setBackground(Color.WHITE);
           
           setSize(800,480);
           setVisible(true);
           setLocation(350,200);
           
       }
       
       @Override
       public void actionPerformed(ActionEvent ae){
           
           if(ae.getSource()==clear){
               cardTextField.setText("");
               pinTextField.setText("");
               
           } else if (ae.getSource()==login){
               
               Conn con= new Conn();
               String cardnumber= cardTextField.getText();
               String pinnumber= pinTextField.getText(); //because pinnumber is password field
               // This is get query . Not a DML but DDL query. We are extracting data from the table
               String queryGet= "SELECT * FROM LOGIN WHERE cardNumber =  '" + cardnumber + "' and pinNumber = '" + pinnumber + "' ";
               
               try{
                   
                   ResultSet rs =con.s.executeQuery(queryGet);
                   if (rs.next()){
                       setVisible(false);
                       new Transactions(pinnumber).setVisible(true);
                   }
                   else{
                       JOptionPane.showMessageDialog(null, "Incorrect Card Number or Pin");
                   }
                   
               } catch (Exception e){
                   System.out.println(e);
               }
               
               
           } else if (ae.getSource()==signup){
               setVisible(false);
               new SignupOne().setVisible(true);
           }
           
       }
    
       public static void main(String[] args){
           new Login();
       }    
}
