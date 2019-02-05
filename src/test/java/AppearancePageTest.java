import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AppearancePage;
import pages.HomePage;
import pages.LoginPage;

public class AppearancePageTest extends TestBase {

    LoginPage loginPage;
    HomePage homePage;
    AppearancePage appearancePage;

    public AppearancePageTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        initialize();
        loginPage = new LoginPage();
        homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
        appearancePage = homePage.goToAppearancePage();
    }

    @Test
    public void AppearancePageTitleTest() {
        String title = appearancePage.getAppearancePageTitle();
        Assert.assertEquals(title, "Manage Themes ‹ Wordpress Demo Site at Demo.Center — WordPress");
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
        driver.quit();
    }
}
