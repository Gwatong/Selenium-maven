import base.TestBase;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.YoutubePage;

public class YoutubePageTest extends TestBase {

    LoginPage loginPage;
    HomePage homePage;
    YoutubePage youtubePage;

    public YoutubePageTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        initialize();
        loginPage = new LoginPage();
        homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
        youtubePage = homePage.goToYoutubePage();
    }

    @Test
    public void youtubePageTitleTest() {
        String title = youtubePage.getYoutubePageTitle();
        Assert.assertEquals(title, "YouTube Embed Profiles ‹ Wordpress Demo Site at Demo.Center — WordPress");
    }


    @AfterMethod
    public void tearDown(ITestResult result) {
        afterTestLogResult(result);
        driver.close();
        driver.quit();
    }
}
