package base;

import pages.*;
import pages.PagesPage;

public interface MenuSelector {

    PostsPage goToPostsPage();

    MediaPage goToMediaPage();

    YoutubePage goToYoutubePage();

    PagesPage goToPagesPage();

    CommentsPage goToCommentsPage();

    AppearancePage goToAppearancePage();

    PluginsPage goToPluginsPage();

    UsersPage goToUsersPage();

    ToolsPage goToToolsPage();

    SettingsPage goToSettingsPage();
}
