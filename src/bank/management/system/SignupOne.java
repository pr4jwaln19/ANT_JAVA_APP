package bank.management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class SignupOne extends JFrame implements ActionListener{
    
      long random;
      JTextField nameTextField,fnameTextField,emailTextField,addressTextField,cityTextField,stateTextField,pinTextField;
      JDateChooser dateChooser;
      JRadioButton male, female, others, married, unmarried, other;
      JButton next;
      
      SignupOne(){
          
          setLayout(null);
          
          Random ran= new Random();
          random= Math.abs((ran.nextLong() % 9000L) + 1000L);
          
          JLabel formno= new JLabel("APPLICATION FORM NO. " + random);
          formno.setFont(new Font("Raleway", Font.BOLD, 38));
          formno.setBounds(140,20,600,40);
          add(formno);
          
          JLabel personDetails= new JLabel("Page 1: Personal Details ");
          personDetails.setFont(new Font("Raleway", Font.BOLD, 22));
          personDetails.setBounds(290,80,290,30);
          add(personDetails);
          
          JLabel name= new JLabel("Name: ");
          name.setFont(new Font("Raleway", Font.BOLD, 20));
          name.setBounds(100,140,100,30);
          add(name);
          
          nameTextField= new JTextField();
          nameTextField.setFont(new Font("Raleway", Font.BOLD, 14));
          nameTextField.setBounds(290,140,400,30);
          add(nameTextField);
          
          JLabel fname= new JLabel("Father's Name: ");
          fname.setFont(new Font("Raleway", Font.BOLD, 20));
          fname.setBounds(100,190,160,30);
          add(fname);
          
          fnameTextField= new JTextField();
          fnameTextField.setFont(new Font("Raleway", Font.BOLD, 14));
          fnameTextField.setBounds(290,190,400,30);
          add(fnameTextField);
          
          JLabel dob= new JLabel("Date of Birth: ");
          dob.setFont(new Font("Raleway", Font.BOLD, 20));
          dob.setBounds(100,240,200,30);
          add(dob);
          
          dateChooser= new JDateChooser();
          dateChooser.setBounds(290,240,400,30);
          add(dateChooser);
          
          JLabel gender= new JLabel("Gender: ");
          gender.setFont(new Font("Raleway", Font.BOLD, 20));
          gender.setBounds(100,290,160,30);
          add(gender);
          
          male= new JRadioButton("Male");
          male.setBounds(300,290,60,30);
          male.setBackground(Color.WHITE);
          add(male);
          
          female= new JRadioButton("Female");
          female.setBounds(400,290,100,30);
          female.setBackground(Color.WHITE);
          add(female);
          
          others= new JRadioButton("Others");
          others.setBounds(520,290,100,30);
          others.setBackground(Color.WHITE);
          add(others);
          
          ButtonGroup gendergroup= new ButtonGroup();
          gendergroup.add(male);
          gendergroup.add(female);
          gendergroup.add(others);
          
          JLabel email= new JLabel("Email Address: ");
          email.setFont(new Font("Raleway", Font.BOLD, 20));
          email.setBounds(100,340,200,30);
          add(email);
          
          emailTextField= new JTextField();
          emailTextField.setFont(new Font("Raleway", Font.BOLD, 14));
          emailTextField.setBounds(290,340,400,30);
          add(emailTextField);
          
          JLabel maritalStatus= new JLabel("Marital Status: ");
          maritalStatus.setFont(new Font("Raleway", Font.BOLD, 20));
          maritalStatus.setBounds(100,390,200,30);
          add(maritalStatus);
          
          married= new JRadioButton("Married");
          married.setBounds(300,390,100,30);
          married.setBackground(Color.WHITE);
          add(married);
          
          unmarried= new JRadioButton("Unmarried");
          unmarried.setBounds(400,390,100,30);
          unmarried.setBackground(Color.WHITE);
          add(unmarried);
          
          other= new JRadioButton("Other");
          other.setBounds(520,390,100,30);
          other.setBackground(Color.WHITE);
          add(other);
          
          ButtonGroup maritalgroup= new ButtonGroup();
          maritalgroup.add(married);
          maritalgroup.add(unmarried);
          maritalgroup.add(other);
          
          JLabel address= new JLabel("Address: ");
          address.setFont(new Font("Raleway", Font.BOLD, 20));
          address.setBounds(100,440,160,30);
          add(address);
          
          addressTextField= new JTextField();
          addressTextField.setFont(new Font("Raleway", Font.BOLD, 14));
          addressTextField.setBounds(290,440,400,30);
          add(addressTextField);
          
          JLabel city= new JLabel("City: ");
          city.setFont(new Font("Raleway", Font.BOLD, 20));
          city.setBounds(100,490,120,30);
          add(city);
          
          cityTextField= new JTextField();
          cityTextField.setFont(new Font("Raleway", Font.BOLD, 14));
          cityTextField.setBounds(290,490,400,30);
          add(cityTextField);
          
          JLabel state= new JLabel("State: ");
          state.setFont(new Font("Raleway", Font.BOLD, 20));
          state.setBounds(100,540,120,30);
          add(state);
          
          stateTextField= new JTextField();
          stateTextField.setFont(new Font("Raleway", Font.BOLD, 14));
          stateTextField.setBounds(290,540,400,30);
          add(stateTextField);
          
          JLabel pincode= new JLabel("Pincode: ");
          pincode.setFont(new Font("Raleway", Font.BOLD, 20));
          pincode.setBounds(100,590,120,30);
          add(pincode);
          
          pinTextField= new JTextField();
          pinTextField.setFont(new Font("Raleway", Font.BOLD, 14));
          pinTextField.setBounds(290,590,400,30);
          add(pinTextField);
          
          next= new JButton("Next");
          next.setBackground(Color.BLACK);
          next.setForeground(Color.WHITE);
          next.setFont(new Font("Raleway",Font.BOLD,14));
          next.setBounds(610,660,80,30);
          next.addActionListener(this);
          add(next);
                  
          getContentPane().setBackground(Color.WHITE);
          
          setSize(850,800);
          setLocation(350,10);
          setVisible(true);
          
      }
      
      public void actionPerformed(ActionEvent ae){
          String formno = "" + random; // random->long | we convert it to string
          
          String name = nameTextField.getText(); // .getTextField() -> to get value from the textfield
          
          String fname = fnameTextField.getText();
          
          String dob =((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
          
          String gender = null;
          if (male.isSelected()){
              gender = "Male";
          } else if (female.isSelected()){
              gender = "Female";
          } else if (others.isSelected()){
              gender = "Others";
          }
          
          String email = emailTextField.getText();
          
          String marital = null;
          if (married.isSelected()){
              marital = "Married";
          } else if (unmarried.isSelected()){
              marital = "Unmarried";
          } else if (other.isSelected()){
              marital = "Other";
          }
          
          String address = addressTextField.getText();
          
          String city = cityTextField.getText();
          
          String state = stateTextField.getText();
          
          String pin = pinTextField.getText();
          
          try {
              
              if(name.equals("")){
                  JOptionPane.showMessageDialog(null, "Name is required");
              }
              else if(fname.equals("")){
                  JOptionPane.showMessageDialog(null, "Father's Name is required");
              }
              else if(dob.equals("")){
                  JOptionPane.showMessageDialog(null, "DOB is required");
              }
              else if(address.equals("")){
                  JOptionPane.showMessageDialog(null, "Address is required");
              }
              else if(city.equals("")){
                  JOptionPane.showMessageDialog(null, "City is required");
              }
              else if(state.equals("")){
                  JOptionPane.showMessageDialog(null, "State is required");
              }
              else if(pin.equals("")){
                  JOptionPane.showMessageDialog(null, "Pin is required");
              }
              //Now we have to call the database | before that we need to connect to database
              else{
                  //Created  a object of Conn Class
                  Conn c = new Conn();
                  
                  //Write a query using DML commands
                  String query = "INSERT INTO signup VALUES('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+state+"','"+pin+"')";
                  
                  // 4) Now we execute this query using DML command
                  
                  // We have created a connection in Conn class with the help of  object "c"
                  //And written a statement "s"
                  c.s.executeUpdate(query);
                  
                  setVisible(false);
                  new SignupTwo(formno).setVisible(true);
                  
              }
              
              
          } catch(Exception e){
              System.out.println(e);
          }
      }
      
      public static void main(String[] args){
          new SignupOne();
      }
    
}
