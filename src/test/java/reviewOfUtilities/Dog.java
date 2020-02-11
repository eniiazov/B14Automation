package reviewOfUtilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utilites.Config;
import utilites.Driver;

import java.io.FileInputStream;
import java.util.Properties;

public class Dog {

    public static void main(String[] args) throws Exception{

        WebDriver driver = Driver.getDriver();
        driver.get("http://google.com");
        GoogeHomepage gh = new GoogeHomepage();
        gh.searchBox.sendKeys("Apple" + Keys.ENTER);


    }
}














