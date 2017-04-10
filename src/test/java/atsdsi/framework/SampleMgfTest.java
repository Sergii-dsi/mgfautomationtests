package atsdsi.framework;

import atsdsi.framework.util.CustomLogger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;
import atsdsi.framework.pages.HomePage;
import ru.yandex.qatools.allure.annotations.*;


import static org.junit.Assert.assertTrue;

public class SampleMgfTest extends MgfTestBase {

  private HomePage homepage;


  @Before
  public void initPageObjects() {
    homepage = PageFactory.initElements(driver, HomePage.class);
  }
  @Title("First cool check3")
  @Test

  public void testHomePageHasAHeader() {
    driver.get(baseUrl);
    //Assert.assertEquals("Chat with Girls1 | Talk to Sexy Girls at mygirlfund", homepage.headerText());
    //Assert.assertEquals("Chat with Girls | Talk to Sexy Girls at mygirlfund", homepage.headerText());
    boolean value2 = 2 * 2 == 5;


    System.out.print(homepage.headerText());
      System.out.print(homepage.getTitle());
    log.info("Some message");
    Verify(2 * 2 == 4,2,"Calc verification test");
    Verify(value2,1,"Calc verification test");


  }






}
