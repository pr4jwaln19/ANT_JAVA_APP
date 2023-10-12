package bank.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener{
    
    JButton hundred, fivehundred, thousand, twothousand, fthousand, dthousand, back;
    
    String pinnumber;
    
    FastCash(String pinnumber){
        
        this.pinnumber= pinnumber;
        
        setLayout(null);
        
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2= i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image= new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text= new JLabel("SELECT WITHDRAWAL AMOUNT");
        text.setBounds(215,300,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);
        
        hundred= new JButton("Rs.100");
        hundred.setBounds(170, 415, 150, 30);
        hundred.setBackground(Color.WHITE);
        hundred.addActionListener(this);
        image.add(hundred); 
        
        fivehundred= new JButton("Rs.500");
        fivehundred.setBounds(355, 415, 150, 30);
        fivehundred.setBackground(Color.WHITE);
        fivehundred.addActionListener(this);
        image.add(fivehundred); 
        
        thousand= new JButton("Rs.1000");
        thousand.setBounds(170, 450, 150, 30);
        thousand.setBackground(Color.WHITE);
        thousand.addActionListener(this);
        image.add(thousand); 
        
        twothousand= new JButton("Rs.2000");
        twothousand.setBounds(355, 450, 150, 30);
        twothousand.setBackground(Color.WHITE);
        twothousand.addActionListener(this);
        image.add(twothousand); 
        
        fthousand= new JButton("Rs.5000");
        fthousand.setBounds(170, 485, 150, 30);
        fthousand.setBackground(Color.WHITE);
        fthousand.addActionListener(this);
        image.add(fthousand); 
        
        dthousand= new JButton("Rs.10000");
        dthousand.setBounds(355, 485, 150, 30);
        dthousand.setBackground(Color.WHITE);
        dthousand.addActionListener(this);
        image.add(dthousand); 
       
        back= new JButton("BACK");
        back.setBounds(355, 520, 150, 30);
        back.setBackground(Color.WHITE);
        back.addActionListener(this);
        image.add(back); 
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        
        setVisible(true);
        
        
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == back){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        } 
        else{
            
            String amount= ((JButton) ae.getSource()).getText().substring(3); // this will result Rs....
            
            Conn c= new Conn();
            
            try{
                
                ResultSet rs = c.s.executeQuery("SELECT * FROM bank WHERE pin = '"+pinnumber+"' ");
                //ResultSet rs may have multiple rows/tuples . So, rs.next() loops through every row
                int balance=0;
                while(rs.next()){
                    if(rs.getString("type").equals("Deposit")){
                        balance += Integer.parseInt(rs.getString("amount"));
                    }
                    else{
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }
                
                if (ae.getSource() != back && balance < Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null,"Insufficient Balance");
                    return;
                }
                
                Date date= new Date();
                String query= "INSERT INTO bank VALUES('" + pinnumber + "', '" + date + "','Withdraw', '" + amount + "')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Rs."+amount+" Debited Successfully");
                
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
                
            } catch(Exception e){
                System.out.println(e);
            }
            
        }
    }
    
    public static void main(String[] args){
        
        new FastCash("");
        
    }
    
}
