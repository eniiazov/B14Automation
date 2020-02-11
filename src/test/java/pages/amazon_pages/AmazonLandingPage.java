package pages.amazon_pages;

import mentorings.tuesday.amazon.AmazonUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilites.Driver;

public class AmazonLandingPage {

    public AmazonLandingPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "nav-link-accountList")
    public WebElement signInLink;

}
