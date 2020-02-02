package testng;

import org.testng.Assert;
import org.testng.annotations.*;

public class FirstTestNGClass {

//    public static void main(String[] args) {
//
//    }

    @BeforeClass
    public void setUp(){
        System.out.println("BeforeClass is running...");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("BeforeMethod is running...");
        // statement: loging in an verifying title to make sure i am on the correct page
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("Aftermethod is running...");
    }

    @AfterClass
    public void tearDown(){
        System.out.println("AfterClass is running...");
    }

    @Test
    public void bfirstTest(){

        System.out.println("1st test is running...");

//        if("q".equals("q")){
//            System.out.println("PASS!");
//        }else{
//            System.out.println("FAIL!");
//        }

        Assert.assertEquals("actualValue","actualValue","First test is failed.");
        Assert.assertEquals(1,1,"First test is failed.");

    }

    @Test
    public void asecondTest(){

        System.out.println("2nd test is running...");
        String letter = "e";
        Assert.assertTrue(!"sentence".contains(letter), "Sentence does not contain: " + letter);
    }



}
