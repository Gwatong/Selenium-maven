import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class HomePageTest extends TestBase {

    LoginPage loginPage;
    HomePage homePage;

    public HomePageTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        initialize();
        loginPage = new LoginPage();
        homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
    }

    @Test
    public void homePageTitleTest() {
        String title = homePage.getHomePageTitle();
        Assert.assertEquals(title, "Dashboard ‹ Wordpress Demo Site at Demo.Center — WordPress");
    }

    @Test
    public void extendedMenuByDefaultTest() {
        Assert.assertTrue(homePage.verifyIfMenuIsExpanded());
    }

    @Test
    public void collapsedMenuAfterClickOnCollapseButtonTest() {
        homePage.collapseMenu();
        Assert.assertFalse(homePage.verifyIfMenuIsExpanded());
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
        driver.quit();
    }
}
