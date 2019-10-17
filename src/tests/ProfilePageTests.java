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
    PageBase pageBase;
    HomePageHelper homePage;
    LoginPageHelper loginPage;
    HomePageAuthHelper homePageAuth;
    ProfilePageHelper profilePage;

    @BeforeMethod
    public void initTests() {
        homePage = new HomePageHelper(driver);
        loginPage = new LoginPageHelper(driver);
        homePageAuth = new HomePageAuthHelper(driver);
        profilePage = new ProfilePageHelper(driver);

        homePage.waitUntilPageIsLoaded(By.id("idsignin"), 20);
        loginPage.openLoginPage();
        //loginPage.waitUntilPageIsLoaded(By.id("signinrequest"), 20);
        loginPage.initLoginTests(LOGIN, PASSWORD);
        profilePage.openProfile();
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
    public void profileAndFamilyPageComparing() throws InterruptedException {

        Assert.assertTrue(profilePage.comparingProfileAndFamilyPage(profilePage.saveDataFromTheProfilePage(),
                profilePage.saveDataFromTheFamilyPage()));
    }


}
