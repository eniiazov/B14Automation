package selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class PracticeXpathCybertek2 {

    public static void main(String[] args) throws InterruptedException{



        // TC #2: PracticeCybertek.com_AddRemoveElementsWebElement verification
        // 1.Open Chrome browser
        // 2.Go to http://practice.cybertekschool.com/add_remove_elements

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/add_remove_elements/");

        // 3.Click to “Add Element” button
        WebElement addElementButton = driver.findElement(By.xpath("//button[.='Add Element']"));

        Thread.sleep(2000);

        addElementButton.click();

        // 4.Verify “Delete” button is displayed after clicking.
        WebElement deleteButton = driver.findElement(By.xpath("//button[.='Delete']"));  //REFID2355456
        if(deleteButton.isDisplayed()){
            System.out.println("Delete button is displayed. Verification PASSED!");
        }else{
            System.out.println("Delete button is not displayed! Verification FAILED!!!");
        }

        Thread.sleep(2000);

        // 5.Click to “Delete” button.

        deleteButton.click();


        // 6.Verify “Delete” button is NOT displayed after clicking.

        try {
            WebElement deleteButtonReferenceAfterClick = driver.findElement(By.xpath("//button[.='Delete']"));
            if (deleteButtonReferenceAfterClick.isDisplayed()) {
                System.out.println("Delete button is displayed. Verification FAILED!!!");
            } else {
                System.out.println("Delete button is NOT displayed. Verification PASSED!!!");
            }
        }catch (NoSuchElementException a){
            System.out.println("Delete button is not displayed. Verification PASSED!");
        }

    }
}
