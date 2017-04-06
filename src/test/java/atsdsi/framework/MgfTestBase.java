package atsdsi.framework;

import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.rules.ExternalResource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.DesiredCapabilities;
import ru.stqa.selenium.factory.WebDriverPool;


import atsdsi.framework.util.PropertyLoader;

/**
 * Base class for all the JUnit-based test classes
 */
public class MgfTestBase {

  protected static String gridHubUrl;
  protected static String baseUrl;
  protected static Capabilities capabilities;

  protected WebDriver driver;

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

  @Rule
  public ExternalResource webDriver = new ExternalResource() {
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


        }
        else
        {
            System.out.print(capabilities.getBrowserName());
            driver = WebDriverPool.DEFAULT.getDriver(capabilities);
        }

    };
  };




}
