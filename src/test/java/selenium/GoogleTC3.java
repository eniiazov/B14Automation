package selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleTC3 {
    /*

     */

    public static void main(String[] args) {

        //TC#3:	Back	and	forth	navigation
        //  1-Open	a	chrome	browser
        // 2-Go	to:	https://google.com
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com");


        // 3-Click	to	Gmail	from	top	right.
        driver.findElement(By.linkText("Gmail")).click();
        // 4-Verify	title	contains:Expected:	Gmail

        String actualTitle = driver.getTitle();
        String expectedInTitle = "Gmail";

        if(actualTitle.contains(expectedInTitle)){
            System.out.println("Gmail title verification PASSED!");
        }else{
            System.out.println("Gmail title verification FAILED!");
        }
        // 5-Go	back to	Google	by	using the	.back();

        driver.navigate().back();

        // 6-Verify	title	EQUALS:Expected:	Google

        String actualTitleGoogle = driver.getTitle();
        String expectedTitleGoogle = "Google";

        if(actualTitleGoogle.equals(expectedTitleGoogle)){
            System.out.println("Google title verification passed!");
        }else{
            System.out.println("Google title verification failed!");
        }

        // 7-Go	back	to	Gmail	using	the	Forward	button
        driver.navigate().forward();
        // 8-Verify	title	contains:Expected:	Gmail
        if(driver.getTitle().contains("Gmail")){
            System.out.println("Gmail title verification PASSED AGAIN!!!");
        }else{
            System.out.println("Gmail title verificaiton FAILED!");
        }
    }
}
