package atsdsi.framework.tests;
import atsdsi.framework.MgfTestBase;
import atsdsi.framework.pages.FaqPage;
import atsdsi.framework.pages.LoginPage;
import atsdsi.framework.pages.ReviewsPage;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Title;

import atsdsi.framework.util.CustomLogger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.*;
import static org.junit.Assert.assertTrue;

public class GUI_001_NotLoggedPagesTest extends MgfTestBase {

    private LoginPage loginpage;
    private FaqPage faqpage;
    private ReviewsPage reviewspage;


    @Before
    @Title("Login functionality tests")
    public void initPageObjects() {
        loginpage = PageFactory.initElements(driver, LoginPage.class);
        faqpage = PageFactory.initElements(driver, FaqPage.class);
        reviewspage = PageFactory.initElements(driver, ReviewsPage.class);
    }
    @Title("Login page elements test")
    @Test
    public void testLoginPageElements() {
        driver.get(baseUrl);
        //System.out.print("Size of login picture is " +loginpage.linkFooterContactUs.getText()+ "\n");
        //----------------------------------------------LOGIN PAGE------------------------------------------------------
        //----------------------------------------------Login hold------------------------------------------------------
        /*
        Verify(checkElementSize(loginpage.loginPic,"(460, 177)"),1,"Check login image size");
        Verify(checkAttributeValue(loginpage.loginPic,"src","https://mygirlfund.com/assets/ctx/fc12d7b/images3/login-pic.jpg"),
                2,"Check login image source");
        Verify(checkAttributeValue(loginpage.inputEmail,"placeholder","name@example.com"),3,"Check email presents and placeholder");
        Verify(checkAttributeValue(loginpage.inputPassword,"placeholder","password"),4,"Check password presents and placeholder");
        Verify(checkAttributeValue(loginpage.buttonLogin,"value","LOG IN"),5,"Check LOG IN button");
        Verify(checkLinkNavigationAndBack(loginpage.linkForgotPass,"MyGirlFund: Forgot Password"),6,"Check forgot password link");
        //----------------------------------------------Header navigagation---------------------------------------------
        Verify(checkElementText(loginpage.buttonHeaderFAQ, "FAQ")&&
               checkElementText(loginpage.buttonHeaderReviews,"Reviews")&&
               checkElementText(loginpage.buttonHeaderAbout,"About")&&
               checkElementText(loginpage.buttonHeaderPreview,"Preview")&&
               checkElementText(loginpage.buttonHeaderSignUp, "SIGN UP"),7,"Check header buttons text");
        Verify(checkLinkNavigationAndBack(loginpage.buttonHeaderFAQ,"Chat with Sexy Girls Today | mygirlfund FAQ")&&
               checkLinkNavigationAndBack(loginpage.buttonHeaderReviews,"Reviews of mygirlfund")&&
               checkLinkNavigationAndBack(loginpage.buttonHeaderAbout,"Join MyGirlFund|Chat, Flirt and Cam with Girls Online")&&
               checkLinkNavigationAndBack(loginpage.buttonHeaderPreview,"Private Sex Chat | Meet Girls You Won't Find Elsewhere")&&
               checkLinkNavigationAndBack(loginpage.buttonHeaderSignUp,"MyGirlFund: Sign Up"),
               8,"Check header navigation and buttons for not logged user");
        //----------------------------------------------Footer navigagation---------------------------------------------
        Verify(checkLinkNavigationAndBack(loginpage.linkFooterTerms, "MyGirlFund: Terms Of Service")&&
                checkLinkNavigationAndBack(loginpage.linkFooterPrivacyPolicy,"MyGirlFund: Privacy Policy")&&
                checkLinkNavigationAndBack(loginpage.linkFooter2257,"MyGirlFund: Compliance")&&
                checkLinkNavigationAndBack(loginpage.linkFooterDMCA,"MyGirlFund: DMCA Notice & Takedown Policy")
                //checkLinkNavigationAndBack(loginpage.linkFooterBlog, "...")&&
                //checkLinkNavigationAndBack(loginpage.linkFooterHelp, "...")&&
                //checkLinkNavigationAndBack(loginpage.linkFooterContactUs, "...")
                ,9,"Check footer navigation and links for not logged user");
                */
        //----------------------------------------------FAQ PAGE--------------------------------------------------------
        clickElement(loginpage.buttonHeaderFAQ);
        clickElement(faqpage.linkGirlsTab);
        Verify(faqpage.h1.getText(),"Girls FAQ",10,"Check FAQ page - Girls FAQ tab");
        clickElement(faqpage.linkGuysTab);
        Verify(faqpage.h1.getText(),"Guys FAQ",11,"Check FAQ page - Guys FAQ tab");
        clickElement(faqpage.linkGeneralTab);
        Verify(faqpage.h1.getText(),"General FAQ",12,"Check FAQ page - General FAQ tab");
        clickElement(faqpage.linkFeaturesTab);
        Verify(faqpage.h1.getText(),"About mygirlfund – Social networking at its best!",13,"Check FAQ page - Fratures tab");
        //Add more veridy points here
        //..........
        //----------------------------------------------REVIEWS PAGE--------------------------------------------------------
        clickElement(faqpage.buttonHeaderReviews);
        Verify(isPresentAndDisplayed(reviewspage.filmRollPrev)&&
                isPresentAndDisplayed(reviewspage.filmRollNext)&&
                isPresentAndDisplayed(reviewspage.filmRoll),14,"Check Reviews page and film roll presents");
        clickElement(reviewspage.buttonHeaderAbout);





        System.out.print("Text is " +reviewspage.h1.getText());
    }





}

