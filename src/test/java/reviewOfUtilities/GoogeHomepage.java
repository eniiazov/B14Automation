package reviewOfUtilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilites.Driver;

public class GoogeHomepage {


    public GoogeHomepage(){
        PageFactory.initElements(Driver.getDriver(), this);
        // synchronizes the pages and elements
        // makes all below web elements ready to use
    }

    @FindBy(name = "q")
    public WebElement searchBox;



}
