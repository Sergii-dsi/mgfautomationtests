package atsdsi.framework.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import org.openqa.selenium.support.PageFactory;
public class GuyPage extends Page {

    @FindBy(how = How.TAG_NAME, using = "title")
    @CacheLookup
    public WebElement title;

    //Header------------------------------------------------------------------------------------------------------------
    @FindBy(how = How.CLASS_NAME, using = "logo")
    public WebElement logo;

    //Main--------------------------------------------------------------------------------------------------------------

    @FindBy(how = How.XPATH, using = "//div[@id='right-column']//h2")
    public WebElement h2Name;
    @FindBy(how = How.ID, using = "aboutme")
    public WebElement aboutme;













    public GuyPage(WebDriver webDriver) {
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
