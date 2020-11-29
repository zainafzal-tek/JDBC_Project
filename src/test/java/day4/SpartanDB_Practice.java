package day4;

import utility.DB_Utility;

public class SpartanDB_Practice {

    //create a main method:
    public static void main(String[] args) {

        //call your create connection method
        DB_Utility.createConnection("sparta");

        //run query SELECT * FROM SPARTANS
        DB_Utility.runQuery("SELECT * FROM SPARTANS");

        //PRINT OUT ROW NUMBER
        System.out.println("DB_Utility.getRowCount() = " + DB_Utility.getRowCount());

        //get all column names and print
        System.out.println("DB_Utility.getColumnNames() = " + DB_Utility.getColumnNames());



        DB_Utility.destroy();

    }

}
