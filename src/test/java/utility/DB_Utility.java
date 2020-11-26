package utility;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DB_Utility {

    static Connection conn ; // make it static field so we can reuse in every methods we write
    static Statement stmnt ;
    static ResultSet rs ;


    public static void createConnection(){

        String connectionStr = "jdbc:oracle:thin:@54.166.212.192:1521:XE";
        String username = "hr";
        String password = "hr";
        try {
            conn = DriverManager.getConnection(connectionStr, username, password);
        } catch (SQLException e){
            System.out.println("Connection has failed!!! " + e.getMessage());
        }
    }

    // Create a method called runQuery that accept a SQL Query
    // and return ResultSet Object
    public static ResultSet runQuery(String query){

        //ResultSet rs  = null;
        // reusing the connection built from previous method
        try {
            stmnt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stmnt.executeQuery(query) ;

        } catch (SQLException e) {
            System.out.println("Error while getting resultset " + e.getMessage());
        }
        return rs ;
    }

    // create a method to clean up all the connection statemnet and resultset
    public static void destroy(){

        try {

            rs.close();
            stmnt.close();
            conn.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /**
     * Count how many row we have
     * @return the row count of the resultset we got
     */
    public static int getRowCount(){

        int rowCount = 0 ;

        try {
            rs.last();
            rowCount = rs.getRow() ;

            // move the cursor back to beforeFirst location to avoid accident
            rs.beforeFirst();

        } catch (SQLException e) {

            System.out.println("ERROR WHILE GETTING ROW COUNT "  + e.getMessage() );
        }

        return rowCount ;

    }

    /**
     * Get the column count
     * @return count of column the result set have
     */
    public static int getColumnCount(){

        int columnCount = 0 ;

        try {
            ResultSetMetaData rsmd = rs.getMetaData() ;
            columnCount = rsmd.getColumnCount();

        } catch (SQLException e) {
            System.out.println("ERROR WHILE COUNTING THE COLUMNS " + e.getMessage() );
        }

        return columnCount ;
    }

    /**
     * A method that returns all the column name as List<String>
     */
    public static List<String> getColumnNames(){

        List<String> columnList = new ArrayList<>();

        try {
            ResultSetMetaData rsmd = rs.getMetaData();

            for (int colNum = 1; colNum <= getColumnCount(); colNum++){
                String columnName = rsmd.getColumnLabel(colNum);
                columnList.add(columnName);
            }

        } catch (SQLException e) {
            System.out.println("ERROR WHILE GETTING ALL COLUMN NAMEs" + e.getMessage());
        }

        return columnList;
    }

    /**
     * Create a method that return all row data as a List<String>
     * @param rowNum Row number you want to get the data
     * @return the row data as List object
     */
    public static List<String> getRowDataAsList(int rowNum){

        List<String> rowDataList = new ArrayList<>();

        // first we need to move the pointer to the location the rowNum specified
        try {
            rs.absolute(rowNum) ;

            for (int colNum = 1; colNum <= getColumnCount() ; colNum++) {

                String cellValue = rs.getString( colNum ) ;
                rowDataList.add( cellValue ) ;

            }
            rs.beforeFirst();

        } catch (SQLException e) {
            System.out.println("ERROR WHILE GETTING ROW DATA AS LIST " + e.getMessage() );
        }
        return rowDataList ;

    }

    /**
     * Create a method to return the cell value at certain row certain column
     * @param rowNum
     * @param colNum
     * @return cell value as string
     */
    public static String getColumnDataAtRow(int rowNum, int colNum){
        String result = "";

        try {
            rs.absolute(rowNum);
            result = rs.getString(colNum);
            rs.beforeFirst();

        } catch (SQLException e){
            System.out.println("ERROR WHILE GETTING CELL VALUE AT ROWNUM COLUMN" + e.getMessage());
        }
        return result;
    }

    /**
     * Create a method to return the cell value at certain row certain column
     * @param rowNum  row number
     * @parem colName column name
     * @return Cell value as String
     */
    public static String getColumnDataAtRow(int rowNum, String colName){

        String result = "" ;

        try {
            rs.absolute(rowNum) ;
            result = rs.getString( colName ) ;
            rs.beforeFirst(); // moving back to before first location

        } catch (SQLException e) {
            System.out.println("ERROR WHILE GETTING CELL VALUE AT ROWNUM column name " + e.getMessage() );
        }

        return result ;
    }

}
