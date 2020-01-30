package selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class EtsyTitleVerification {

    public static void main(String[] args) {
        //TC #1: Etsy Title Verification
        // 1.Open Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        // 2.Go to https://www.etsy.com
        driver.get("https://www.etsy.com");
        // 3.Search for “wooden spoon”
        driver.findElement(By.id("global-enhancements-search-query"))
                .sendKeys("wooden spoon");

        driver.findElement(By.className("wt-input-btn-group__btn")).click();

        // 4.Verify title: Expected: “Wooden spoon | Etsy”
        String actualTitle = driver.getTitle();
        String expectedTitle = "Wooden spoon | Etsy";

        if(actualTitle.equals(expectedTitle)){
            System.out.println("Etsy title verification PASSED!");
        }else{
            System.out.println("Etys title verification FAILED!");
        }
    }
}
