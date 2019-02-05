import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.UsersPage;

public class UsersPageTest extends TestBase {

    LoginPage loginPage;
    HomePage homePage;
    UsersPage usersPage;

    public UsersPageTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        initialize();
        loginPage = new LoginPage();
        homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
        usersPage = homePage.goToUsersPage();
    }

    @Test
    public void usersPageTitleTest() {
        String title = usersPage.getUsersPageTitle();
        Assert.assertEquals(title, "Users ‹ Wordpress Demo Site at Demo.Center — WordPress");
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
        driver.quit();
    }
}
