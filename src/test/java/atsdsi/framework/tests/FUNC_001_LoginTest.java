package atsdsi.framework.tests;
import atsdsi.framework.TestBase;
import atsdsi.framework.pages.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Title;



/*------------------------------------------------------------------------------------------------------*/
/*Test performs verification for all available login functionality.*/
/*------------------------------------------------------------------------------------------------------*/


public class FUNC_001_LoginTest extends TestBase {


//    private FaqPage faqpage;
//    private ReviewsPage reviewspage;
//    private AboutPage aboutpage;
    private GirlPage girlpage;
//    private PreviewPage previewpage;
    private GuyPage guypage ;
    //private LoginPage loginpage;





  @Before
    @Title("MGF Login functionality")
    public void initPageObjects() {

        //faqpage = PageFactory.initElements(driver, FaqPage.class);
        //reviewspage = PageFactory.initElements(driver, ReviewsPage.class);
        //aboutpage = PageFactory.initElements(driver, AboutPage.class);
        girlpage = PageFactory.initElements(driver, GirlPage.class);
        //previewpage = PageFactory.initElements(driver, PreviewPage.class);
        guypage = PageFactory.initElements(driver, GuyPage.class);
        //loginpage = PageFactory.initElements(driver, LoginPage.class);

    }


    @Title("Positive scenario login test")
    @Test
    public void testPositiveLoginFunctionality() {

       //--------------------------------------Login with defined credentials------------------------------------------
        driver.get(baseUrl);
        LoginGuy();
        WaitIsDisplayed(guypage.h2Name);

        Verify(guypage.h2Name.getText(),guyNickname,1,"Guy account login test");

        Logout();
        LoginGirl();
        Verify(girlpage.h2Name.getText(),girlNickname,2,"Girl account login test");
        Logout();
        Verify(driver.getCurrentUrl(),baseUrl+"login",3,"Double login\\logout action");

    }
    @After
    public void tearDown() {
        driver.quit();
    }





    @Title("Negative scenario login test")
    @Test
    public void testNegativeLoginFunctionality() {
        String titleLoginPage = "Chat with Girls | Talk to Sexy Girls at mygirlfund";
        String titleSignUpPage = "MyGirlFund: Sign Up";
        String errorMessage;
        driver.get(baseUrl);
                errorMessage = "Invalid email/password combination";
                Login("noemail@wrong.we",guyPassword);
        Verify(getLoginErrorText(),errorMessage,1,"Email not exist login test");

    }
//
//    @Title("Forgot password login test")
//    @Test
//    public void testForgotPasswordFunctionality() {
//        String titleLoginPage = "Chat with Girls | Talk to Sexy Girls at mygirlfund";
//        String titleSignUpPage = "MyGirlFund: Sign Up";
//
//        driver.get(baseUrl);
//    }
//
//    @Title("Range of values verification test")
//    @Test
//    public void testLoginFeaturesRangeOfValues() {
//        String titleLoginPage = "Chat with Girls | Talk to Sexy Girls at mygirlfund";
//        String titleSignUpPage = "MyGirlFund: Sign Up";
//
//        driver.get(baseUrl);
//    }


}