package selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleAttributeValue {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com");

        String imagesLink = driver.findElement(By.linkText("Images")).getAttribute("href");
        System.out.println(imagesLink);

        String datapid = driver.findElement(By.linkText("Images")).getAttribute("data-pid");
        System.out.println("Value of data-pid attribute: " + datapid);

    }
}
