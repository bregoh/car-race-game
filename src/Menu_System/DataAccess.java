/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Menu_System;

import java.sql.DriverManager;
import com.mysql.jdbc.Connection;
/**
 *
 * @author Pawan
 */
public class DataAccess {
    
public static Connection connect()
        {
       Connection con=null;
        try{
          Class.forName("com.mysql.jdbc.Driver");
          con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
        
        } 
       catch(Exception e)
       {
       System.out.println(e);
       }
       return con;


}    
    
}
