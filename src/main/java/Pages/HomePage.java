package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import javax.swing.*;
import java.security.PublicKey;
import java.util.List;
//**
//Class include :-
// Functionality of Home Page or apps page
// Object repository for the page ids
// constructor for category page used the driver defined in java class pages
// and the javascript function  helper
public class HomePage extends PageBase {
    public HomePage(WebDriver driver) {
        super(driver);

        jse = (JavascriptExecutor) driver;
        action = new Actions(driver);


    }
///Home Object IDs//
    @FindBy(id = "gbq1")
        public static
WebElement GooglePlay_Icon;

    @FindBy(xpath = "/html/body/div[1]/div[1]/c-wiz[1]/ul/li[2]")
    public static
    WebElement Apps_Item;

    @FindBy(id = "action-dropdown-parent-Categories")
    public static
    WebElement Categories_Item;


    @FindBy(id = "gbqfq")
    public static
    WebElement SearchTextBox;


    @FindBy(id = "gbqfbw")
    public static
    WebElement Search_Button;

    @FindBy(css = "li.CRHL7b:nth-child(1) > ul:nth-child(1) > li:nth-child(10)")
    public static
    WebElement Education_Category;
    @FindBy(id = "action-dropdown-children-Categories")
    public static
    WebElement SelectCategories_list;

    /// categories List and home Page Functionality ( including search , category list )

    public void GoogleHomePageLoaded() {
        GooglePlay_Icon.isDisplayed();
    }

    public void SelectAppsMenu() {
        clickButton(Apps_Item);
    }



    public void OpenCategoriesList() {

        clickButton(Categories_Item);
    }

    public void CategoriesListDisplayed() {
        SelectCategories_list.isDisplayed();


    }


    public void NavigateToEdiocationPage() {
        action
                .moveToElement(SelectCategories_list)
                .moveToElement(Education_Category)
                .click()
                .build()
                .perform();

    }

    public void ProductSearch(String APPName)
    {
        setTextElementText(SearchTextBox, APPName);
        clickButton(Search_Button);
    }

    public void ClearSearchTEXTBOX()
    {

        clearText(SearchTextBox);
    }

}


