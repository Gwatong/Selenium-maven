import base.TestBase;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CommentsPage;
import pages.HomePage;
import pages.LoginPage;

public class CommentsPageTest extends TestBase {

    LoginPage loginPage;
    HomePage homePage;
    CommentsPage commentsPage;

    public CommentsPageTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        initialize();
        loginPage = new LoginPage();
        homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
        commentsPage = homePage.goToCommentsPage();
    }

    @Test
    public void commentsPageTitleTest() {
        String title = commentsPage.getCommentsPageTitle();
        Assert.assertEquals(title, "Comments ‹ Wordpress Demo Site at Demo.Center — WordPress");
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        afterTestLogResult(result);
        driver.close();
        driver.quit();
    }
}
