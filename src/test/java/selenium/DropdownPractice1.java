package selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class DropdownPractice1 {

    public static void main(String[] args) {
        //TC #1: Selecting date on dropdown and verifying
        // 1.Open Chrome browser
        // 2.Go to http://practice.cybertekschool.com/dropdown
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/dropdown");
        // 3.Verify “Select your date of birth” dropdowns are selected todays date by default.
        String expectedDay = "26";
        String expectedMonth = "January";
        String expectedYear = "2020";

        Select dayDropdown = new Select(driver.findElement(By.id("day")));
        String actualDay = dayDropdown.getFirstSelectedOption().getText();

        Select monthDropdown = new Select(driver.findElement(By.id("month")));
        String actualMonth = monthDropdown.getFirstSelectedOption().getText();

        Select yearDropdown = new Select(driver.findElement(By.id("year")));
        String actualYear = yearDropdown.getFirstSelectedOption().getText();

        if(expectedDay.equals(actualDay) && expectedMonth.equals(actualMonth) && expectedYear.equals(actualYear)){
            System.out.println("Default selected options verification PASSED!");
        }else{
            System.out.println("Default selected options verification FAILED!!!");
        }

        // 4.Select “December 31st, 1921” and verify it is selected.Use all Select options
        yearDropdown.selectByValue("1921");
        monthDropdown.selectByIndex(11);
        dayDropdown.selectByVisibleText("31");

        String expectedSelectedDay = "31";
        String expectedSelectedMonth = "December";
        String expectedSelectedYear = "1921";

        String actualSelectedDay = dayDropdown.getFirstSelectedOption().getText();
        String actualSelectedMonth = monthDropdown.getFirstSelectedOption().getText();
        String actualSelectedYear = yearDropdown.getFirstSelectedOption().getText();

        if(actualSelectedYear.equals(expectedSelectedYear) && actualSelectedMonth.equals(expectedSelectedMonth) &&
        actualSelectedDay.equals(expectedSelectedDay)){
            System.out.println("Date is correct. Selected values verification PASSED!");
        }else{
            System.out.println("Date is incorrect. Selected values verifications FAILED!");
        }



    }
}
