package synchronization_tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.practice_cybertek_pages.DynamicLoading2Page;
import utilites.Driver;

public class ThreadSleepTests {

    @Test
    public void threadSleepTest() throws InterruptedException{
        //1- getting the page
        Driver.getDriver().get("http://practice.cybertekschool.com/dynamic_loading/2");

        //2- Creating object to be able to reach Page class' webElements
        DynamicLoading2Page dynamicLoading2Page = new DynamicLoading2Page();

        //3- Clicking to the Start button using the object we created
        dynamicLoading2Page.startButton.click();
        Thread.sleep(5000);
        //4- Assert the webElement is displayed on the page
        Assert.assertTrue(dynamicLoading2Page.helloWordText.isDisplayed(),
                "Text is NOT displayed on the page!");

    }


}
