package atsdsi.framework.tests;
import atsdsi.framework.TestBase;
import atsdsi.framework.pages.*;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Title;
import java.util.List;

/*------------------------------------------------------------------------------------------------------*/
/*Test performs verification for all available login functionality.*/
/*------------------------------------------------------------------------------------------------------*/


public class FUNC_001_Login extends TestBase {

    private LoginPage loginpage;
    private FaqPage faqpage;
    private ReviewsPage reviewspage;
    private AboutPage aboutpage;
    private GirlPage girlpage;
    private PreviewPage previewpage;


    @Before
    @Title("MGF Login functionality")
    public void initPageObjects() {
        loginpage = PageFactory.initElements(driver, LoginPage.class);
        faqpage = PageFactory.initElements(driver, FaqPage.class);
        reviewspage = PageFactory.initElements(driver, ReviewsPage.class);
        aboutpage = PageFactory.initElements(driver, AboutPage.class);
        girlpage = PageFactory.initElements(driver, GirlPage.class);
        previewpage = PageFactory.initElements(driver, PreviewPage.class);
    }

    @Title("Positive scenario login test")
    @Test
    public void testPositiveLoginFunctionality1() {
        String titleLoginPage = "Chat with Girls | Talk to Sexy Girls at mygirlfund";
        String titleSignUpPage = "MyGirlFund: Sign Up";

        driver.get(baseUrl);
    }

    @Title("Negative scenario login test")
    @Test
    public void testNegativeLoginFunctionality() {
        String titleLoginPage = "Chat with Girls | Talk to Sexy Girls at mygirlfund";
        String titleSignUpPage = "MyGirlFund: Sign Up";

        driver.get(baseUrl);
    }

    @Title("Forgot password login test")
    @Test
    public void testForgotPasswordFunctionality() {
        String titleLoginPage = "Chat with Girls | Talk to Sexy Girls at mygirlfund";
        String titleSignUpPage = "MyGirlFund: Sign Up";

        driver.get(baseUrl);
    }

    @Title("Range of values verification test")
    @Test
    public void testLoginFeaturesRangeOfValues() {
        String titleLoginPage = "Chat with Girls | Talk to Sexy Girls at mygirlfund";
        String titleSignUpPage = "MyGirlFund: Sign Up";

        driver.get(baseUrl);
    }

}