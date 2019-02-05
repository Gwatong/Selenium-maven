import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.PluginsPage;

public class PluginsPageTest extends TestBase {

    LoginPage loginPage;
    HomePage homePage;
    PluginsPage pluginsPage;

    public PluginsPageTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        initialize();
        loginPage = new LoginPage();
        homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
        pluginsPage = homePage.goToPluginsPage();
    }
    @Test
    public void pluginsPageTitleTest() {
        String title = pluginsPage.getPluginsPageTitle();
        Assert.assertEquals(title, "Plugins ‹ Wordpress Demo Site at Demo.Center — WordPress");
    }


    @AfterMethod
    public void tearDown() {
        driver.close();
        driver.quit();
    }
}
