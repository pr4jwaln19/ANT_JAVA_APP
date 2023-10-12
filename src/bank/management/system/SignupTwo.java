package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener{

      JComboBox religionBox, categoryBox, incomeBox, educationalBox, occupationBox;
      JTextField panTextField,aadharTextField;
      JRadioButton syes, sno, eayes, eano;
      JButton next;
      String formno;
      
      // We are using the primary key formno of SignupOne class into 
      // SignupTwo class which has formno as foreign key
      
      SignupTwo(String formno){
          
          this.formno= formno;
          
          setLayout(null);
          
          setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
          
          JLabel additionalDetails= new JLabel("Page 2: Additional Details ");
          additionalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
          additionalDetails.setBounds(290,80,290,30);
          add(additionalDetails);
          
          JLabel religion= new JLabel("Religion: ");
          religion.setFont(new Font("Raleway", Font.BOLD, 20));
          religion.setBounds(100,140,100,30);
          add(religion);
          
          String[] varReligion= {"Hindu","Muslim","Christian","Sikh","Other"};
          religionBox = new JComboBox(varReligion);
          religionBox.setBounds(290,140,400,30);
          religionBox.setBackground(Color.WHITE);
          add(religionBox);

          JLabel category= new JLabel("Category: ");
          category.setFont(new Font("Raleway", Font.BOLD, 20));
          category.setBounds(100,190,160,30);
          add(category);
          
          String[] varCategory = {"General","OBC","NT","SC","ST","Others"};
          categoryBox= new JComboBox(varCategory);
          categoryBox.setBounds(290,190,400,30);
          categoryBox.setBackground(Color.WHITE);
          add(categoryBox);
          
          JLabel income= new JLabel("Income: ");
          income.setFont(new Font("Raleway", Font.BOLD, 20));
          income.setBounds(100,240,160,30);
          add(income);
          
          String[] incomeLog= {"None","Upto 1.5 Lakhs","Between 1.5L to 4.5L","Between 4.5L to 10L","Above 10L"};
          incomeBox= new JComboBox(incomeLog);
          incomeBox.setBounds(290,240,400,30);
          incomeBox.setBackground(Color.WHITE);
          add(incomeBox);  
          
          JLabel education= new JLabel("Educational ");
          education.setFont(new Font("Raleway", Font.BOLD, 20));
          education.setBounds(100,290,160,30);
          add(education);
       
          JLabel qualification= new JLabel("Qualification: ");
          qualification.setFont(new Font("Raleway", Font.BOLD, 20));
          qualification.setBounds(100,320,200,30);
          add(qualification);
          
          String[] educationLog= {"Non-Graduation","Graduation","Post-Graduation","Doctorate","Other"};
          educationalBox= new JComboBox(educationLog);
          educationalBox.setBounds(290,310,400,40);
          educationalBox.setBackground(Color.WHITE);
          add(educationalBox); 
          
          JLabel occupation= new JLabel("Occupation: ");
          occupation.setFont(new Font("Raleway", Font.BOLD, 20));
          occupation.setBounds(100,390,200,30);
          add(occupation);

          String[] occupationLog= {"Salaried","Self-Employed","Business","Student","Retired","Other"};
          occupationBox= new JComboBox(occupationLog);
          occupationBox.setBounds(290,390,400,30);
          occupationBox.setBackground(Color.WHITE);
          add(occupationBox); 
          
          JLabel pan= new JLabel("PAN Number: ");
          pan.setFont(new Font("Raleway", Font.BOLD, 20));
          pan.setBounds(100,440,160,30);
          add(pan);
          
          panTextField= new JTextField();
          panTextField.setFont(new Font("Raleway", Font.BOLD, 14));
          panTextField.setBounds(290,440,400,30);
          add(panTextField);
          
          JLabel aadhar= new JLabel("Aadhar No: ");
          aadhar.setFont(new Font("Raleway", Font.BOLD, 20));
          aadhar.setBounds(100,490,120,30);
          add(aadhar);
          
          aadharTextField= new JTextField();
          aadharTextField.setFont(new Font("Raleway", Font.BOLD, 14));
          aadharTextField.setBounds(290,490,400,30);
          add(aadharTextField);
          
          JLabel citizen= new JLabel("Senior Citizen: ");
          citizen.setFont(new Font("Raleway", Font.BOLD, 20));
          citizen.setBounds(100,540,160,30);
          add(citizen);
          
          syes = new JRadioButton("Yes");
          syes.setBounds(300,540,100,30);
          syes.setBackground(Color.WHITE);
          add(syes);
          
          sno = new JRadioButton("No");
          sno.setBounds(450,540,100,30);
          sno.setBackground(Color.WHITE);
          add(sno);
          
          ButtonGroup scitizengroup= new ButtonGroup();
          scitizengroup.add(syes);
          scitizengroup.add(sno);
          
          JLabel existingAcc= new JLabel("Existing Account: ");
          existingAcc.setFont(new Font("Raleway", Font.BOLD, 20));
          existingAcc.setBounds(100,590,180,30);
          add(existingAcc);
     
          eayes = new JRadioButton("Yes");
          eayes.setBounds(300,590,100,30);
          eayes.setBackground(Color.WHITE);
          add(eayes);
          
          eano = new JRadioButton("No");
          eano.setBounds(450,590,100,30);
          eano.setBackground(Color.WHITE);
          add(eano);
          
          ButtonGroup exaccountgroup= new ButtonGroup();
          exaccountgroup.add(eayes);
          exaccountgroup.add(eano);
          
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
          
          String religion = (String) religionBox.getSelectedItem(); // .getTextField() -> to get value from the textfield
          
          String category = (String) categoryBox.getSelectedItem();
          
          String income = (String) incomeBox.getSelectedItem();
          
          String education = (String) educationalBox.getSelectedItem();
  
          String occupation = (String) occupationBox.getSelectedItem();
          
          String pan = panTextField.getText();
     
          String aadhar = aadharTextField.getText();
          
          String citizen = null;
          if (syes.isSelected()){
              citizen = "Yes";
          } else if (sno.isSelected()){
              citizen = "No";
          }
          
          String existingAcc = null;
          if (eayes.isSelected()){
              existingAcc = "Yes";
          } else if (eano.isSelected()){
              existingAcc = "No";
          }
          
          
          try {
                  //Created  a object of Conn Class
                  Conn c = new Conn();
                  
                  //Write a query using DML commands
                  String query = "INSERT INTO signuptwo VALUES('"+formno+"','"+religion+"','"+category+"','"+income+"','"+education+"','"+occupation+"','"+pan+"','"+aadhar+"','"+citizen+"','"+existingAcc+"')";
                  
                  // 4) Now we execute this query using DML command
                  
                  // We have created a connection in Conn class with the help of  object "c"
                  //And written a statement "s"
                  c.s.executeUpdate(query);
                  
                  //Now we make here Signup 3 class object
                  setVisible(false);
                  new SignupThree(formno).setVisible(true);
    
          } catch(Exception e){
              System.out.println(e);
          }
      }
      
      public static void main(String[] args){
          new SignupTwo("");
      }
    
}

