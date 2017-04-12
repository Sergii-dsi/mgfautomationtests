package atsdsi.framework.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import org.openqa.selenium.support.PageFactory;
public class GirlPage extends Page {

    @FindBy(how = How.TAG_NAME, using = "title")
    @CacheLookup
    public WebElement title;

    //Header------------------------------------------------------------------------------------------------------------
    @FindBy(how = How.CLASS_NAME, using = "logo")
    public WebElement logo;

    //Main--------------------------------------------------------------------------------------------------------------

    @FindBy(how = How.ID, using = "page-title-girl")
    public WebElement h2Name;











    public GirlPage(WebDriver webDriver) {
        super(webDriver);
    }



    // @Override

    public void init(final WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    //Print title to console
    public String headerText() {
        return driver.getTitle();
    }


}
