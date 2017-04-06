package atsdsi.framework;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;
import atsdsi.framework.pages.HomePage;
import java.util.logging.Logger;

public class SampleMgfTest extends MgfTestBase {

  private HomePage homepage;
  private static Logger log = Logger.getLogger(SampleMgfTest.class.getName());

  @Before
  public void initPageObjects() {
    homepage = PageFactory.initElements(driver, HomePage.class);
  }

  @Test
  public void testHomePageHasAHeader() {
    driver.get(baseUrl);
    Assert.assertEquals("Chat with Girls | Talk to Sexy Girls at mygirlfund", homepage.headerText());
    System.out.print(homepage.headerText());
      System.out.print(homepage.getTitle());
    log.info("Some message");

  }






}
