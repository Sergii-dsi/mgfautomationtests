package atsdsi.framework;

import atsdsi.framework.util.CustomLogger;
import org.junit.Assert;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.rules.ExternalResource;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import ru.stqa.selenium.factory.WebDriverPool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import atsdsi.framework.util.PropertyLoader;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.ArrayList;
import java.util.List;

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
  ///-----------------------------------------------------------------------------------------------------------------
  protected static final Logger log = LoggerFactory.getLogger(CustomLogger.class);

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
    protected void Verify(String expected, String actual, int stepNumber, String message) {
        boolean value = expected.equals(actual);

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

        List<WebElement> myElements = driver.findElements(by);
        return myElements;
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
    protected boolean checkImageSize(WebElement image, String size) {
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
        return element.getText().equals(value);

    }


}
