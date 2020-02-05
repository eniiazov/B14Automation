package mentorings.tuesday.amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AmazonUtils extends BasePage {


    public void clickCategory(String categoryName) {
        By xpathExpression = By.xpath("//ul[@class='hmenu  hmenu-visible']//div[contains(text(),'"
                + categoryName + "')]");
        driver
                .findElement(xpathExpression)
                .click();
        /*
        String categoryXpath = "//ul[@class='hmenu  hmenu-visible']//div[contains(text(),'"
                + categoryName + "')]";
        driver.findElement(By.xpath(categoryXpath)).click();
        */
    }

    public WebElement clickCategoryFromList(String categoryName) {

        List<WebElement> categoryList = driver.findElements(By.cssSelector("ul.hmenu-visible li"));
        for (WebElement category : categoryList) {
            if (category.getText().contains(categoryName))
                return category;
        }
        return null;
    }


}
