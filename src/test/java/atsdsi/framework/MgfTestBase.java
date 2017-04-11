package atsdsi.framework;

import atsdsi.framework.util.CustomLogger;
import org.junit.Assert;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.rules.ExternalResource;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.stqa.selenium.factory.WebDriverPool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import atsdsi.framework.util.PropertyLoader;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;


/**
 * Base class for all the JUnit-based test classes
 */
public class MgfTestBase {

  protected static String gridHubUrl;
  protected static String baseUrl;
  protected static Capabilities capabilities;

  protected WebDriver driver;

  //Properties, main and grid
  @ClassRule
  public static ExternalResource webDriverProperties = new ExternalResource() {
    @Override
    protected void before() throws Throwable {
      baseUrl = PropertyLoader.loadProperty("site.url");
      gridHubUrl = PropertyLoader.loadProperty("grid2.hub");
      baseUrl = PropertyLoader.loadProperty("site.url");
      gridHubUrl = PropertyLoader.loadProperty("grid.url");
      if ("".equals(gridHubUrl)) {
        gridHubUrl = null;
      }
      capabilities = PropertyLoader.loadCapabilities();
    };
  };
  //Starting browser section
  @Rule
  public ExternalResource webDriver = new ExternalResource()
  {
    @Override
    protected void before() throws Throwable {
      //driver = WebDriverPool.DEFAULT.getDriver(gridHubUrl, capabilities);
        if ("chrome".equals(capabilities.getBrowserName()))
        {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("start-maximized");
            DesiredCapabilities chrome = DesiredCapabilities.chrome();
            chrome.setCapability(ChromeOptions.CAPABILITY, options);
            driver = WebDriverPool.DEFAULT.getDriver(chrome);
            //driver = WebDriverPool.DEFAULT.getDriver(DesiredCapabilities.internetExplorer());

        }
        else
        {
            System.out.print(capabilities.getBrowserName());
            driver = WebDriverPool.DEFAULT.getDriver(capabilities);
        }


    };
  };
  ///----------------------------------------------Waiters--------------------------------------------------------------
  protected static final Logger log = LoggerFactory.getLogger(CustomLogger.class);

  //Custom waiter. NOT RECOMMENDED TO USE for events waits
  protected void WaitFor(long timeoutInSeconds){
      driver.manage().timeouts().implicitlyWait(timeoutInSeconds, TimeUnit.SECONDS);
  }
  //Set timeout value and waite with step in second until element is displayed.
  protected void WaitIsDisplayed(WebElement element,long timeoutInSeconds)  {
      for(int i=0;i==timeoutInSeconds;i++) {
          try{
              if (element.isDisplayed())
                  return;
             }
             catch (NoSuchElementException e)
             {
                 WaitFor(1);
             }
      }
      element.isDisplayed();
  }
    //Wait for specified title
    protected void WaitForTitle(String pageTitle,long timeoutInSeconds){
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.until(ExpectedConditions.titleIs(pageTitle));
    }




    ///----------------------------------------------Verify section-----------------------------------------------------
    /// <summary>
    /// Performs verification and updates totalStatus field. If the value is
    /// true this method will write to the log "PASS";
    /// otherwise, "FAIL".
    @Step("{2}")
    protected void Verify(boolean value, int stepNumber, String message)
    {
        if (stepNumber == -1) CustomLogger.TraceVerification(value, message );
        else CustomLogger.TraceVerification(value, stepNumber, message);
                   Assert.assertTrue(value);



    }
    @Step("{3}")
    protected void Verify(String actual, String expected, int stepNumber, String message) {
        boolean value = actual.equals(expected);

        if (stepNumber == -1) CustomLogger.TraceVerification(value, message );
        else CustomLogger.TraceVerification(value, stepNumber, message);
        //try
        //{
        Assert.assertTrue(value);
        //}
        // catch (Exception e){};

        //Saving screenshot section
        //.....


    }

    @Step("{1}")
    protected void Verify(Boolean value, String message){
        Verify(value, -1, message);
    }

    ///<summary>
    /// Get all webelements with the same attribute to list
    protected List<WebElement> getElementsList(By by){

        return driver.findElements(by);
    }

