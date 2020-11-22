package Day1;

import java.sql.*;

public class LoopingResultSet {

    public static void main(String[] args)throws SQLException {

        String connectionStr = "jdbc:oracle:thin:@54.166.212.192:1521:XE";
        String username = "hr" ;
        String password = "hr" ;

        Connection conn = DriverManager.getConnection(connectionStr,username,password) ;

        Statement stmnt = conn.createStatement();

        ResultSet rs   =   stmnt.executeQuery("SELECT * FROM REGIONS") ;

        //rs.next(): this method will return a boolean value
        // if there is next row --> return true and move pointer to next row
        // if there is no next row --> false
        // rs.next() this is same to iterator as well

        // This is how we can iterate an entire row of data:
        while (rs.next()) {

            System.out.println("Region_ID " + rs.getString("REGION_ID"));
            System.out.println("Region_Name " + rs.getString("REGION_NAME"));

        }

        System.out.println("\n=============================================================\n");
        // Iterate over all countries

        rs = stmnt.executeQuery("SELECT * FROM COUNTRIES");

        while (rs.next()){

            //System.out.println("Region_ID: " + rs.getString("REGION_ID"));
            //System.out.println("Country_ID: " + rs.getString("COUNTRY_ID"));
            //System.out.println("Country_Name: " + rs.getString("COUNTRY_NAME"));
            //System.out.println();

            System.out.print(rs.getString(3) + " ");
            System.out.print(rs.getString(1) + " ");
            System.out.println(rs.getString(2));

        }


    }

}

