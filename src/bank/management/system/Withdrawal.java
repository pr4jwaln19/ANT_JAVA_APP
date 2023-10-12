package bank.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class Withdrawal extends JFrame implements ActionListener {
    
    JTextField amountField;
    JButton withdrawA, back;
    String pinnumber;
    
    Withdrawal(String pinnumber){
        
        this.pinnumber= pinnumber;
        
        setLayout(null);
        
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2= i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image= new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text= new JLabel("Enter the amount you want to Withdraw: ");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setBounds(180,300,400,20);
        image.add(text);
        
        amountField= new JTextField();
        amountField.setFont(new Font("Raleway",Font.BOLD,22));
        amountField.setBounds(180,350,320,25);
        image.add(amountField);
        
        withdrawA= new JButton("Withdraw");
        withdrawA.setBounds(355,485,150,30);
        withdrawA.addActionListener(this);
        image.add(withdrawA);
        
        back= new JButton("Back");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(900,900);
        setLocation(300,0);
        setVisible(true);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        
        if (ae.getSource() == withdrawA){
            
            String depAmount= amountField.getText();
            
            Date date = new Date();
            
            if ( depAmount.equals("")){
                JOptionPane.showMessageDialog(null, "Please Enter the Amount you want to Withdraw");
            }
            else{
                
                try{
                    
                    Conn obj= new Conn();
                    
                    String query= "INSERT INTO bank VALUES('" + pinnumber + "', '" + date + "', 'Withdraw', '" + depAmount + "')";
                    
                    obj.s.executeUpdate(query);
                    
                    JOptionPane.showMessageDialog(null,"Rs. "+depAmount+" Withdrawn Successfully");
                    
                    setVisible(false);
                    
                    new Transactions(pinnumber).setVisible(true);
                    
                } catch(Exception e){
                    
                    System.out.println(e);
                    
                }
                
                
            }   
            
            
        } else if ( ae.getSource() == back){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
        
    }
    
    public static void main(String[] args){
        new Withdrawal("");
    }
    
}