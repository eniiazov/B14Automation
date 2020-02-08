    package pageObjectModelTests;

    import org.testng.Assert;
    import org.testng.annotations.BeforeMethod;
    import org.testng.annotations.Test;
    import pages.smartbear_pages.LoginPage;
    import utilites.Config;
    import utilites.Driver;

    public class SmartBearLoginTests {

        LoginPage loginPage = new LoginPage();

        @BeforeMethod
        public void setUp(){
            //1- we get the page
            Driver.getDriver().get(Config.getProperty("smartbearUrl"));
        }

        @Test
        public void wrongUsernameTest(){

            //2- we enter wrong username
            String wrongusername = Config.getProperty("wrongUsername");
            loginPage.usernameInput.sendKeys(wrongusername);

            //3- we enter correct password
            String correctpassword = Config.getProperty("correctPassword");
            loginPage.passwordInput.sendKeys(correctpassword);

            //4- click login button
            loginPage.loginButton.click();

            //5- verify error message
            Assert.assertTrue(loginPage.errorMessage.isDisplayed(), "Error message is NOT displayed!");

        }

        @Test
        public void wrongPasswordTest(){
            //1- getting the page in before method
            //2- enter correct username
            loginPage.usernameInput.sendKeys(Config.getProperty("correctUsername"));
            //3- enter wrong password
            loginPage.passwordInput.sendKeys(Config.getProperty("wrongPassword"));
            //4- click to login button
            loginPage.loginButton.click();
            //5- assert error message is displayed
            Assert.assertTrue(loginPage.errorMessage.isDisplayed(), "Error message is NOT displayed!");

        }

        @Test
        public void noUsernameTest(){
            //1- getting the page in beforeMethod
            //2- not entering username

            //3- enter correct password
            loginPage.passwordInput.sendKeys(Config.getProperty("correctPassword"));
            //4- click login button
            loginPage.loginButton.click();
            //5- assert error message is displayed
            Assert.assertTrue(loginPage.errorMessage.isDisplayed(), "Error message is NOT displayed!");
        }

        @Test
        public void noPasswordTest(){
            //1- Getting the page in beforemethod
            //2- enter correct username
            loginPage.usernameInput.sendKeys(Config.getProperty("correctUsername"));
            //3- we DO NOT enter password
            //4- click to login button
            loginPage.loginButton.click();
            //5- assert error message is displayed
            Assert.assertTrue(loginPage.errorMessage.isDisplayed(), "Error message is NOT displayed!");
        }


    }
