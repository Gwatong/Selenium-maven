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

    @FindBy(id = "rememberme")
    WebElement rememberMeCheckbox;

    @FindBy(className = "message")
    WebElement messageSuccesPasswordRecovery;


    public LoginPage(){
        PageFactory.initElements(driver, this);
    }


//    ACTIONS:
    public void setRememberMeCheckbox(){
        rememberMeCheckbox.click();
    }

    public boolean checkIfRemembermeCheckboxChecked(){
        return rememberMeCheckbox.isSelected();
    }

    public String getLoginPageTitle(){
        return driver.getTitle();
    }

    public boolean validateWordpressImage(){
        return wordpressLogo.isDisplayed();
    }

    public HomePage login(String un, String pwd){
        username.sendKeys(un);
        password.sendKeys(pwd);
        loginBtn.click();

        return new HomePage();
    }

    public LostPasswordPage goToLostPasswordPage(){
        lostPasswordButton.click();
        return new LostPasswordPage();
    }

    public String getSuccessPasswordRecoveryMessage(){
        return messageSuccesPasswordRecovery.getText();
    }

}
