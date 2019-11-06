package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
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
        profilePage.openProfilePage();
        driver.manage().window().maximize();
    }

    @Test
    public void lastNameOfFamilyChanging() throws InterruptedException {
        //----------------Generation of the new last name ---------------------
        String lastName = profilePage.newLastNameGeneration();
        //-------------- Open in edit mode and change the last name --------------------
        profilePage.changeLastName(lastName);

        //-----------------Save profile---------------------
        Assert.assertEquals(profilePage.saveProfile(), lastName, "Last name not preserved.");
    }

    @Test
    public void profileAndFamilyPageComparing() {
        String[] profilelDetails;/*= new String[6];*/
        String[] familyDetails;/* = new String[6];*/
        profilelDetails = profilePage.saveDataFromTheProfilePage();
        familyPage.openFamilyProfilePage();
        familyDetails = familyPage.saveDataFromTheFamilyPage();
        Boolean resultComparingPages;
        resultComparingPages = profilePage.comparingProfileAndFamilyPage(profilelDetails, familyDetails);
        Assert.assertTrue(resultComparingPages);
    }
}
