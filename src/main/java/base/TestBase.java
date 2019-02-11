package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import util.EventHandler;
import util.TestUtil;
import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public abstract class TestBase {

    public static WebDriver driver;
    public static Properties prop;
    public static Logger logger;

    public TestBase(){
        setLogger();
        loadProperties();

    }

    public void setLogger(){
        logger = Logger.getLogger(this.getClass());
    }

    private static void loadProperties(){
        try {
            prop = new Properties();
            FileInputStream ip = new FileInputStream(
                    System.getProperty("user.dir") + "/src/main/config/config.properties");
            prop.load(ip);
        } catch (FileNotFoundException e){
            logger.fatal("Configuration file not found", e);
            e.printStackTrace();
        }catch (IOException e){
            logger.fatal("Failed reading from config properties", e);
            e.printStackTrace();
        }
    }

    public static void initialize(){
        String browserName = prop.getProperty("browser");

        if(browserName.equals("chrome")){
            driver = new ChromeDriver();
        }
        else if(browserName.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver",
                    System.getProperty("user.dir") + "/geckodrivers/geckodriver");
            DesiredCapabilities capabilities = DesiredCapabilities.firefox();
            capabilities.setCapability("marionette",true);
            FirefoxOptions options = new FirefoxOptions();
            options.setLegacy(true);
            driver= new FirefoxDriver(capabilities);

        }
        EventFiringWebDriver eventDriver = new EventFiringWebDriver(driver);
        EventHandler handler = new EventHandler();
        eventDriver.register(handler);
        driver = eventDriver;

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

        driver.get(prop.getProperty("url"));

    }

}
