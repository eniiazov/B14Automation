package testng;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import selenium.SmartBearMain;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SmartbearDeleteAll {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
    }

    @Test
    public void deleteAllTest() throws  InterruptedException{
        SmartBearMain.loginToSmartBear(driver);
        WebElement checkAll = driver.findElement(By.id("ctl00_MainContent_btnCheckAll"));
        checkAll.click();

        List<WebElement> checkboxes = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr/td[1]"));

        for(WebElement checkbox : checkboxes){
            //Thread.sleep(1000);
            //Assert.assertTrue(checkbox.isEnabled());
            //assertTrue accepts boolean condition

        }

        WebElement deleteSelectedButton = driver.findElement(By.id("ctl00_MainContent_btnDelete"));
        deleteSelectedButton.click();

        WebElement emptyOrderListMessage = driver.findElement(By.id("ctl00_MainContent_orderMessage"));

        Assert.assertTrue(emptyOrderListMessage.isDisplayed(), "Empty order list message is NOT displayed.");

    }
}
