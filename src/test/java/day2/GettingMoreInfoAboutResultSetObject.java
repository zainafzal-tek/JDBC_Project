package day2;

import java.sql.*;

public class GettingMoreInfoAboutResultSetObject {

    public static void main(String[] args) throws SQLException {

        String connectionStr = "jdbc:oracle:thin:@54.166.212.192:1521:XE";
        String username = "hr";
        String password = "hr";

        Connection conn = DriverManager.getConnection(connectionStr, username, password);
        Statement statement = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet rs = statement.executeQuery("SELECT * FROM JOBS");

        // MetaData -- data about the data
        // ResultSetMetaData -- data about the ResultSet object that contain our resulting rows and columns
        // for example column names , column count , .. and more
        // This is how we get the metadata

        //ResultSetMetaData itself does not contain any row data
        //it only has information about the columns
        ResultSetMetaData rsmd = rs.getMetaData();
        //we only need two methods from this to get column count and column name

        int colCount = rsmd.getColumnCount();
        System.out.println("Column count = " + colCount);

        //this is how we get column label 1 name using index
        // get first column name
        System.out.println("First column name is " + rsmd.getColumnLabel(1));
        System.out.println("Second column name is " + rsmd.getColumnLabel(2));
        System.out.println("==================================================");

        //now print out all column name:
        for (int i = 1; i <= colCount; i++){
            System.out.println("Column number = " + i);
            System.out.println("Column name is " + rsmd.getColumnLabel(i));
            System.out.println();
        }

    }

}
