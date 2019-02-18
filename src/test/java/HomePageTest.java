import base.TestBase;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

import java.net.MalformedURLException;

public class HomePageTest extends TestBase {

    LoginPage loginPage;
    HomePage homePage;

    public HomePageTest() {
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
    }

    @Test
    public void homePageTitleTest() {
        String title = homePage.getHomePageTitle();
        Assert.assertEquals(title, "Dashboard ‹ Wordpress Demo Site at Demo.Center — WordPress");
    }

    @Test
    public void quickDraftExpandedByDefaultTest(){
        Assert.assertTrue(homePage.checkIfQuickDraftExpanded());
    }

    @Test
    public void collapseQuickDraftTest(){
        homePage.collapseQuickDraft();
        Assert.assertFalse(homePage.checkIfQuickDraftExpanded());
    }

    @Test
    public void expandQuickDraftTest(){
        homePage.collapseQuickDraft();
        homePage.expandQuickDraft();
        Assert.assertTrue(homePage.checkIfQuickDraftExpanded());
    }

    @Test
    public void createAndSaveQuickDraftTest(){
        Assert.assertTrue(homePage.createAndVerifyDraft("Example title", "Some example content"));
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
    public void tearDown(ITestResult result) {
        afterTestLogResult(result);
        driver.close();
        driver.quit();
    }
}
