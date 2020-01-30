package selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class CheckboxPractice1 {
    public static void main(String[] args) {


        //Practice:	Cybertek	Checkboxes
        // 1.Go	to	http://practice.cybertekschool.com/checkboxes
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/checkboxes");
        // 2.Confirm	checkbox	#1	is	NOT	selected	by	default
        WebElement checkbox1 = driver.findElement(By.xpath("//input[@type='checkbox'][1]"));
        // another locator for same webElement //form[@id='checkboxes']/input[1]
        if(!checkbox1.isSelected()){
            System.out.println("Default checkbox1 value verification PASSED!");
        }else{
            System.out.println("Default checkbox1 value verification FAILED!!!");
        }
        // 3.Confirm	checkbox	#2	is	SELECTED	by	default.
        WebElement checkbox2 = driver.findElement(By.xpath("//input[@type='checkbox'][2]"));
        if(checkbox2.isSelected()){
            System.out.println("Default checkbox2 value verification PASSED!");
        }else{
            System.out.println("Default checkbox2 value verification FAILED!!!");
        }
        // 4.Click	checkbox	#1	to	select	it.
        checkbox1.click();

        // 5.Click	checkbox	#2	to	deselect	it.
        checkbox2.click();

        // 6.Confirm	checkbox	#1	is	SELECTED.
        if(checkbox1.isSelected()){
            System.out.println("Checkbox1 value verification PASSED!");
        }else{
            System.out.println("Checkbox1 value verification FAILED!!!");
        }
        // 7.Confirm	checkbox	#2	is	NOT	selected.
        if(!checkbox2.isSelected()){
            System.out.println("Checkbox2 value verification PASSED!");
        }else{
            System.out.println("Checkbox2 value verification FAILED!!!");
        }
    }
}
