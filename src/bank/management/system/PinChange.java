package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PinChange extends JFrame implements ActionListener{
    
    String pinnumber;
    JPasswordField pin,repin;
    JButton change,back;
    
    PinChange(String pinnumber){
        
        this.pinnumber= pinnumber;
        
        setLayout(null);
        
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2= i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image= new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text= new JLabel("CHANGE YOUR PIN: ");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setBounds(255, 280, 500, 35);
        image.add(text);
        
        JLabel ptext= new JLabel("NEW PIN: ");
        ptext.setForeground(Color.WHITE);
        ptext.setFont(new Font("System",Font.BOLD,16));
        ptext.setBounds(165, 320, 180, 25);
        image.add(ptext);
        
        pin= new JPasswordField();
        pin.setFont(new Font("Raleway",Font.BOLD,20));
        pin.setBounds(330,320,180,25);
        image.add(pin);
        
        JLabel reptext= new JLabel("RE-ENTER PIN: ");
        reptext.setForeground(Color.WHITE);
        reptext.setFont(new Font("System",Font.BOLD,16));
        reptext.setBounds(165, 360, 180, 25);
        image.add(reptext);
        
        repin= new JPasswordField();
        repin.setFont(new Font("Raleway",Font.BOLD,20));
        repin.setBounds(330,360,180,25);
        image.add(repin);
        
        change= new JButton("CHANGE");
        change.setBounds(355,485,150,30);
        change.addActionListener(this);
        image.add(change);
        
        back= new JButton("BACK");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);
        
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        
        if (ae.getSource() == change){
            
            try{
            
                 String npin= pin.getText();
                 String rpin= repin.getText();
            
                 if (!npin.equals(rpin)){
                     JOptionPane.showMessageDialog(null,"Entered PIN doesn't match");
                     return;
                 }
                 if (npin.equals("")){
                     JOptionPane.showMessageDialog(null,"Please enter new PIN");
                     return;
                 }
                 if (rpin.equals("")){
                     JOptionPane.showMessageDialog(null,"Please re-enter new PIN");
                     return;
                 }
                 
                 Conn c= new Conn();
                 
                 String query1= "UPDATE bank SET pin = '" + rpin + "' WHERE pin= '" + pinnumber + "' ";
                 String query2= "UPDATE login SET pinNumber = '" + rpin + "' WHERE pinNumber= '" + pinnumber + "' ";
                 String query3= "UPDATE signupthree SET pin = '" + rpin + "' WHERE pin= '" + pinnumber + "' ";
                 
                 c.s.executeUpdate(query1);
                 c.s.executeUpdate(query2);
                 c.s.executeUpdate(query3);
                 
                 JOptionPane.showMessageDialog(null, "PIN changed Successfully");
                 
                 setVisible(false);
                 new Transactions(rpin).setVisible(true);
            
            } catch (Exception e){
                     System.out.println(e);
              }
             
        }
        else{
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
        
    }
    
    public static void main(String[] args){
        new PinChange("").setVisible(true);
        
    }
    
}
