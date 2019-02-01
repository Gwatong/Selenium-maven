import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginPageTest extends TestBase {
    LoginPage loginPage;
    HomePage homePage;


    public LoginPageTest(){
        super();
    }

    @BeforeMethod
    public void setUp(){
        initialize();
        loginPage = new LoginPage();
    }

    @Test(priority = 1)
    public void loginPageTitleTest(){
        String title = loginPage.validateLoginPageTitle();
        Assert.assertEquals(title, "Log In ‹ Wordpress Demo Site at Demo.Center — WordPress");
    }

    @Test(priority = 2)
    public void wordpressLogoImageTest(){
        boolean flag = loginPage.validateWordpressIMAGE();
        Assert.assertTrue(flag);
    }

    @Test(priority = 3)
    public void loginTest(){
        homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
