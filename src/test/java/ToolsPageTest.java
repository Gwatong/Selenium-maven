import base.TestBase;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.ToolsPage;

import java.net.MalformedURLException;

public class ToolsPageTest extends TestBase {

    LoginPage loginPage;
    HomePage homePage;
    ToolsPage toolsPage;

    public ToolsPageTest() {
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
        toolsPage = homePage.goToToolsPage();
    }

    @Test
    public void toolsPageTitleTest() {
        String title = toolsPage.getToolsPageTitle();
        Assert.assertEquals(title, "Tools ‹ Wordpress Demo Site at Demo.Center — WordPress");
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        afterTestLogResult(result);
        driver.close();
        driver.quit();
    }
}
