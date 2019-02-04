package base;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MenuSelectItems {

    @FindBy(xpath = "/html/body/div[1]/div[1]/div[2]/ul/li[3]/a/div[3]")
    private WebElement postsButton;

    @FindBy(xpath = "/html/body/div[1]/div[1]/div[2]/ul/li[4]/a/div[3]")
    private WebElement mediaButton;

    @FindBy(xpath = "/html/body/div[1]/div[1]/div[2]/ul/li[5]/a/div[3]")
    private WebElement youtubeEmbedButton;

    @FindBy(xpath = "/html/body/div[1]/div[1]/div[2]/ul/li[6]/a/div[3]")
    private WebElement pagesButton;

    @FindBy(xpath = "/html/body/div[1]/div[1]/div[2]/ul/li[7]/a/div[3]")
    private WebElement commentsButton;

    @FindBy(xpath = "/html/body/div[1]/div[1]/div[2]/ul/li[9]/a/div[3]")
    private WebElement appearanceButton;

    @FindBy(xpath = "/html/body/div[1]/div[1]/div[2]/ul/li[10]/a/div[3]")
    private WebElement pluginsElement;

    @FindBy(xpath = "/html/body/div[1]/div[1]/div[2]/ul/li[11]/a/div[3]")
    private WebElement usersButton;

    @FindBy(xpath = "/html/body/div[1]/div[1]/div[2]/ul/li[12]/a/div[3]")
    private WebElement toolsButton;

    @FindBy(xpath = "/html/body/div[1]/div[1]/div[2]/ul/li[13]/a/div[3]")
    private WebElement settingsButton;

    @FindBy(id = "collapse-button")
    private WebElement collapseButton;

    public WebElement getAppearanceButton() {
        return appearanceButton;
    }

    public WebElement getPostsButton() {
        return postsButton;
    }

    public WebElement getMediaButton() {
        return mediaButton;
    }

    public WebElement getYoutubeEmbedButton() {
        return youtubeEmbedButton;
    }

    public WebElement getPagesButton() {
        return pagesButton;
    }

    public WebElement getCommentsButton() {
        return commentsButton;
    }

    public WebElement getPluginsElement() {
        return pluginsElement;
    }

    public WebElement getUsersButton() {
        return usersButton;
    }

    public WebElement getToolsButton() {
        return toolsButton;
    }

    public WebElement getSettingsButton() {
        return settingsButton;
    }

    public WebElement getCollapseButton() {
        return collapseButton;
    }
}
