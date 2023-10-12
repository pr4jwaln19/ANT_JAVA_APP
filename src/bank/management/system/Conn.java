package bank.management.system;

import java.sql.*;

//Steps for DB connectivity
/*
      1) Register the driver
      2) Create Connection
      3) Create Statement
      4) Execute Query
      5) Close Connection
*/
public class Conn {
    
    Connection c;
    Statement s;
    
    public Conn(){
        
        try{
            // 1) Driver register - we don't need to explicitly do this step
            // Because we imported the jdbc driver into the package
            //  and java does it implictly
            //Class.forName(com.mysql.cj.jdbc.Driver);
            
            // 2) Connection Create -> jdbc:mysql://localhost:3306 (by default)
            c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","root","lkjhgfdsa");
            
            // 3) Now, we create a statement
            s = c.createStatement();
            
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
}