    ///<summary>
    /// Get text List from webelements with the same attribute
    protected List<String> getElementsText(By by){
        List<String> currentOptions = new ArrayList<>();
        List<WebElement> matches = driver.findElements(by);

        // Traverse the web elements to extrat the text. Text gets added to the 'currentOptions' List
        for (WebElement match : matches) {
            currentOptions.add(match.getText());
        }
        return  currentOptions;
    }



    //---------------------------------------------Checkers-------------------------------------------------------------
///<summary>
    /// Return true if element displayed
    public static boolean isPresentAndDisplayed(final WebElement element) {
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
    ///<summary>
    /// Determines whether an element with the specified attribute value is
    /// displayed.
     protected boolean isElementPresent(By by) {
        try
        {
            driver.findElement(by);
            return true;
        }
        catch (NoSuchElementException e)
        {
            return false;
        }

    }
    //Use just string by default for ID
    protected boolean isElementPresent(String elementId) {
        try
        {
            driver.findElement(By.id(elementId));
            return true;
        }
        catch (NoSuchElementException e)
        {
            return false;
        }
    }

    //Reload for xpath locators
    protected boolean isElementPresentXpath(String xpathString) {
        try
        {
            driver.findElement(By.xpath(xpathString));
            return true;
        }
        catch (NoSuchElementException e)
        {
            return false;
        }
    }

    // ///<summary>
    /// Determines whether an elements from the elements List are present
    protected boolean elementsPresent(By elementsList) {
        try
        {
            driver.findElements(elementsList);
            return true;
        }
        catch (NoSuchElementException e)
        {
            return false;
        }
    }

    ///<summary>
    /// Check pixel size of presented image. Size format "(x, y)"
    protected boolean checkElementSize(WebElement image, String size) {
        return image.getSize().toString().equals(size);
    }

    ///<summary>
    /// Check string value of html element attribute.
    protected boolean checkAttributeValue(WebElement element,String attribute, String value) {
        return element.getAttribute(attribute).equals(value);
    }

    ///<summary>
    /// Check text value of html element.
    protected boolean checkElementText(WebElement element, String value) {
        WaitIsDisplayed(element, 5);
        return element.getText().equals(value);


    }

    ///<summary>
    ///Click link and compare expected title then nav back //NOT TESTED
    protected boolean checkLinkNavigationAndBack(WebElement element, String expectedTitle) {
        element.click();
        try{
            WaitForTitle(expectedTitle,5);
            driver.navigate().back();
            return true;
        }
        catch (Exception e)
        {
            CustomLogger.TraceVerification(false,e.toString());
            driver.navigate().back();
            return false;
        }
    }

    //---------------------------------------------Element tools--------------------------------------------------------
    ///<summary>
    /// Click element when it to be clickable. Set waiter timeout in seconds
    protected void clickElement(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }
    ///<summary>
    /// Click element when it present. Set waiter timeout in seconds
    protected void clickElementWhenPresent(WebElement element, int timeoutInSeconds){
        WaitIsDisplayed(element,timeoutInSeconds);
        clickElement(element);
    }

    /*
      Waits for an element to appear on the page before returning. Example:
      WebElement waitElement =
      fluentWait(By.cssSelector(div[class='someClass']));
    */
    //NOT TESTED!!!!!!!!!!!!!!!!!!!!!!!!
    protected WebElement waitForElementToAppear(final By locator)
    {
        Wait<WebDriver> wait = new FluentWait<>(driver).
                withTimeout(30, TimeUnit.SECONDS).pollingEvery(5, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);

        WebElement element = null;
        try {
            element = wait.until(driver -> driver.findElement(locator));
        }
        catch (TimeoutException e) {
            try {
                // I want the error message on what element was not found
                driver.findElement(locator);
            }
            catch (NoSuchElementException renamedErrorOutput) {
                // print that error message
                renamedErrorOutput.addSuppressed(e);
                // throw new
                // NoSuchElementException("Timeout reached when waiting for element to be found!"
                // + e.getMessage(), correctErrorOutput);
                throw renamedErrorOutput;
            }
            e.addSuppressed(e);
            throw new NoSuchElementException("Timeout reached when searching for element!", e);
        }

        return element;
    }


}
