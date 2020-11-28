package day4;

import utility.DB_Utility;

public class WakeUpTask {

    public static void main(String[] args) {

        DB_Utility.createConnection();

        String query = "SELECT e.FIRST_NAME , d.DEPARTMENT_NAME , e.SALARY " +
                "FROM EMPLOYEES e " +
                "INNER JOIN DEPARTMENTS d ON e.DEPARTMENT_ID = d.DEPARTMENT_ID " +
                "WHERE SALARY IN (   SELECT MAX(e.SALARY)  " +
                "                        FROM EMPLOYEES e " +
                "                        INNER JOIN DEPARTMENTS d ON e.DEPARTMENT_ID = d.DEPARTMENT_ID " +
                "                        GROUP BY d.DEPARTMENT_NAME   ) " +
                "ORDER BY 1  ";

        DB_Utility.runQuery(query);
        DB_Utility.displayAllData();

    }

}
