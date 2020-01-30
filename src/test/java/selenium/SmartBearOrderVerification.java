package selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SmartBearOrderVerification {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        SmartBearMain.loginToSmartBear(driver);
        //clicking view all orders
        driver.findElement(By.linkText("View all orders")).click();

        WebElement susansDate = driver.findElement(By.xpath("//td[.='Susan McLaren']/../td[5]"));
        WebElement susansDate2 = driver.findElement(By.xpath("//td[.='Susan McLaren']/following-sibling::td[3]"));

        String expectedDate = "01/05/2010";
        String actualDate = susansDate.getText();

        if (actualDate.equals(expectedDate)){
            System.out.println("Date is as expected. Verification PASSED!");
        }else{
            System.out.println("Date is not as expected. Verification FAILED!!!");
        }


     }
}
