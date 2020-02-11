package actions_tests;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.practice_cybertek_pages.HoversPage;
import utilites.Driver;

public class HoversTests {

    @Test
    public void hoversTests() throws InterruptedException{
        //1- get the page
        Driver.getDriver().get("http://practice.cybertekschool.com/hovers");

        //2- Create the object of the HoversPage class to be able to reach
        //webelements we locate in that class
        HoversPage hoversPage = new HoversPage();

        //3- Create the object of the Actions class, and pass the driver
        Actions actions = new Actions(Driver.getDriver());

        //4- Using "actions" instance, we move to web elements that are previously
        //located in HoversPage class
        actions.moveToElement(hoversPage.image1).perform();

        //5- assert that the expected text is displayed on the page
        Assert.assertTrue(hoversPage.user1Text.isDisplayed());

        //6- move to 2nd image
        Thread.sleep(1000);
        actions.moveToElement(hoversPage.image2).perform();
        //7- assert user2 text is displayed
        Assert.assertTrue(hoversPage.user2Text.isDisplayed());

        //8- move to 3rd image
        Thread.sleep(1000);
        actions.moveToElement(hoversPage.image3).perform();
        //9- assert user3 text is displayed
        Assert.assertTrue(hoversPage.user3Text.isDisplayed());



    }


}
