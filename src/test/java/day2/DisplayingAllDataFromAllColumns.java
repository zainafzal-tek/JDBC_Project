package day2;

import java.sql.*;

public class DisplayingAllDataFromAllColumns {

    public static void main(String[] args) throws SQLException {

        String connectionStr = "jdbc:oracle:thin:@54.166.212.192:1521:XE";
        String username = "hr";
        String password = "hr";

        Connection conn = DriverManager.getConnection(connectionStr, username, password);
        Statement statement = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet rs = statement.executeQuery("SELECT * FROM EMPLOYEES");

        //print out first row of employee table from above query
        ResultSetMetaData rsmd = rs.getMetaData();
        int colCount = rsmd.getColumnCount();

        //print out column name in the beginning row , then print first row

        for (int colNum = 1; colNum <= colCount; colNum++){
            System.out.println(rsmd.getColumnLabel(colNum) + "\t");
        }
        rs.next();

        for (int colNum = 1; colNum <= colCount; colNum++){
            System.out.print(rs.getString(colNum) + "\t");
        }

        //now how do you get all the row if you know how to get one row???
        // I want to go from the first row till the last row and print all columns
        rs.beforeFirst();

        while (rs.next()){

            for (int colNum = 1; colNum <= colCount; colNum++){
                System.out.print(rs.getString(colNum) + "\t");
            }
            System.out.println();
        }


    }

}
