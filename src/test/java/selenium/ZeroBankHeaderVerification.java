package selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ZeroBankHeaderVerification {

    public static void main(String[] args) {


        // TC #2: Zero Bank header verification
        // 1.Open Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        // 2.Go to http://zero.webappsecurity.com/login.html
        driver.get("http://zero.webappsecurity.com/login.html");
        // 3.Verify header textExpected: “Log in to ZeroBank”
        String actualHeader = driver.findElement(By.className("page-header")).getText();
        String expectedHeader = "Log in to ZeroBank";

        if(actualHeader.equals(expectedHeader)){
            System.out.println("Header verification PASSED!");
        }else{
            System.out.println("Header verification FAILED!");
        }

    }

}
