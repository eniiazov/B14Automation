package framework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilites.Config;
import utilites.VytrackUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesTest {

    @Test
    public void test1() throws IOException {

//        1) Create the path of the file

        String path = "test.properties";

//        2) Properties object

        Properties properties = new Properties();

//        3) Open the file using FileInputStream

        FileInputStream file = new FileInputStream(path);

//        4) Load the properties file into the properties object

        properties.load(file);

//        5) Read the values using getProperty() method

        System.out.println(properties.getProperty("name"));
        System.out.println(properties.getProperty("username"));
        System.out.println(properties.getProperty("password"));

    }


    @Test
    public void testWithUtil() {

        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get(Config.getProperty("vytrackUrl"));

        VytrackUtils.login(driver, Config.getProperty("storemanagerUsername"),Config.getProperty("storemanagerPassword"));


    }


























}
