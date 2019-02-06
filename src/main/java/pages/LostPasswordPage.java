package pages;

import base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LostPasswordPage extends TestBase {

    @FindBy(className = "message")
    WebElement message;

    @FindBy(linkText = "Log in")
    WebElement backToLogInButton;

    @FindBy(id = "wp-submit")
    WebElement getNewPasswordButton;

    @FindBy(id = "user_login")
    WebElement username;

    @FindBy(id = "login_error" )
    WebElement errorMessage;

   public LostPasswordPage(){
       PageFactory.initElements(driver, this);
   }

   public String getLostPasswordPageTitle(){
       return driver.getTitle();
   }

   public String getMessage(){
       return message.getText();
   }

   public LoginPage goToLoginPage(){
       backToLogInButton.click();
       return new LoginPage();
   }

   public LoginPage passwordRecoveryWithValidUsername(String un){
       username.sendKeys(un);
       getNewPasswordButton.click();
       return new LoginPage();
   }

    public String getErrorForInvalidUsernameForPasswordRecovery(){
        username.sendKeys("invalidUsername");
        getNewPasswordButton.click();
        return errorMessage.getText();
    }
}
