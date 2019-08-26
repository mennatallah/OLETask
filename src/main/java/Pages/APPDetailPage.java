package Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//**
//Class include :-
// Functionality of AppDetails apps page
// Object repository for the page ids
// constructor for category page used the driver defined in java class pages
// and the javascript function  helper
public class APPDetailPage extends PageBase {

    public APPDetailPage(WebDriver driver) {
        super(driver);

        jse = (JavascriptExecutor) driver;
        action = new Actions(driver);


    }

    /// Object ID's

    @FindBy( xpath = "/html/body/div[1]/div[4]/c-wiz[3]/div/div[2]/div/div[1]/div/c-wiz[1]/c-wiz[1]/div/div[2]/div/div[1]/c-wiz[1]/h1/span")
    public static
    WebElement PageDetail_AppNAME;

    @FindBy( xpath = "//*[@id='fcxH9b']/div[4]/c-wiz/div/div[2]/div/div[1]/div/c-wiz[1]/c-wiz[1]/div/div[2]/div/div[1]/div[2]/div[1]/div[1]/span[1]/a")
    public static
    WebElement Publisher_Name;

    @FindBy( xpath = "//*[@id=\"fcxH9b\"]/div[4]/c-wiz/div/div[2]/div/div[1]/div/c-wiz[1]/c-wiz[1]/div/div[2]/div/div[1]/div[2]/div[1]/div[1]/span[2]/a")
    public static
    WebElement APPType_Name;

    @FindBy( xpath = "/html/body/div[1]/div[4]/c-wiz[3]/div/div[2]/div/div[1]/div/c-wiz[1]/c-wiz[1]/div/div[1]/div/img")
    public static
    WebElement PageDetail_Icon;

    @FindBy( className = "oocvOe")
    public static
    WebElement Install_Button;


    // Page functionality will be reused by Test class
    public void AppNameInPageDetail() {
        PageDetail_AppNAME.isDisplayed();
    }
    public void AppPublisherInPageDetail() {

        Publisher_Name.isDisplayed();
    }
    public void AppTypeInPageDetail() {
        APPType_Name.isDisplayed();
    }
    public void AppIconeInPageDetail() {

        PageDetail_Icon.isDisplayed();
    }

    public void InstallButtonDisplayed() {

        Install_Button.isDisplayed();
    }

}
