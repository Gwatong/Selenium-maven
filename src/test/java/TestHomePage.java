import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestHomePage {

//    @Test
//    public void openUpadtes(){
//        WebDriver driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        LoginPage loginPage = new LoginPage(driver);
//        loginPage.openLoginPage();
//        loginPage.login();
//        HomePage homePage = new HomePage(driver);
//        homePage.openUpdates();
//        driver.quit();
//    }

    @Test
    public void addNewPost(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage();
        loginPage.login();
        HomePage homePage = new HomePage(driver);
        homePage.addNewPost();
    }
}
