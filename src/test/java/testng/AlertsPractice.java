package testng;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AlertsPractice {
    WebDriver driver;

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/javascript_alerts");
    }

    @Test
    public void informationAlert(){
        WebElement infoAlertButton = driver.findElement(By.xpath("//button[.='Click for JS Alert']"));

        infoAlertButton.click();

        Alert alert = driver.switchTo().alert();
        alert.accept();

        WebElement resultText = driver.findElement(By.id("result"));
        String expectedText ="You successfuly clicked an alert";
        String actualText = resultText.getText();

        Assert.assertEquals(actualText,expectedText, "Texts are not matching. Assertion failed.");
        //Assert.assertTrue(resultText.isDisplayed(), "Result text is NOT displayed.");
        //Assert.assertTrue(actualText.equals(expectedText), "Result text is NOT displayed.");

    }

    @Test
    public void confirmationAlert(){
        WebElement confirmationAlertButton = driver.findElement(By.xpath("//button[.='Click for JS Confirm']"));

        confirmationAlertButton.click();

        Alert alert = driver.switchTo().alert();
        alert.accept();

        WebElement resultText = driver.findElement(By.id("result"));
        String expectedText ="You clicked: Ok";
        String actualText = resultText.getText();

        Assert.assertEquals(actualText,expectedText, "Texts are not matching. Assertion failed.");

    }

    @Test
    public void promptAlert(){
        WebElement promptAlertButton = driver.findElement(By.xpath("//button[.='Click for JS Prompt']"));

        promptAlertButton.click();

        Alert alert = driver.switchTo().alert();
        alert.sendKeys("hello");
        alert.dismiss();

        WebElement resultText = driver.findElement(By.id("result"));
        String expectedText ="You entered: hello";
        String actualText = resultText.getText();

        Assert.assertEquals(actualText,expectedText, "Texts are not matching. Assertion failed.");

    }


}
