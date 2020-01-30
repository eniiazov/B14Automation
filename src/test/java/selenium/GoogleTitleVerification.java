package selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleTitleVerification {

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

        // 3.Verify	title:	Expected:	Google
        String expectedTitle = "Google";
        String actualTitle = driver.getTitle();

        if(actualTitle.equals(expectedTitle)){
            System.out.println("Google title verification PASSED!");
        }else{
            System.out.println("Google title verification FAILED!!!");
        }

//        if(driver.getTitle().equals("Google")){
//            System.out.println("PASSED");
//        }else{
//            System.out.println("FAILED");
//        }

    }
}
