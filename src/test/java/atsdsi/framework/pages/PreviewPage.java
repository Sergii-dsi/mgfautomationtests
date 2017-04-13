package atsdsi.framework.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;

import java.util.List;


public class PreviewPage extends Page {

    @FindBy(how = How.TAG_NAME, using = "title")
    @CacheLookup
    public WebElement title;

    //Header------------------------------------------------------------------------------------------------------------
    @FindBy(how = How.XPATH, using = "//div[@id='logo']/a/img")//not clickable by ID
    public WebElement logo;
    @FindBy(how = How.ID, using = "btn-1i")
    public WebElement buttonHome;
    @FindBy(how = How.ID, using = "btn-2i")
    public WebElement buttonTheGirls;
    @FindBy(how = How.ID, using = "btn-3i")
    public WebElement buttonFriends;
    @FindBy(how = How.ID, using = "btn-4ii")
    public WebElement buttonAccount;
    @FindBy(how = How.ID, using = "btn-5i")
    public WebElement buttonContests;
    @FindBy(how = How.ID, using = "btn-6i")
    public WebElement buttonInbox;
    @FindBy(how = How.ID, using = "btn-7i")
    public WebElement buttonPrivateFiles;
    @FindBy(how = How.ID, using = "btn-8i")
    public WebElement buttonBlogs;
    @FindBy(how = How.ID, using = "login-btn-1")
    public WebElement buttonSignup;
    @FindBy(how = How.XPATH, using = "//ul[@id='interior-sub-nav']/li[2]/a")
    public WebElement buttonNewGirls;
    @FindBy(how = How.XPATH, using = "//ul[@id='interior-sub-nav']/li[3]/a")
    public WebElement buttonFavorites;
    @FindBy(how = How.XPATH, using = "//ul[@id='interior-sub-nav']/li[4]/a")
    public WebElement buttonOncam;
    @FindBy(how = How.XPATH, using = "//ul[@id='interior-sub-nav']/li[5]/a")
    public WebElement buttonTags;
    @FindBy(how = How.XPATH, using = "//ul[@id='interior-sub-nav']/li[6]/a")
    public WebElement buttonSearch;
    @FindAll(
            {@FindBy(how = How.XPATH, using = "//div[@id='nav-interior']/ul/li[starts-with(@id, 'btn-')]")} //EXAMPLE: dropDown.findElements(By.xpath(".//option"));
    )
    public List<WebElement> listHeaderButtons;
    @FindAll(
            {@FindBy(how = How.XPATH, using = "//div[@id='gallery']/ul[@class='gallery-list']//a")}
    )
    public List<WebElement> listGirlsLinks;
    @FindAll(
            {@FindBy(how = How.XPATH, using = "//div[@id='paging']/a")}
    )
    public List<WebElement> listPaging;









    //Main--------------------------------------------------------------------------------------------------------------
    @FindBy(how = How.XPATH, using = "//div[@id='main']/h1")
    public WebElement h1;
    @FindBy(how = How.LINK_TEXT, using = "Girls")
    public WebElement linkGirlsTab;
    @FindBy(how = How.ID, using = "film_roll")
    public WebElement filmRoll;
    @FindBy(how = How.CLASS_NAME, using = "film_roll_prev")
    public WebElement filmRollPrev;
    @FindBy(how = How.CLASS_NAME, using = "film_roll_next")
    public WebElement filmRollNext;





    public PreviewPage(WebDriver webDriver) {
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
