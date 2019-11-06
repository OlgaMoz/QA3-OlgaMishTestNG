package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.*;

public class ProfilePageTests extends TestBase {
   // PageBase pageBase;
    HomePageHelper homePage;
    LoginPageHelper loginPage;
    HomePageAuthHelper homePageAuth;
    ProfilePageHelper profilePage;
     FamilyPageHelper familyPage;

    @BeforeMethod
    public void initTests() {
        homePage = new HomePageHelper(driver);
        loginPage = new LoginPageHelper(driver);
        homePageAuth = new HomePageAuthHelper(driver);
        profilePage = new ProfilePageHelper(driver);
        familyPage = new FamilyPageHelper(driver);

        homePage.waitUntilHomePageIsLoaded();
        loginPage.openLoginPage();
        loginPage.initLoginTests(LOGIN, PASSWORD);
        profilePage.openProfile();
    }

    @Test
    public void lastNameOfFamilyChanging() throws InterruptedException {
        //----------------Generation of the new last name ---------------------
        String lastName = profilePage.newLastNameGeneration();
        //-------------- Open in edit mode and change the last name --------------------
        profilePage.changeLastName(lastName);

        //-----------------Save profile---last name???????------------------
        Assert.assertEquals(profilePage.saveProfile(), lastName, "Last name not preserved.");
    }

    @Test
    public void profileAndFamilyPageComparing() {
        String [] profilelDetails ;/*= new String[6];*/
        String [] familyDetails;/* = new String[6];*/
        profilelDetails = profilePage.saveDataFromTheProfilePage();
        familyDetails = saveDataFromTheFamilyPage();


       // Assert.assertTrue(profilePage.comparingProfileAndFamilyPage(profilePage.saveDataFromTheProfilePage(),
        //        profilePage.saveDataFromTheFamilyPage()));
      /*  Assert.assertTrue(profilePage.comparingProfileAndFamilyPage(saveDataFromTheProfilePage(),
                saveDataFromTheFamilyPage()));*/
    }

   /* public String[] saveDataFromTheProfilePage() {
        waitUntilElementIsVisible(By.cssSelector(".itemprofilefit #fieldobjconfession"), 40);
        String[] array;
        //  array1 = new String[6];
        Boolean familySign;
        familySign = true;
        array = profilePage.saveDataFromTheProfileOrFamilyPage(familySign);
        return array;
    }*/

    public String[] saveDataFromTheFamilyPage() {
        familyPage.waitUntilFamilyPageIsExist();
       // waitUntilElementIsClickable(By.id("family"), 60);
        profilePage.openElementById("family");
        waitUntilElementIsVisible(By.id("fieldobjconfession"), 40);
        String[] array;
        //  array1 = new String[6];
        Boolean familySign;
        familySign = false;
        array = profilePage.saveDataFromTheProfileOrFamilyPage(familySign);
        return array;
    }


}
