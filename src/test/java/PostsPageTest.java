import base.TestBase;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.PostsPage;

public class PostsPageTest extends TestBase {

    LoginPage loginPage;
    HomePage homePage;
    PostsPage postsPage;

    public PostsPageTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        initialize();
        loginPage = new LoginPage();
        homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
        postsPage = homePage.goToPostsPage();
    }

    @Test
    public void postsPageTitleTest() {
        String title = postsPage.getPostsPageTitle();
        Assert.assertEquals(title, "Posts ‹ Wordpress Demo Site at Demo.Center — WordPress");
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        afterTestLogResult(result);
        driver.close();
        driver.quit();
    }
}
