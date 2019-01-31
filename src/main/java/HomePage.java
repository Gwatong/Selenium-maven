import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    String pageUrl = "http://demosite.center/wordpress/wp-admin/";

    WebDriver driver;
    Actions builder;

    By dashBoard;
    By update;
    By post;
    By newPost;

    WebElement dashBoardElement;
    WebElement updateElement;
    WebElement postElement;
    WebElement newPostElement;

     public HomePage(WebDriver driver){
         this.driver = driver;
         builder = new Actions(driver);
         initializeByObjects();
         initializeWebElements();
     }

     public void initializeByObjects(){
         dashBoard = By.xpath("//*[@id=\"menu-dashboard\"]/a/div[3]");
         update = By.xpath("//*[@id=\"menu-dashboard\"]/ul/li[3]/a");
         post = By.xpath("//*[@id=\"menu-posts\"]/a/div[2]");
     }

     public void initializeWebElements(){
         dashBoardElement = driver.findElement(dashBoard);
         updateElement = driver.findElement(update);
         postElement = driver.findElement(post);
     }

     public void moveOverWordpressIcon(){
        builder.moveToElement(dashBoardElement);
     }

     public void moveOverUpdatesIcon(){
         builder.moveToElement(updateElement);
     }

     public void openUpdates(){
         moveOverWordpressIcon();
         moveOverUpdatesIcon();
         builder.click();
         try {
             Thread.sleep(5000);
         } catch (InterruptedException e) {
             e.printStackTrace();
         }

     }

     public void addNewPost(){
        builder.moveToElement(postElement);
        newPost = By.xpath("//*[@id=\"menu-posts\"]/ul/li[3]/a");
        newPostElement = driver.findElement(newPost);
        builder.moveToElement(postElement).perform();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(newPost));
        newPostElement.click();

     }


}
