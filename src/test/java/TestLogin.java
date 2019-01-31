import jdk.nashorn.internal.runtime.logging.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestLogin implements IRetryAnalyzer {

    private int retryCount = 0;
    private int maxRetryCount = 2;

    @Override
    public boolean retry(ITestResult result) {
        if (retryCount < maxRetryCount) {
            retryCount++;
            return true;
        }
        return false;
    }

    @BeforeSuite
    public void before(){
        System.out.println("BEFORE TEST");
    }

    @Test
    public void verifyValidLogin(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        LoginPage login = new LoginPage(driver);
        login.openLoginPage();
        login.typeUsername("admin");
        login.typePassword("demo123");
        login.clickOnLoginButton();

        driver.close();
    }

    @Test
    public void testLogin_should_fail(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        LoginPage login = new LoginPage(driver);
        login.openLoginPage();
        login.typeUsername("admin");
        login.typePassword("");
        login.clickOnLoginButton();

        driver.close();
    }





}
