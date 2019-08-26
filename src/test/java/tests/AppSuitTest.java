package tests;

import Pages.APPDetailPage;
import Pages.CategoriesAppsSelectionPage;
import Pages.HomePage;

import commonUtility.CommonConstant;

import org.openqa.selenium.WebElement;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Iterator;

//// Test class including the All test scenarios

public class AppSuitTest extends TestBase {
//    WebDriverWait wait = new WebDriverWait(driver, 15);
    HomePage homePageObject ;
    CategoriesAppsSelectionPage EdiocationAppspageObject;
    APPDetailPage AppDetailPageObject;

/// Scenario 1
//    **1.	Using Google play website: https://play.google.com/store?hl=en
//2.	Select Apps from left side menu and assert you are in the correct page.
//3.	From Category , Select Education and Assert that you are in the Page
//4.	Search for TED
//5.	Press on TED icon and assert that you are in the page.

@Test
    public void NavigateToTEDEdiucationApp_Scenario1 () throws InterruptedException {

/// intialization of the java opject
        homePageObject = new HomePage(driver);
    EdiocationAppspageObject = new CategoriesAppsSelectionPage(driver);
    AppDetailPageObject = new APPDetailPage(driver);
        homePageObject.GoogleHomePageLoaded();
// sleep while the page is loaded
    Thread.sleep(6000);
        homePageObject.SelectAppsMenu();
    Thread.sleep(6000);
    EdiocationAppspageObject.HomeItemIsSelected();
     String actualTitle = driver.getTitle();
    String ExpectedTitle = "TED - Apps on Google Play";

    String ActualURL = driver.getCurrentUrl();


    System.out.println(actualTitle);
    System.out.println(ActualURL);
    Assert.assertEquals(actualTitle, "Android Apps on Google Play" );

    homePageObject.OpenCategoriesList();
    Thread.sleep(6000);

    homePageObject.CategoriesListDisplayed();

    boolean   EdiocationList = homePageObject.SelectCategories_list.isDisplayed();

    if (EdiocationList==true) {


        homePageObject.NavigateToEdiocationPage();
        Thread.sleep(6000);

        Assert.assertTrue(EdiocationAppspageObject.Education_Page.isDisplayed());
        System.out.println(actualTitle);
        System.out.println("The Education Page is displayed");
    }
    else {
        System.out.println(actualTitle);
        System.out.println(ActualURL);
        System.out.println("The Education Page Not displayed ");
    }
   // if (homePageObject.TED_item.isDisplayed()==false){

    Thread.sleep(6000);
    Iterator<WebElement> i = EdiocationAppspageObject.APP_List.iterator();

    while(i.hasNext()) {


        WebElement TEDApp = i.next();


      if (TEDApp.getAttribute("title").equalsIgnoreCase("TED")) {

        // if (TEDApp.getAttribute("href").endsWith("id=com.ted.android")){
            System.out.println(EdiocationAppspageObject.APP_List);
            System.out.println("TED app Displayed in List");

            TEDApp.click();


            break;

        }
//        else {
//            EdiocationAppspageObject.RecomendApps.click();
//            System.out.println("TED app Displayed in  recomendation List");
//
//            break;
//
//        }
    }
  //  }
//else
//{
    Thread.sleep(6000);
    String APPName = "TED";

    homePageObject.ProductSearch(APPName);

    Thread.sleep(9000);

EdiocationAppspageObject.GetAppITem();
    String src = EdiocationAppspageObject.TED_Icon.getAttribute("src");
    System.out.println("image URL"+src);

    Assert.assertEquals(EdiocationAppspageObject.TED_Icon.getAttribute(CommonConstant.HTML_ATTR_SRC),CommonConstant.APP_IMG_SRC);

    Assert.assertEquals(EdiocationAppspageObject.get_APP_Desc.getAttribute(CommonConstant.HTML_ATTR_TEXTL),CommonConstant.APP_DES_HREF);
   // Assert.assertEquals(EdiocationAppspageObject.get_APP_Rate.getAttribute(CommonConstant.HTML_ATTR_AT),CommonConstant.APP_RATE);


    homePageObject.ClearSearchTEXTBOX();
    EdiocationAppspageObject.OpenAPPDetailsPage();
    Thread.sleep(6000);

/// APP details Page Assertions ( TED App Detail Page )

    System.out.println(AppDetailPageObject.PageDetail_AppNAME.getAttribute("linkText"));
    System.out.println(AppDetailPageObject.Publisher_Name.getAttribute("linkText"));
    Assert.assertEquals(driver.getTitle(), ExpectedTitle);
    System.out.println(AppDetailPageObject.PageDetail_AppNAME.getAttribute("linkText"));
    System.out.println(AppDetailPageObject.Publisher_Name.getAttribute("linkText"));
    AppDetailPageObject.AppIconeInPageDetail();
    AppDetailPageObject.PageDetail_Icon.isDisplayed();
    Assert.assertEquals(AppDetailPageObject.PageDetail_Icon.getAttribute(CommonConstant.HTML_ATTR_SRC),CommonConstant.APP_AppDetail_IMG_SRC);
    AppDetailPageObject.AppPublisherInPageDetail();
    Assert.assertEquals(AppDetailPageObject.Publisher_Name.getAttribute(CommonConstant.HTML_PUBLISHER_HREF),CommonConstant.APP_PUBLISHNAME_HREF);
    AppDetailPageObject.AppTypeInPageDetail();

    Assert.assertEquals(AppDetailPageObject.Publisher_Name.getAttribute(CommonConstant.HTML_PUBLISHER_HREF),CommonConstant.APP_TYPE_HREF);
    AppDetailPageObject.InstallButtonDisplayed();
    //Assert.assertEquals(AppDetailPageObject.Install_Button.getAttribute(CommonConstant.HTML_ATTR_BTN_INSTALL_COLOR),CommonConstant.HTML_ATTR_BTN_INSTALL_VALUE);

//}

    }

//    Scenario 2:
//    Search for Facebook on Google play and assert that icon exists.

