package pageObjectModelTests;

import org.testng.annotations.Test;
import pages.vytrack_pages.VytrackLoginPage;
import utilites.Config;
import utilites.Driver;

public class LoginTests {

    @Test
    public void positiveLoginScenario(){

        String username = Config.getProperty("storemanagerUsername");
        String password = Config.getProperty("storemanagerPassword");
        Driver.getDriver().get(Config.getProperty("vytrackUrl"));

        VytrackLoginPage vytrackLoginPage = new VytrackLoginPage();
        vytrackLoginPage.usernameInput.sendKeys(username);
        vytrackLoginPage.passwordInput.sendKeys(password);
        vytrackLoginPage.loginButton.click();

    }
}









