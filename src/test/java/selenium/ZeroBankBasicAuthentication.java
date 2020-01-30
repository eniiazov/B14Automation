package selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ZeroBankBasicAuthentication {

    public static void main(String[] args) {


        //TC #5: Basic authentication Zero Bank
        // 1.Open Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        // 2.Go to http://zero.webappsecurity.com/login.html
        driver.get("http://zero.webappsecurity.com/login.html");
        // 3.Enter username: username
        driver.findElement(By.id("user_login")).sendKeys("username");
        // 4.Enter password: password
        driver.findElement(By.id("user_password")).sendKeys("password");
        // 5.Click sign in button
        driver.findElement(By.name("submit")).click();

        // 6.Verify username is displayed on the page
        WebElement usernameLink = driver.findElement(By.linkText("username"));
        if(usernameLink.isDisplayed()){
            System.out.println("Username verification is PASSED!");
            System.out.println("Username is displayed on the page.");
        }else{
            System.out.println("Username verification is FAILED!");
            System.out.println("Username is not displayed on the page.");
        }

        // 7.Verify the title Zero – Account Summary
        String actualTitle = driver.getTitle();
        String expectedTitle = "Zero - Account Summary";

        if(actualTitle.equals(expectedTitle)){
            System.out.println("Title verification PASSED!");
        }else {
            System.out.println("Title verification FAILED!");
        }

        // 8.Verify the link Account Summary’s href value contains: “account-summary”
        WebElement accountSummaryLink = driver.findElement(By.linkText("Account Summary"));
        String actualLinkValue = accountSummaryLink.getAttribute("href");
        //String actualLinkValue = driver.findElement(By.linkText("Account Summary")).getAttribute("href");
        String expectedInLink = "account-summary";

        if(actualLinkValue.contains(expectedInLink)){
            System.out.println("Link verification PASSED!");
        }else{
            System.out.println("Link verification FAILED!");
        }
        accountSummaryLink.isDisplayed();



        // Print out results in validation formats
    }
}
