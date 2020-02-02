package selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleEx9 {


    public static void main(String[] args) {

        // TC	#1:	Google	Title	Verification
        // 1.Open	Chrome	browser
        WebDriverManager.chromedriver().setup();
        //to open the browser
        WebDriver driver = new ChromeDriver();
        //maximize the window size
        driver.manage().window().maximize();

        // 2.Go	to	https://www.google.com
        driver.get("https://www.google.com");


        System.out.println(driver.findElement(By.xpath("//input[@id='gbqfbb']")).getAttribute("value"));
    }
}
