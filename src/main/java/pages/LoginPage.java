package pages;


import base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase {


    @FindBy(name = "log")
    WebElement username;

    @FindBy(name = "pwd")
    WebElement password;

    @FindBy(xpath = "//*[@id=\"wp-submit\"]")
    WebElement loginBtn;

    @FindBy(xpath = "/html/body/div[1]/p[1]/a")
    WebElement lostPasswordButton;

    @FindBy(xpath = "/html/body/div[1]/h1/a")
    WebElement wordpressLogo;


    public LoginPage(){
        PageFactory.initElements(driver, this);
    }


//    ACTIONS:
    public String validateLoginPageTitle(){
        return driver.getTitle();
    }

    public boolean validateWordpressIMAGE(){
        return wordpressLogo.isDisplayed();
    }

    public HomePage login(String un, String pwd){
        username.sendKeys(un);
        password.sendKeys(pwd);
        loginBtn.click();

        return new HomePage();
    }


//    String pageUrl = "http://demosite.center/wordpress/wp-login.php";
//
//    WebDriver driver;
//    By username = By.id("user_login");
//    By password = By.xpath("//*[@id=\"user_pass\"]");
//    By loginButton = By.name("wp-submit");
//
//    String defaultId = "admin";
//    String defaultPassword = "demo123";
//
//    public LoginPage(WebDriver driver){
//        this.driver = driver;
//    }
//
//    public void openLoginPage(){
//        driver.get(pageUrl);
//    }
//
//
//    public void login(String userId, String password){
//        typeUsername(userId);
//        typePassword(password);
//        clickOnLoginButton();
//    }
//
//    public void login(){
//        typeUsername(defaultId);
//        typePassword(defaultPassword);
//        clickOnLoginButton();
//    }
//
//    public void typeUsername(String uid){
//        driver.findElement(username).sendKeys(uid);
//    }
//
//    public void typePassword(String pass){
//        driver.findElement(password).sendKeys(pass);
//    }
//
//    public void clickOnLoginButton(){
//        driver.findElement(loginButton).click();
//    }


}
