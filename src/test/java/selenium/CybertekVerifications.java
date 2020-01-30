package selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CybertekVerifications {

    public static void main(String[] args) throws InterruptedException {

        //1- open the browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        //2- go to cybertek website
        driver.get("https://www.cybertekschool.com");

        Thread.sleep(6000);

        //3- verify title: Expected: Cybertek
        String expectedTitle = "Cybertek";
        String actualTitle = driver.getTitle();

        if(actualTitle.equals(expectedTitle)){
            System.out.println("Cybertek title verification PASSED!");
        }else{
            System.out.println("Cybertek title verification FAILED!");
        }

        //4- verify url: Expected Contains : cybertekschool
        String expectedInUrl = "cybertekschool";
        String actualUrl = driver.getCurrentUrl(); //https://www.cybertekschool.com

        if(actualUrl.contains(expectedInUrl)){
            System.out.println("Cybertek URL verification PASSED!");
        }else{
            System.out.println("Cybertek URL verification FAILED!");
        }

    }
}
