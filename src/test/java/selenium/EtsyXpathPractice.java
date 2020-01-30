package selenium;

import com.google.common.base.Verify;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class EtsyXpathPractice {

    public static void main(String[] args) {


        //TC#2 Search ETSY
        //1. Open browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        //2. Go to https://etsy.com
        driver.get("https://www.etsy.com");
        //3. Enter any search term
        // we need to locate search box using xpath
        WebElement etsySearchBox = driver.findElement(By.xpath("//input[@name='search_query']"));
        //WebElement manageInterestCollectionOnTheLeft
        etsySearchBox.sendKeys("wooden spoon");

        //4. Click search button

        WebElement etsySearchButton = driver.findElement(By.xpath("//button[@value='Search']"));
        etsySearchButton.click();

        //5. Verify title contains the search term
        //USE XPATH TO LOCATORS TO LOCATE WEBELEMENTS
        String actualTitle = driver.getTitle();
        String expectedInTitle = "Wooden spoon";

        if (actualTitle.contains(expectedInTitle)){
            System.out.println("Title verification PASSED!");
        }else{
            System.out.println("Title verification FAILED!");
        }

    }
}
