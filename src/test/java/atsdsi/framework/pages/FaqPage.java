package atsdsi.framework.pages;

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



public class FaqPage extends Page {

  @FindBy(how = How.TAG_NAME, using = "title")
  @CacheLookup
  public WebElement title;

    //Header------------------------------------------------------------------------------------------------------------
    @FindBy(how = How.XPATH, using = "//li[@id='btn-1']/a")
    public WebElement buttonHeaderHome;
    @FindBy(how = How.XPATH, using = "//li[@id='btn-7']/a")
    public WebElement buttonHeaderReviews;
    //Main--------------------------------------------------------------------------------------------------------------
    @FindBy(how = How.XPATH, using = "//div[@id='content-terms']/h1")
    public WebElement h1;
    @FindBy(how = How.LINK_TEXT, using = "Girls")
    public WebElement linkGirlsTab;
    @FindBy(how = How.LINK_TEXT, using = "Guys")
    public WebElement linkGuysTab;
    @FindBy(how = How.LINK_TEXT, using = "Features")
    public WebElement linkFeaturesTab;
    @FindBy(how = How.LINK_TEXT, using = "General")
    public WebElement linkGeneralTab;

  public FaqPage(WebDriver webDriver) {
    super(webDriver);
  }



 // @Override
  /*
   В методе init() мы вызываем PageFactory.initElements(driver, this);.
   Драйвер не начинает искать элементы на странице сразу же, а ищет их как только мы обращаемся к полю класса.
    Например строка searchButton.click(); «превращается» в driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
   */
 public void init(final WebDriver driver) {
   PageFactory.initElements(driver, this);
 }

    //Print title to console
    public String headerText() {
        return driver.getTitle();
    }


}
