package actions_tests;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.amazon_pages.AmazonLandingPage;
import utilites.Driver;

public class AmazonTests {

    @Test
    public void signInLinkHoverTest(){
        //1- get the page first
        Driver.getDriver().get("https://amazon.com");

        //2- create the object of Pages class to reach web elements
        AmazonLandingPage amazonLandingPage = new AmazonLandingPage();

        //3- create the object of Actions class, and pass driver instance
        //into the constructor
        Actions actions = new Actions(Driver.getDriver());

        //4- we will move to the link using actions instance and method
        actions.moveToElement(amazonLandingPage.signInLink).perform();
    }

}
