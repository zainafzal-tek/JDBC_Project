package day4;

import org.junit.jupiter.api.*;

public class Junit5_Practice {

    @BeforeAll
    public static void setUp(){
        System.out.printf("@BeforeAll is running!");
    }

    @BeforeEach
    public void beforeEachMethod(){
        System.out.println("@BeforeEach is Running");
    }

    @AfterAll
    public static void afterAllMethod(){
        System.out.println("@AfterAll is running!");
    }

    @AfterEach
    public void afterEachMethod(){
        System.out.println("@AfterEach is running!");
    }

    @Test
    public void test1(){
        Assertions.assertEquals(9, 12);
    }

}
