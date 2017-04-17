package atsdsi.framework;

import atsdsi.framework.tests.FUNC_001_LoginTest;
import atsdsi.framework.tests.GUI_001_NotLoggedPagesTest;
import org.junit.Rule;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import ru.stqa.selenium.factory.WebDriverPool;

@RunWith(Suite.class)
@SuiteClasses({FUNC_001_LoginTest.class})
public class TestSuite {

  @Rule
  public TestRule webDriverPool = new TestWatcher() {
    @Override
    protected void finished(Description description) {
      super.finished(description);
      WebDriverPool.DEFAULT.dismissAll();
      
    };
  };
}
