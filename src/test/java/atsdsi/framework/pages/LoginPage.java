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
    //Main--------------------------------------------------------------------------------------------------------------
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
    //Header------------------------------------------------------------------------------------------------------------
    @FindBy(how = How.XPATH, using = "//li[@id='login-btn-2']/a")
    public WebElement buttonHeaderFAQ;
    @FindBy(how = How.XPATH, using = "//li[@id='login-btn-5']/a")
    public WebElement buttonHeaderReviews;
    @FindBy(how = How.XPATH, using = "//li[@id='login-btn-3']/a")
    public WebElement buttonHeaderAbout;
    @FindBy(how = How.XPATH, using = "//li[@id='login-btn-4']/a")
    public WebElement buttonHeaderPreview;
    @FindBy(how = How.XPATH, using = "//li[@id='login-btn-1']/a")
    public WebElement buttonHeaderSignUp;
    ///Footer-----------------------------------------------------------------------------------------------------------
    @FindBy(how = How.XPATH, using = "//div[@id='footer-links']//li[1]/a")
    public WebElement linkFooterTerms;
    @FindBy(how = How.XPATH, using = "//div[@id='footer-links']//li[2]/a")
    public WebElement linkFooterPrivacyPolicy;
    @FindBy(how = How.XPATH, using = "//div[@id='footer-links']//li[3]/a")
    public WebElement linkFooter2257;
    @FindBy(how = How.XPATH, using = "//div[@id='footer-links']//li[4]/a")
    public WebElement linkFooterDMCA;
    @FindBy(how = How.XPATH, using = "//div[@id='footer-links']//li[5]/a")
    public WebElement linkFooterBlog;
    @FindBy(how = How.XPATH, using = "//div[@id='footer-links']//li[6]/a")
    public WebElement linkFooterHelp;
    @FindBy(how = How.XPATH, using = "//div[@id='footer-links']//li[7]/a")
    public WebElement linkFooterContactUs;








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

