package selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DropdownPractice2 {

    public static void main(String[] args) throws InterruptedException{

        //TC #2: Selecting value from multiple select dropdown
        // 1.Open Chrome browser
        // 2.Go to http://practice.cybertekschool.com/dropdown
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/dropdown");
        // 3.Select all the options from multiple select dropdown.

        Select multipleSelectDropdown = new Select(driver.findElement(By.name("Languages")));

        List<WebElement> options = multipleSelectDropdown.getOptions();

        for(WebElement option: options){
            Thread.sleep(500);
            //option.click();
            multipleSelectDropdown.selectByVisibleText(option.getText());
        }
        // 4.Print out all selected values.
         List<WebElement> selectedOptions =  multipleSelectDropdown.getAllSelectedOptions();
        for (WebElement selectedOption : selectedOptions){
            System.out.println(selectedOption.getText());
        }
        // 5.Deselect all values.
        Thread.sleep(1000);
        multipleSelectDropdown.deselectAll();

    }
}
