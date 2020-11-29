package day4;

import utility.DB_Utility;

public class WakeUpTask {

    public static void main(String[] args) {

        DB_Utility.createConnection("employees");

        String query = "SELECT e.FIRST_NAME , d.DEPARTMENT_NAME , e.SALARY " +
                "FROM EMPLOYEES e " +
                "INNER JOIN DEPARTMENTS d ON e.DEPARTMENT_ID = d.DEPARTMENT_ID " +
                "WHERE SALARY IN (   SELECT MAX(e.SALARY)  " +
                "                        FROM EMPLOYEES e " +
                "                        INNER JOIN DEPARTMENTS d ON e.DEPARTMENT_ID = d.DEPARTMENT_ID " +
                "                        GROUP BY d.DEPARTMENT_NAME   ) " +
                "ORDER BY 1  ";

        DB_Utility.runQuery(query);
        //DB_Utility.displayAllData();

        System.out.println("DB_Utility.getRowCount() = " + DB_Utility.getRowCount() );
        System.out.println("DB_Utility.getColumnCount() = " + DB_Utility.getColumnCount());
        System.out.println("DB_Utility.getColumnDataAsList(\"FIRST_NAME\") = \n\t"
                + DB_Utility.getColumnDataAsList("FIRST_NAME"));

        System.out.println("DB_Utility.getRowMap(2) = \n\t"
                + DB_Utility.getRowMap(2));

        System.out.println("DB_Utility.getColumnDataAtRow(3,\"DEPARTMENT_NAME\") = \n\t"
                + DB_Utility.getColumnDataAtRow(3, "DEPARTMENT_NAME"));

        System.out.println("DB_Utility.getRowDataAsList(3) = \n\t"
                + DB_Utility.getRowDataAsList(3));

        System.out.println("DB_Utility.getAllDataAsListOfMap() = \n\t"
                + DB_Utility.getAllDataAsListOfMap());

        System.out.println("DB_Utility.getColumnNames() = " + DB_Utility.getColumnNames());

        DB_Utility.destroy();

    }

}
