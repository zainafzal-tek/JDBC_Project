package day2;

import java.sql.*;

public class Review {

    public static void main(String[] args) throws SQLException {

        String connectionStr = "jdbc:oracle:thin:@54.166.212.192:1521:XE";
        String username = "hr";
        String password = "hr";

        Connection conn = DriverManager.getConnection(connectionStr, username, password);
        Statement statement = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet rs = statement.executeQuery("SELECT * FROM JOBS");

        //I WANT TO READ THE FIRST ROW:
        rs.next();
        System.out.println("First column value in Jobs " + rs.getString(1));
        System.out.println("Second column value in Jobs " + rs.getString(2));

        // move to row number 7 and get above 2 column values:
        rs.absolute(7);
        System.out.println("First column value in jobs in row 7 " + rs.getString(1));
        System.out.println("Second column value in jobs in row 7 " + rs.getString(2));

        rs.last();
        System.out.println("First column value in jobs in last row " + rs.getString(1));
        System.out.println("Second column value in jobs in lasy row " + rs.getString(2));

        rs.previous();
        System.out.println("First column value in jobs in 2nd row from last " + rs.getString(1));
        System.out.println("Second column value in jobs in 2nd row from last " + rs.getString(2));

        System.out.println("Loop from first row till last row print JOB_ID");
        rs.beforeFirst();

        while (rs.next()){
            System.out.println("Loop first column " + rs.getString("JOB_ID"));
        }

        System.out.println("Loop from last row till first row get MIN_SALARY column as number");
        //WE ARE CURRENTLY AS AFTER LAST LOCATION
        // IF YOU REALLY WANT TO MAKE SURE AND EXPLICITLY SAY SO
        //WE CAN DO THE FOLLOWING

        rs.afterLast();
        while (rs.previous()){
            System.out.println("MIN SALARY column as number " + rs.getDouble("MIN_SALARY"));
        }

        //clean up the connection ,  statement and result set object after usage
        rs.close();
        statement.close();
        conn.close();

        //these will close the resources and prevent any unwanted memory leaks

    }

}
