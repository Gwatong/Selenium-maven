package pages;

import base.MenuSelectItems;
import base.MenuSelector;
import base.TestBase;
import org.openqa.selenium.support.PageFactory;

public class MediaPage extends TestBase implements MenuSelector {

    MenuSelectItems menu;

    public MediaPage() {
        menu = new MenuSelectItems();
        PageFactory.initElements(driver, this);
        PageFactory.initElements(driver, menu);

    }

    public String getMediaPageTitle() {
        return driver.getTitle();
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
}
