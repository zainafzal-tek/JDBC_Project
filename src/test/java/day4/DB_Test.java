package day4;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import utility.DB_Utility;

public class DB_Test {

    @BeforeAll
    public static void init(){
        System.out.println("::: Starting TEST :::");
        DB_Utility.createConnection("employees");
    }

    @Test
    public void testEmployeeCount(){
        //run a query SELECT * FROM EMPLOYEES
        //assert that the employees count is 107

        String query = "SELECT * FROM EMPLOYEES";
        DB_Utility.runQuery(query);

        int employeeCount = DB_Utility.getRowCount();
        Assertions.assertEquals(107, employeeCount, "Employee count is not equal");

    }

    @Test
    public void testAsiaRow(){
        String query = "SELECT * FROM REGIONS";
        DB_Utility.runQuery(query);

        String thirdRowSecondColumn = DB_Utility.getColumnDataAtRow(3 ,2);
        Assertions.assertEquals("Asia", thirdRowSecondColumn, "Test failed, not equal to Asia!!!");
    }

    @AfterAll
    public static void tearDown(){
        System.out.println("::: Ending TEST :::");
        DB_Utility.destroy();
    }

}
