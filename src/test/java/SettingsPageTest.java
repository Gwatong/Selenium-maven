import base.TestBase;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.SettingsPage;

public class SettingsPageTest extends TestBase {

    LoginPage loginPage;
    HomePage homePage;
    SettingsPage settingsPage;

    public SettingsPageTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        initialize();
        loginPage = new LoginPage();
        homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
        settingsPage = homePage.goToSettingsPage();
    }

    @Test
    public void settingsPageTitleTest() {
        String title = settingsPage.getSettingsPageTitle();
        Assert.assertEquals(title, "General Settings ‹ Wordpress Demo Site at Demo.Center — WordPress");
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            logger.error(result.getName()+ " FAILED",result.getThrowable());

        }else if(result.getStatus() == ITestResult.SUCCESS){
            logger.info(result.getName()+ " PASSED");
        }else if(result.getStatus() == ITestResult.SKIP){
            logger.info(result.getName() + " SKIPPED");
        }

        driver.close();
        driver.quit();
    }
}
