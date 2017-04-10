package atsdsi.framework.pages;

/**
 * Created by Sergii Rudenko on 10.04.2017.
 */
import atsdsi.framework.elements.Element;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.DefaultFieldDecorator;
import org.openqa.selenium.support.pagefactory.ElementLocator;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;

public class LoginPage extends Page {
    //Page elements
    @FindBy(how = How.TAG_NAME, using = "title")
    @CacheLookup
    public WebElement header;
    @FindBy(how = How.CLASS_NAME, using = "pic")
    public WebElement loginPic;
    @FindBy(how = How.ID, using = "email")
    public WebElement inputEmail;
    @FindBy(how = How.ID, using = "password")
    public WebElement inputPassword;
    @FindBy(how = How.ID, using = "btn-submit")
    public WebElement buttonLogin;
    @FindBy(how = How.ID, using = "forgot-password")
    public WebElement linkForgotPass;






    //Constructor
    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    // @Override
    public void init(final WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    //Page methods
    //Print title to console
    public String headerText() {
        return driver.getTitle();
    }


}

