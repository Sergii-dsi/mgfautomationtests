package atsdsi.framework.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;

import java.util.List;

public class AboutPage extends Page {

    @FindBy(how = How.TAG_NAME, using = "title")
    @CacheLookup
    public WebElement title;

    //Header------------------------------------------------------------------------------------------------------------
    @FindBy(how = How.CLASS_NAME, using = "logo")
    public WebElement logo;

    //Main--------------------------------------------------------------------------------------------------------------
    @FindBy(how = How.XPATH, using = "//div[@class='top-box']/div[@class='hold']/h1")
    public WebElement h1;
    @FindBy(how = How.CLASS_NAME, using = "sproutvideo-player")
    public WebElement videoFrame;
    @FindBy(how = How.XPATH, using = "//div[@class='top-box']//a[@class='button']")
    public WebElement buttonCreateMyFreeAccount1;
    @FindBy(how = How.XPATH, using = "//div[@class='wide-block']//a[@class='button']")
    public WebElement buttonCreateMyFreeAccount2;
    @FindBy(how = How.XPATH, using = "//div[@class='girls-holder']/div[@class='hold']/a[@class='button']") //TODO: NEED ID
    public WebElement buttonConnect1on1;
    @FindBy(how = How.XPATH, using = "//div[@class='wide-block wide-block2']/div[@class='hold']/a[@class='button']") //TODO: NEED ID
    public WebElement buttonConnectWithVirtGF;

    @FindAll(
            {@FindBy(how = How.XPATH, using = "//body/div[@class='girls-holder']/div[@class='hold']/ul[@class='girls-list']//a")} //EXAMPLE: dropDown.findElements(By.xpath(".//option"));
    )
    public List<WebElement> girlsListLinks;
















    public AboutPage(WebDriver webDriver) {
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
