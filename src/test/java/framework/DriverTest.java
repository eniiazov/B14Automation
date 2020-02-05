package framework;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import utilites.Driver;

public class DriverTest {

    @Test
    public void test() {

        Driver.getDriver().get("https://amazon.com");

        Driver.getDriver().findElement(By.id("twotabsearchtextbox")).sendKeys("apple" + Keys.ENTER);



    }

}
