package atsdsi.framework.pages;

import atsdsi.framework.elements.Element;
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


/**
 * Sample page
 */
public class HomePage extends Page {

  @FindBy(how = How.TAG_NAME, using = "title")
  @CacheLookup
  public WebElement header;


  public HomePage(WebDriver webDriver) {
    super(webDriver);
  }

  //Print title to console
  public void printOut() {
    System.out.print(header.getText());
  }


 // @Override
  /*
  Как это работает?! В методе init() мы вызываем PageFactory.initElements(driver, this);.
   Драйвер не начинает искать элементы на странице сразу же, а ищет их как только мы обращаемся к полю класса.
    Например строка searchButton.click(); «превращается» в driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
   */
 public void init(final WebDriver driver) {
   PageFactory.initElements(driver, this);
 }
}
