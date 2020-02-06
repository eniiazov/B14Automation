package testng;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HardAssertions {
    SoftAssert softAssert;
    @Test
    public void test1(){
        System.out.println("Test1 is starting...");
        Assert.assertEquals(4,5);

        System.out.println("Test1 middle...");
        Assert.assertTrue(false);

        System.out.println("Test1 is ending...");
    }

    @Test
    public void test2(){
        System.out.println("Test2 is starting...");
    }

    @Test
    public void test3(){
        softAssert = new SoftAssert();

        System.out.println("Test3 is starting...");
        softAssert.assertEquals(4,5 , "SOFT ASSERTION FAILS");

        Assert.assertTrue(false, "HARD ASSERTION FAILS");

        System.out.println("Test3 middle...");
        softAssert.assertTrue(false);

        System.out.println("Test3 is ending...");


    }

    @AfterMethod
    public void tearDown(){
        softAssert.assertAll();
    }

}