    @Test (priority = 1)
    public void FaceBookSearch_Scenario2() throws InterruptedException {

        homePageObject = new HomePage(driver);
        EdiocationAppspageObject = new CategoriesAppsSelectionPage(driver);
        homePageObject.GoogleHomePageLoaded();
        String productName = "Facebook";

        homePageObject.ProductSearch(productName);
        Thread.sleep(6000);

// search for facebook application

        EdiocationAppspageObject.getApps_Item.isDisplayed();
        Iterator<WebElement> i = EdiocationAppspageObject.APP_List.iterator();

        while(i.hasNext()) {


            WebElement FBApp = i.next();


            if (FBApp.getAttribute("title").contains("facebook")) {


                System.out.println(EdiocationAppspageObject.APP_List);
                System.out.println("facebook will be displayed in app List");

                FBApp.isDisplayed();
                String srcFB = EdiocationAppspageObject.FaceBook_Icon.getAttribute("src");
                System.out.println("image URL"+srcFB);
                Assert.assertEquals(EdiocationAppspageObject.FaceBook_Icon.getAttribute(CommonConstant.HTML_ATTR_SRC),CommonConstant.APP_FaceBook_IMG_SRC);

                break;

            }
        }

        EdiocationAppspageObject.FaceBook_Icon.isDisplayed();
        homePageObject.ClearSearchTEXTBOX();
        String src = EdiocationAppspageObject.FaceBook_Icon.getAttribute("src");
        System.out.println("image URL"+src);

        Assert.assertEquals(EdiocationAppspageObject.FaceBook_Icon.getAttribute(CommonConstant.HTML_ATTR_SRC),CommonConstant.APP_FaceBook_IMG_SRC);
        Assert.assertEquals(EdiocationAppspageObject.get_APP_Desc.getAttribute(CommonConstant.HTML_ATTR_TEXTL),CommonConstant.FACEBOOK_APP_DES_HREF);



    }
}
