
package DB_Connect;

/**
 *
 * @author EGUAVOEN BRIGHT
 */
import java.sql.*;
import java.util.Calendar;
public class connectJB {
    // JDBC driver name and database URL
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://localhost:3306/Car_Race";

   //  Database credentials
   static final String USER = "root";
   static final String PASS = "";
   public static int rowCount;
   public String name;
   
   public void insertplayer(){
       Connection conn = null;
       Statement stmt = null;
       //int Id = 0;
   
   try{
      //STEP 2: Register JDBC driver
      Class.forName(JDBC_DRIVER);
      //STEP 3: Open a connection
      System.out.println("Connecting to database...");
      conn = DriverManager.getConnection(DB_URL,USER,PASS);
      System.out.println("Connected to database!!");
      //STEP 4: Execute a query
      System.out.println("Creating statement...");
      stmt = conn.createStatement();
      
      String playercheck = "SELECT player_name FROM player";
      ResultSet rs = stmt.executeQuery(playercheck);
      
      //STEP 5: Extract data from result set
      while(rs.next()){
         //Retrieve by column name
         name = rs.getString("player_name");      
         //System.out.print(", Map Name: " + name);
          //System.out.println();
         }
      
      String playerinsert = "INSERT INTO player (p_id,player_name)"+"VALUES (null,?)";
      
      
//      ResultSet keyResultSet = stmt.getGeneratedKeys();
//            int newId = 0;
//            if (keyResultSet.next()) {
//                newId = (int) keyResultSet.getInt(1);
//                //Id = String.valueOf(newId);
//            }
      String nameadded = "Halpe";
      boolean exists = true;
      while(rs.next()){
          name = rs.getString("player_name");
          if(!name.equalsIgnoreCase(nameadded)){
              exists = false;
          PreparedStatement preparedStmt = conn.prepareStatement(playerinsert);
          //preparedStmt.setInt (1, newId);
          preparedStmt.setString (1, nameadded);
      
      // execute the preparedstatement
      preparedStmt.execute();
        //STEP 6: Clean-up environment
              System.out.println("Name Added");
        rs.close();
        stmt.close();
        conn.close();
      }
      }
      
     }catch(SQLException se){
        //Handle errors for JDBC
        se.printStackTrace();
     }catch(Exception e){
        //Handle errors for Class.forName
        e.printStackTrace();
     }finally{
        //finally block used to close resources
        try{
           if(stmt!=null)
              stmt.close();
        }catch(SQLException se2){
        }// nothing we can do
        try{
           if(conn!=null)
              conn.close();
        }catch(SQLException se){
           se.printStackTrace();
        }//end finally try
     }//end try
     //System.out.println("\nGoodbye!");
     }
   
   

   public static void main(String[] args) {
       connectJB jb = new connectJB();
        jb.insertplayer();
   }//end mai
}
