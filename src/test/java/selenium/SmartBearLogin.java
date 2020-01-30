package selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SmartBearLogin {

    public static void main(String[] args) throws InterruptedException{

        //TC#5:	Basic	login	authentication
        // 1-Open	a	chrome	browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        // 2-Go	to:	http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        // 3-Verify	title	equals:Expected:	Web	Orders	Login
        String actualTitle = driver.getTitle();
        String expectedTitle = "Web Orders Login";

        if(actualTitle.equals(expectedTitle)){
            System.out.println("Login page title verification PASSED!");
        }else{
            System.out.println("Login page title verification FAILED!");
        }
        // 4-Enter	username:	Tester
        driver.findElement(By.name("ctl00$MainContent$username")).sendKeys("Tester");
        // 5-
        driver.findElement(By.name("ctl00$MainContent$password")).sendKeys("test");
        //driver.findElement(By.name("ctl00$MainContent$password")).sendKeys("test" + Keys.ENTER);
        // 6-Click	“Sign	In”	button
        Thread.sleep(2000);
        driver.findElement(By.name("ctl00$MainContent$login_button")).click();

        // 7-Verify	title equals:Expected:	Web	Orders
        String expectedLoginTitle = "Web Orders";
        String actualLoginTitle = driver.getTitle();

        if(actualLoginTitle.equals(expectedLoginTitle)){
            System.out.println("Landing page title verification PASSED!");
        }else{
            System.out.println("Landing page title verification FAILED!");
        }

    }

}
