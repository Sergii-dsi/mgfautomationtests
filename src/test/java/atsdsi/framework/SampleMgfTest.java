package atsdsi.framework;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import org.openqa.selenium.support.PageFactory;

import atsdsi.framework.pages.HomePage;

public class SampleMgfTest extends MgfTestBase {

  private HomePage homepage;

  @Before
  public void initPageObjects() {
    homepage = PageFactory.initElements(driver, HomePage.class);
  }

  @Test
  public void testHomePageHasAHeader() {
    driver.get(baseUrl);
    Assert.assertFalse("Chat with Girls | Talk to Sexy Girls at mygirlfund".equals(homepage.header.getText()));
  }
}
