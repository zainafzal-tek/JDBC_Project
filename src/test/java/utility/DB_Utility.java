package utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB_Utility {

    public static void createConnection(){

        String connectionStr = "jdbc:oracle:thin:@54.166.212.192:1521:XE";
        String username = "hr";
        String password = "hr";
        try {
            Connection conn = DriverManager.getConnection(connectionStr, username, password);
        } catch (SQLException e){
            System.out.println("Connection has failed!!! " + e.getMessage());
        }
    }

}
