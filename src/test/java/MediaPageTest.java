import base.TestBase;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.MediaPage;

public class MediaPageTest extends TestBase {

    LoginPage loginPage;
    HomePage homePage;
    MediaPage mediaPage;

    public MediaPageTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        initialize();
        loginPage = new LoginPage();
        homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
        mediaPage = homePage.goToMediaPage();
    }

    @Test
    public void mediaPageTitleTest() {
        String title = mediaPage.getMediaPageTitle();
        Assert.assertEquals(title, "Media Library ‹ Wordpress Demo Site at Demo.Center — WordPress");
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        afterTestLogResult(result);
        driver.close();
        driver.quit();
    }
}
