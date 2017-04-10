package atsdsi.framework.tests;

import atsdsi.framework.MgfTestBase;

import atsdsi.framework.pages.LoginPage;
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

public class LoginTest extends MgfTestBase {

    private LoginPage loginpage;


    @Before
    @Title("Login functionality tests")
    public void initPageObjects() {
        loginpage = PageFactory.initElements(driver, LoginPage.class);
    }
    @Title("Login page elements test")
    @Test
    public void testLoginPageElements() {
        driver.get(baseUrl);
        System.out.print("Size of login picture is " +loginpage.loginPic.getSize());
        System.out.print("Size of login picture is " +loginpage.loginPic.getAttribute("src"));
        System.out.print("Size of login picture is " +loginpage.linkForgotPass.getAttribute("href"));

        Verify(checkImageSize(loginpage.loginPic,"(460, 177)"),1,"Check login image size");
        Verify(checkAttributeValue(loginpage.loginPic,"src","https://mygirlfund.com/assets/ctx/fc12d7b/images3/login-pic.jpg"),
                2,"Check login image source");
        Verify(checkAttributeValue(loginpage.inputEmail,"placeholder","name@example.com"),3,"Check email presents and placeholder");
        Verify(checkAttributeValue(loginpage.inputPassword,"placeholder","password"),4,"Check password presents and placeholder");
        Verify(checkAttributeValue(loginpage.buttonLogin,"value","LOG IN"),5,"Check LOG IN button");
        Verify(checkAttributeValue(loginpage.linkForgotPass,"href","https://mygirlfund.com/forgotpassword")&&
                checkElementText(loginpage.linkForgotPass,"Forgot Password?"),6,"Check forgot password link");




    }






}

