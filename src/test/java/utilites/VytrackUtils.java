package utilites;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class VytrackUtils {

    private static String usernameLocatorID = "prependedInput";
    private static String passwordLocatorID = "prependedInput2";

    public static void login(WebDriver driver, String username, String password) {
        driver.findElement(By.id(usernameLocatorID)).sendKeys(username);
        driver.findElement(By.id(passwordLocatorID)).sendKeys(password + Keys.ENTER);
        SeleniumUtils.pause(5);
    }

    public static void navigateToModule(WebDriver driver, String tab, String module) {

        String tabLocatorXpath = "//span[contains(text(), '" + tab + "') and @class = 'title title-level-1']";
        String moduleLocatorXpath = "//span[.= '" + module + "']";

        driver.findElement(By.xpath(tabLocatorXpath)).click();

        SeleniumUtils.pause(2);

        driver.findElement(By.xpath(moduleLocatorXpath)).click();

        SeleniumUtils.pause(2);
    }


}
