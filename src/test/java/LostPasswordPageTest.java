import base.TestBase;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.LostPasswordPage;

import java.net.MalformedURLException;

public class LostPasswordPageTest extends TestBase {

    LoginPage loginPage;
    LostPasswordPage lostPasswordPage;

    public LostPasswordPageTest(){
        super();
    }

    @BeforeMethod
    public void setUp(){
        try {
            initialize();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        loginPage = new LoginPage();
        lostPasswordPage = loginPage.goToLostPasswordPage();
    }

    @Test
    public void lostPasswordPageTitleTest(){
        Assert.assertEquals(lostPasswordPage.getLostPasswordPageTitle(), "Lost Password ‹ Wordpress Demo Site at Demo.Center — WordPress");
    }

    @Test
    public void lostPasswordPageMessageTest(){
        Assert.assertEquals(lostPasswordPage.getMessage(), "Please enter your username or email address. You will receive a link to create a new password via email.");
    }

    @Test
    public void lostPasswordPageBackToLoginPageTest(){
        loginPage = lostPasswordPage.goToLoginPage();
        Assert.assertEquals(loginPage.getLoginPageTitle(), "Log In ‹ Wordpress Demo Site at Demo.Center — WordPress" );
    }

    @Test
    public void lostPasswordPageMessageWhileTypingInvalidUsernameTest(){
        String errorMessage = lostPasswordPage.getErrorForInvalidUsernameForPasswordRecovery();
        Assert.assertEquals(errorMessage,"ERROR: Invalid username or email." );
    }

    @Test
    public void loginPageMessageWhileTypingValidUsername(){
        loginPage = lostPasswordPage.passwordRecoveryWithValidUsername(prop.getProperty("username"));
        String message = loginPage.getSuccessPasswordRecoveryMessage();
        Assert.assertEquals(message, "Check your email for the confirmation link.");
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        afterTestLogResult(result);
        driver.close();
        driver.quit();
    }
}
