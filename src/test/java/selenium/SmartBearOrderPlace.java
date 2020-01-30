package selenium;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SmartBearOrderPlace {

    public static void main(String[] args) throws InterruptedException{

        //TC#2: Smartbear software order placing
        // 1.Open	browser
        // 2.Go	to	website:	http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        // 3.Enter username: “Tester”
        // 4.Enter password: “test”
        // 5.Click on Login button
        SmartBearMain.loginToSmartBear(driver);
        // 6.Click on Order
        WebElement orderLink = driver.findElement(By.linkText("Order"));
        orderLink.click();

        // 7.Select familyAlbum from product, set quantity to 2

        WebElement productDropdown = driver.findElement(By.id("ctl00_MainContent_fmwOrder_ddlProduct"));
        Select select = new Select(productDropdown);
        select.selectByVisibleText("FamilyAlbum");

        WebElement inputQuantity = driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtQuantity"));
        //inputQuantity.clear();
        //Thread.sleep(2000);
        inputQuantity.sendKeys(Keys.BACK_SPACE);
        //Thread.sleep(2000);
        inputQuantity.sendKeys( "2");
        //inputQuantity.sendKeys( Keys.BACK_SPACE, "2");

        // 8.Click to “Calculate”button
        WebElement calculateButton = driver.findElement(By.xpath("//input[@value='Calculate']"));
        calculateButton.click();

        // 9.Fill address Info with JavaFaker
        // •Generate: name, street, city, state, zip code
        //command + D to copy paste the line
        WebElement inputName = driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtName"));
        WebElement inputStreet = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox2"));
        WebElement inputCity = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox3"));
        WebElement inputState = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox4"));
        WebElement inputZip = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox5"));

        Faker faker = new Faker();

        inputName.sendKeys(faker.name().fullName());
        inputStreet.sendKeys(faker.address().streetName());
        inputCity.sendKeys(faker.address().city());
        inputState.sendKeys(faker.address().state());
        inputZip.sendKeys(faker.address().zipCode().replaceAll("-", ""));
        //inputZip.sendKeys(faker.address().zipCode().substring(0,5));


        // 10.Click on “visa” radio button
        WebElement visaCheckbox = driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_0"));
        visaCheckbox.click();

        // 11.Generate card number using JavaFaker
        WebElement creditCardInput = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6"));
        creditCardInput.sendKeys(faker.finance().creditCard().replaceAll("-", ""));

        WebElement inputDate = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox1"));
        inputDate.sendKeys("10/25");
        // 12.Click on “Process”
        WebElement processButton = driver.findElement(By.id("ctl00_MainContent_fmwOrder_InsertButton"));
        processButton.click();

        // 13.Verify success message “New order has been successfully added.”
        WebElement successMessage = driver.findElement(By.xpath("//div[@class='buttons_process']/strong"));
        if(successMessage.isDisplayed()){
            System.out.println("Message displayed. Order placed. PASS!");
        }else{
            System.out.println("Message is not displayed. Order NOT placed. FAIL!!!");
        }

    }
}
