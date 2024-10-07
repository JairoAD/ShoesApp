package CartDatabaseModule;


import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataBaseHelper {
    Connection conn;

    
    public DataBaseHelper() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/ShoesDB", "root", "Admin$1234");
            System.out.println("Connected to the database successfully.");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DataBaseHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    public ResultSet getShoe() throws SQLException{
        Statement statement = conn.createStatement();
        String sql = "SELECT * FROM cart";        
        ResultSet resultset = statement.executeQuery(sql);
        return resultset;
    }

}
