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
/*Test performs verification for all available web elements, pages and access level for not logged user.*/
/*------------------------------------------------------------------------------------------------------*/


public class GUI_001_NotLoggedPagesTest extends TestBase {

    private LoginPage loginpage;
    private FaqPage faqpage;
    private ReviewsPage reviewspage;
    private AboutPage aboutpage;
    private GirlPage girlpage;
    private PreviewPage previewpage;


    @Before
    @Title("GUI tests for Not Logged User ")
    public void initPageObjects() {
        loginpage = PageFactory.initElements(driver, LoginPage.class);
        faqpage = PageFactory.initElements(driver, FaqPage.class);
        reviewspage = PageFactory.initElements(driver, ReviewsPage.class);
        aboutpage = PageFactory.initElements(driver, AboutPage.class);
        girlpage = PageFactory.initElements(driver, GirlPage.class);
        previewpage = PageFactory.initElements(driver, PreviewPage.class);
    }
    @Title("Pages elements test")
    @Test
    public void testLoginPageElements() {
        String titleLoginPage = "Chat with Girls | Talk to Sexy Girls at mygirlfund";
        String titleSignUpPage = "MyGirlFund: Sign Up";

        driver.get(baseUrl);
        //----------------------------------------------LOGIN PAGE------------------------------------------------------
        //----------------------------------------------Login hold------------------------------------------------------

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
               checkLinkNavigationAndBack(loginpage.buttonHeaderSignUp,titleSignUpPage),
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

        //----------------------------------------------FAQ PAGE--------------------------------------------------------
        clickElement(loginpage.buttonHeaderFAQ);
        clickElement(faqpage.linkGirlsTab);
        Verify(faqpage.h1.getText(),"Girls FAQ",10,"Check FAQ page - Girls FAQ tab");
        clickElement(faqpage.linkGuysTab);
        Verify(faqpage.h1.getText(),"Guys FAQ",11,"Check FAQ page - Guys FAQ tab");
        clickElement(faqpage.linkGeneralTab);
        Verify(faqpage.h1.getText(),"General FAQ",12,"Check FAQ page - General FAQ tab");
        clickElement(faqpage.linkFeaturesTab);
        System.out.print(faqpage.h1.getText());
        Verify(isPresentAndDisplayed(faqpage.subNavigation),13,"Check FAQ page - Fratures tab subnav is present");
        //Add more veridy points here
        //..........
        //----------------------------------------------REVIEWS PAGE----------------------------------------------------
        clickElement(faqpage.buttonHeaderReviews);
        Verify(isPresentAndDisplayed(reviewspage.filmRollPrev)&&
                isPresentAndDisplayed(reviewspage.filmRollNext)&&
                isPresentAndDisplayed(reviewspage.filmRoll),14,"Check Reviews page and film roll presents");

        //----------------------------------------------ABOUT PAGE------------------------------------------------------
        clickElement(reviewspage.buttonHeaderAbout);
        Verify(aboutpage.h1.getText(),"THE GIRL NEXT DOOR IS NOW ONLINE",15,"Check About page presents");
        Verify(isPresentAndDisplayed(aboutpage.videoFrame),16,"Check About page - video frame");
        Verify(checkLinkNavigationAndBack(aboutpage.buttonCreateMyFreeAccount1,titleSignUpPage)&&
                        checkLinkNavigationAndBack(aboutpage.buttonCreateMyFreeAccount2,titleSignUpPage),
                17,"Check About page - buttons Create Free Account");
        Verify(checkLinkNavigationAndBack(aboutpage.buttonConnect1on1,titleSignUpPage),
               18,"Check About page - button Connect One on One");
        Verify(checkLinkNavigationAndBack(aboutpage.buttonConnectWithVirtGF,titleSignUpPage),
              19,"Check About page - button Connect with a virtual girlfriend");
        Verify(checkAllGirlsListIsPresentOnAboutPage(),20,"Check About page - girls list");

        //----------------------------------------------PREVIEW PAGE----------------------------------------------------
        goTo("preview");
        Verify(checkLinkNavigationAndBack(previewpage.logo,"Chat with Girls | Talk to Sexy Girls at mygirlfund"),
                21,"Check Preview page - Logo link");
        Verify(checkLinkListNavigationAndBack(previewpage.listHeaderButtons,titleLoginPage),
                22,"Check Preview page - Header navigation access level");
        Verify(checkLinkNavigationAndBack(previewpage.buttonSignup,titleSignUpPage),
                23,"Check Preview page - Sign Up button");
        Verify(checkTheGirlsDropdownPrevievPage(),24,"Check Preview page - The Girls dropdown");
        Verify(checkGirlsPagesNavigation(previewpage.listGirlsLinks),25,"Check Preview page - Girls pages navigation");
        Verify(previewpage.listGirlsLinks.size(),30,26,"Check Preview page - Girls pages amount");
        Verify(checkLinkListNavigationAndBack(previewpage.listPaging,titleLoginPage),27,"Check Preview page - Paging navigacion and access lvl");
    }

    //---------------------------------------------Advanced tools-------------------------------------------------------

    protected boolean checkAllGirlsListIsPresentOnAboutPage( ){
        try{
            for (int i = 1; i < 9; i++)
            {
                mouseOverElement(driver.findElement(By.xpath("//ul[@class='girls-list']/li["+i+"]"))); //id[]
                //WaitFor(1/8); //Uncomment if crash here
                WebElement tempElement = driver.findElement(By.xpath("//ul[@class='girls-list']/li["+i+"]/a"));
                tempElement.isDisplayed();
            }
            return true;
        }
        catch (Exception e)
        {
            return false;
        }

    }
    //Perform test - all dropdown options links to login page
    protected boolean checkTheGirlsDropdownPrevievPage( ){
        try{

            for (int i = 1; i < 7; i++)
            {
                mouseOverElement(driver.findElement(By.xpath("//ul[@id='interior-sub-nav']/li[@class='girls-link']")));
                //WaitFor(1/8); //Uncomment if crash here
                WebElement tempElement = driver.findElement(By.xpath("//ul[@class='girls-drop']/li["+i+"]/a"));
                checkLinkNavigationAndBack(tempElement,"Chat with Girls | Talk to Sexy Girls at mygirlfund");//Login page

            }
            return true;
        }
        catch (Exception e)
        {
            return false;
        }

    }
    ////Perform test - all girls shapshots links to the accounts pages
    protected boolean checkGirlsPagesNavigation(List<WebElement> list ){
        try
        {
            String accountName;
            for(int i=0;i<6;i++){ //use i<list.size() for all
                WaitIsDisplayed(list.get(i));
                accountName = getAccountNameFromLink(list.get(i).getAttribute("href"));
                System.out.println(accountName);
                clickElementWhenPresent(list.get(i));
                WaitIsDisplayed(girlpage.h2Name);
                if (!girlpage.h2Name.getText().equals(accountName)){
                    System.out.println("Test failed");
                    return false;
                }
                System.out.println(i+1+ " account(s) link checked");
                driver.navigate().back();
            }

            return true;
        }
        catch (Exception e)
        {
            return false;
        }

    }

    protected String getAccountNameFromLink(String link){
        return link.replaceAll(baseUrl,"");
    }




}

