package tests;

import commonUtility.CommonConstant;
import commonUtility.CommonFunctionality;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.io.File;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import commonUtility.CommonConstant;
import commonUtility.CommonFunctionality;
//** This class is responsible for launching the browser and navigate to the URL
// Take screenshot in failed status

public class TestBase {


    public static WebDriver driver;
    public static String BaseUrl;
    public static String downloadPath = System.getProperty("user.dir") + "\\Downloads";

    public static FirefoxOptions firefoxOption() {
        FirefoxOptions option = new FirefoxOptions();
        option.addPreference("browser.download.folderList", 2);
        option.addPreference("browser.download.dir", downloadPath);
        option.addPreference("browser.helperApps.neverAsk.saveToDisk", "application/pdf");
        option.addPreference("browser.download.manager.showWhenStarting", false);
        option.addPreference("pdfjs.disabled", true);
        return option;
    }

    public static ChromeOptions chromeOption() {
        ChromeOptions options = new ChromeOptions();
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("profile.default.content_settings.popups", 0);
        chromePrefs.put("download.default_directory", downloadPath);
        options.setExperimentalOption("prefs", chromePrefs);
        options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        return options;
    }
    @BeforeMethod

    @Parameters({"browser","url"})

    public void Startup(@Optional("chrome")String WindowBrowser, @Optional("https://play.google.com/store?hl=en")String url){

        BaseUrl = url;
        if (WindowBrowser.equalsIgnoreCase("firefox") )
        {
            System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+ "/drivers/geckodriver.exe");
            driver = new FirefoxDriver();

        }
        else if(WindowBrowser.equalsIgnoreCase("chrome"))
        {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ "/drive/chromedriver.exe");

            driver = new ChromeDriver();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("disable-infobars");
            options.addArguments("--headless");

        }
//        else if(WindowBrowser.equalsIgnoreCase("ie"))
//        {
//            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/driver/IEDriverServer.exe");
//            driver = new InternetExplorerDriver();
//
//        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
        driver.navigate().to(BaseUrl);
        driver.manage().getCookies();
        Set<Cookie> allCookies = driver.manage().getCookies();
        for(Cookie cookie : allCookies)
        {
            driver.manage().addCookie(cookie);
        }
    }
    @AfterMethod
    public void Close(ITestResult result)
    {
        if(ITestResult.FAILURE==result.getStatus()){
            System.out.println("The test is Failed!");
            System.out.println("Taking Screenshot....");
            CommonFunctionality.captureScreenshot(driver, result.getName());
        }
        driver.quit();
    }

}
