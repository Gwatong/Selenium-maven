import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage {

    String pageUrl = "http://demosite.center/wordpress/wp-login.php";

    WebDriver driver;
    By username = By.id("user_login");
    By password = By.xpath("//*[@id=\"user_pass\"]");
    By loginButton = By.name("wp-submit");

    String defaultId = "admin";
    String defaultPassword = "demo123";

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void openLoginPage(){
        driver.get(pageUrl);
    }


    public void login(String userId, String password){
        typeUsername(userId);
        typePassword(password);
        clickOnLoginButton();
    }

    public void login(){
        typeUsername(defaultId);
        typePassword(defaultPassword);
        clickOnLoginButton();
    }

    public void typeUsername(String uid){
        driver.findElement(username).sendKeys(uid);
    }

    public void typePassword(String pass){
        driver.findElement(password).sendKeys(pass);
    }

    public void clickOnLoginButton(){
        driver.findElement(loginButton).click();
    }


}
