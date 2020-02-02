package testng;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
/*
This class does
 */
public class OrderOfThings {

    @Test (priority = -1 )
    public void firstTest(){
        System.out.println("Test one is running");
    }

    @Ignore
    @Test (priority = 2)
    public void secondTest(){
        System.out.println("Test two is running");
    }
    //....
    @Test
    public void thirdTest(){
        System.out.println("Test three is running");
    }

}
