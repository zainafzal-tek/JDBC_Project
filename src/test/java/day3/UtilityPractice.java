package day3;

import utility.DB_Utility;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UtilityPractice {

    public static void main(String[] args) throws SQLException {

        DB_Utility.createConnection();

        ResultSet jobRS = DB_Utility.runQuery("SELECT * FROM JOBS");

        /**
         * Get the row count of the resultSet
         * move the pointer to the last row and get the row number
         */

        int rowCount = DB_Utility.getRowCount();
        System.out.println("rowCount = " + rowCount);

        int columnCount = DB_Utility.getColumnCount();
        System.out.println("columnCount = " + columnCount);

        System.out.println("All column names = " + DB_Utility.getColumnNames());


    }

}
