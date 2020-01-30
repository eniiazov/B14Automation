package selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class PracticeCybertekDropdown1 {

    public static void main(String[] args) throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/dropdown");

        //1- we need to locate the dropdown
        WebElement stateDropdown = driver.findElement(By.id("state"));
        Select select = new Select(stateDropdown);

        //to get default value
        String text = select.getFirstSelectedOption().getText();
        System.out.println(text);

        //selectByVisibleText
        Thread.sleep(1000);
        select.selectByVisibleText("California");

        Thread.sleep(1000);
        //selectByIndex --> hawaii
        select.selectByIndex(12);


        //selecting by the attribute value
        Thread.sleep(1000);
        select.selectByValue("FL");

        String expectedOption = "Florida";
        String actualOption = select.getFirstSelectedOption().getText();

        if(actualOption.equals(expectedOption)){
            System.out.println("Final result is Florida. Verification PASSED!");
        }else{
            System.out.println("Verification FAILED!!!");
        }


    }
}
