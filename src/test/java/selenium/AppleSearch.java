package selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AppleSearch {

    public static void main(String[] args) {

        //TC#4:	Google	search
        WebDriverManager.chromedriver().setup();
        // 1-Open	a	chrome	browser
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        // 2-Go	to:	https://google.com
        driver.get("https://www.google.com");
        // 3-Write	“apple”	in	search	box
        //driver.findElement(By.name("q")).sendKeys("apple");
        driver.findElement(By.name("q")).sendKeys("apple" + Keys.ENTER);
        // 4-Click	google	search	button
        driver.findElement(By.name("btnK")).click();

        // 5-Verify	title:Expected:	Title	should	start	with	“apple
        String actualTitle = driver.getTitle();
        String expectedInTitle = "apple";

        if(actualTitle.startsWith(expectedInTitle)){
            System.out.println("Apple search title verification PASSED!");
        }else{
            System.out.println("Apple search title verification FAILED!");
        }
    }

}
