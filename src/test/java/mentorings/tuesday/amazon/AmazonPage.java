package mentorings.tuesday.amazon;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilites.Config;

import java.util.List;

public class AmazonPage extends BasePage {

    String url = "https://www.amazon.com/";

    AmazonUtils utils = new AmazonUtils();

    @Test
    public void navigateTo() {

        driver.get(url);

        String actualUrl = driver.getCurrentUrl();
        System.out.println(actualUrl);
        Assert.assertEquals(url, actualUrl);
    }

    //Expected size = 47

    @Test
    public void validateCategroriesSize() {

        driver.get(url);
        driver.findElement(By.id("nav-hamburger-menu")).click();
        int expCategoriesSize = 47;
        List<WebElement> categoriesList = driver
                .findElements(By.cssSelector("ul.hmenu-visible li"));
        Assert.assertEquals(expCategoriesSize, categoriesList.size());
    }

    @Test
    public void clickCategory() {
        driver.get(url);
        driver.findElement(By.id("nav-hamburger-menu")).click();
        String categorName = "Prime Video";
        utils.clickCategory(categorName);
        verifyHeader(categorName);
    }

    @Test
    public void clickCategoryFromList() {
        driver.get(url);
        driver.findElement(By.id("nav-hamburger-menu")).click();
        String categorName = "Prime Video";
        utils.clickCategoryFromList(categorName).click();
        verifyHeader(categorName);
    }

    private void verifyHeader(String categorName) {
        String expectedHeader = driver
                .findElements(By.cssSelector("ul.hmenu-visible .hmenu-title"))
                .get(0)
                .getText();
        Assert.assertTrue(categorName.equalsIgnoreCase(expectedHeader));
    }
}
