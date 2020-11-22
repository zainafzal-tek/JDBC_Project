package Day1;

import java.sql.*;

public class MovingResultSetPointer {

    public static void main(String[] args) throws SQLException {

        String connectionStr = "jdbc:oracle:thin:@54.166.212.192:1521:XE";
        String username = "hr" ;
        String password = "hr" ;

        Connection conn = DriverManager.getConnection(connectionStr,username,password) ;

        //This way of creating statement will give you the ability to generate
        // ResultSet that can move forward and backward position
        Statement stmnt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

        ResultSet rs   =   stmnt.executeQuery("SELECT * FROM REGIONS") ;

        while(rs.next()){
            System.out.println("REGION_NAME " + rs.getString("REGION_NAME"));
        }

        //rs.previous(): this will let the pointer go back to the previous row, returns boolean value
        //System.out.println("REGION_NAME " + rs.getString("REGION_NAME"));

        // another way of going back to the first row
        while (rs.previous()){
            System.out.println("REGION_NAME " + rs.getString("REGION_NAME"));
        }

        /**
         * Other ResultSet methods for moving your pointer to specific locations
         * rs.beforeFirst(): before first location
         * rs.first(): first row
         * rs.last(): last row
         * rs.afterLast(): after last location
         * rs.absolute(): move to specific row
         */

        // how to find out which row the pointer iss at right now:
        int currentRowNum = rs.getRow(); // will return int which will be the index of the row where the pointer is on

        //how to get the row count:

        //first we will go to the last row
        rs.last();

        //then we will get index of row
        int rowCount = rs.getRow();

        //printing out index (since sql index doesn't start from 0, starts from 1, the index returned will be the total row count)
        System.out.println("Number of Rows = " + rowCount);

    }

}
