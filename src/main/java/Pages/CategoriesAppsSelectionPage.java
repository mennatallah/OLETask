package Pages;

import com.google.gson.annotations.Until;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

import java.util.List;
//**
//Class include :-
// Functionality of Education category apps page
// Object repository for the page ids
// constructor for category page used the driver defined in java class pages
// and the javascript function  helper

public class CategoriesAppsSelectionPage extends PageBase {
    public CategoriesAppsSelectionPage(WebDriver driver) {
        super(driver);

        jse = (JavascriptExecutor) driver;
        action = new Actions(driver);


    }
/// Object IDs

    @FindBy(className = "mZr3Me")
    public static
    WebElement Home_item;

    @FindBy(id = "action-dropdown-parent-Education")
    public static
    WebElement Education_Page;

    @FindBy( tagName = "a")
    public static
    List<WebElement> APP_List ;

    @FindBy(linkText = "See more")
    public static
    WebElement RecomendApps;

    @FindBy( linkText = "TED")
    public static
    WebElement TED_Item;

    @FindBy( xpath = "/html/body/div[1]/div[4]/c-wiz[3]/div/div[2]/div/c-wiz/c-wiz/c-wiz/div/div[2]/div[1]/c-wiz/div/div/div[1]/div/span[2]/span/img")
    public static
    WebElement TED_Icon;


    @FindBy( className ="pf5lIe")
    public static
    WebElement get_APP_Rate;

    @FindBy( xpath ="/html/body/div[1]/div[4]/c-wiz[3]/div/div[2]/div/c-wiz/c-wiz/c-wiz/div/div[2]/div[1]/c-wiz/div/div/div[2]/div/div/div[1]/div/div[1]/div[2]/a")
    public static
    WebElement get_APP_Desc;


    @FindBy( xpath ="//*[@id=\"fcxH9b\"]/div[4]/c-wiz[3]/div/div[2]/div/c-wiz/c-wiz/c-wiz/div/div[2]/div[1]/c-wiz/div/div/div[1]/div/div")
    public static
    WebElement get_APP_Item;


    @FindBy( xpath = "/html/body/div[1]/div[4]/c-wiz[2]/div/div[2]/div/c-wiz/c-wiz[1]/c-wiz/div/div[2]/div[1]/c-wiz/div/div/div[1]/div/span[2]/span/img")
    public static
    WebElement FaceBook_Icon;
    @FindBy( xpath = "//*[@id=\"fcxH9b\"]/div[4]/c-wiz[2]/div/div[2]/div/c-wiz/c-wiz[1]/c-wiz/div/div[2]/div[1]/c-wiz/div")
    public static
    WebElement getApps_Item;

    // Page functionality will be reused by Test class

    public void HomeItemIsSelected() {
        Home_item.isSelected();
    }

    public void ProductSearchUsingAutoSuggest(String searchTxt)
    {
        setTextElementText(HomePage.SearchTextBox, searchTxt);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
         APP_List.get(0).click();
    }
    public void OpenAPPDetailsPage()
    {


        TED_Icon.isDisplayed();
        clickButton(TED_Item);

    }
    public void GetAppITem()
    {


        get_APP_Item.isDisplayed();
        get_APP_Desc.isDisplayed();
        get_APP_Rate.isDisplayed();

    }
}
