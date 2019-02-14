package pages;

import base.MenuSelectItems;
import base.MenuSelector;
import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends TestBase implements MenuSelector {

    MenuSelectItems menu;

    @FindBy(linkText = "View your site")
    WebElement viewSiteButton;

    @FindBy(className = "handlediv")
    WebElement quickDraft;

    @FindBy(id = "title")
    WebElement quickDraftTitle;

    @FindBy(id = "content")
    WebElement quickDraftContent;

    @FindBy(id = "save-post")
    WebElement saveQuickDraftButton;

    public HomePage() {
        menu = new MenuSelectItems();
        PageFactory.initElements(driver, this);
        PageFactory.initElements(driver, menu);

    }

    public String getHomePageTitle() {
        return driver.getTitle();
    }

    public boolean checkIfQuickDraftExpanded(){
        return Boolean.parseBoolean(quickDraft.getAttribute("aria-expanded"));
    }

    public boolean createAndVerifyDraft(String title, String content){
        quickDraftTitle.sendKeys(title);
        quickDraftContent.sendKeys(content);
        saveQuickDraftButton.click();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement element = driver.findElement(By.linkText(title));
        return element.isDisplayed();
    }


    public void expandQuickDraft(){
        if (!checkIfQuickDraftExpanded()){
            quickDraft.click();
        }
    }

    public void collapseQuickDraft(){
        if(checkIfQuickDraftExpanded()){
            quickDraft.click();
        }
    }

    public void goToViewSite(){
        viewSiteButton.click();
    }

    public PostsPage goToPostsPage() {
            menu.getPostsButton().click();
        return new PostsPage();
    }

    public MediaPage goToMediaPage() {
            menu.getMediaButton().click();
        return new MediaPage();
    }

    public YoutubePage goToYoutubePage() {
            menu.getYoutubeEmbedButton().click();
        return new YoutubePage();
    }

    public PagesPage goToPagesPage() {
            menu.getPagesButton().click();
        return new PagesPage();
    }

    public CommentsPage goToCommentsPage() {
            menu.getCommentsButton().click();
        return new CommentsPage();
    }

    public AppearancePage goToAppearancePage() {
            menu.getAppearanceButton().click();
        return new AppearancePage();
    }

    public PluginsPage goToPluginsPage() {
            menu.getPluginsElement().click();
        return new PluginsPage();
    }

    public UsersPage goToUsersPage() {
        menu.getUsersButton().click();
        return new UsersPage();
    }

    public ToolsPage goToToolsPage() {
        menu.getToolsButton().click();
        return new ToolsPage();
    }

    public SettingsPage goToSettingsPage() {
        menu.getSettingsButton().click();
        return new SettingsPage();
    }

    public boolean verifyIfMenuIsExpanded() {
        return Boolean.parseBoolean(menu.getCollapseButton().getAttribute("aria-expanded"));
    }

    public void collapseMenu() {
        menu.getCollapseButton().click();
    }

}
