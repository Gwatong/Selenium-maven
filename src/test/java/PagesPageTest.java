import base.TestBase;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.PagesPage;

import java.net.MalformedURLException;

public class PagesPageTest extends TestBase {

    LoginPage loginPage;
    HomePage homePage;
    PagesPage pagesPage;

    public PagesPageTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        try {
            initialize();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        loginPage = new LoginPage();
        homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
        pagesPage = homePage.goToPagesPage();
    }

    @Test
    public void pagesPageTitleTest() {
        String title = pagesPage.getPagesPageTitle();
        Assert.assertEquals(title, "Pages ‹ Wordpress Demo Site at Demo.Center — WordPress");
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        afterTestLogResult(result);
        driver.close();
        driver.quit();
    }
}
