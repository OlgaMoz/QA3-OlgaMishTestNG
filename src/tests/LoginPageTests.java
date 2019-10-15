package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePageAuthHelper;
import pages.HomePageHelper;
import pages.LoginPageHelper;

public class LoginPageTests extends TestBase {
    HomePageHelper homePage;
    LoginPageHelper loginPage;
    HomePageAuthHelper homePageAuth;

    @BeforeMethod
    public void initTests() {
        homePage = new HomePageHelper(driver);
        loginPage = new LoginPageHelper(driver);
        homePageAuth = new HomePageAuthHelper(driver);

        homePage.waitUntilPageIsLoaded(By.id("idsignin"),20);
        loginPage.openLoginPage();
        loginPage.waitUntilPageIsLoaded(By.id("signinrequest"), 20);

    }

    @Test
    public void loginPositiveTest() {

        loginPage.initLoginTests(LOGIN, PASSWORD);
        loginPage.waitUntilPageIsLoaded(By.id("profile"), 30);
        Assert.assertTrue(homePageAuth.correctAuthorizationIsEnded());

    }

    @Test
    public void loginNegativeTest() {
        loginPage.initLoginTests(LOGIN, LOGIN);
        Assert.assertTrue(loginPage.loginToTheSystemIncorrect());
        loginPage.closeLoginWindowByX();
        Assert.assertTrue(homePage.correctPageIsLoaded(By.id("idtitletypesearchevents"), "List events"));
    }


    @Test
    public void loginExitByCancelTest() {
        loginPage.waitUntilPageIsLoaded(By.id("signinrequest"), 30);
        loginPage.closeLoginWindowByX();
        Assert.assertTrue(homePage.correctPageIsLoaded(By.id("idtitletypesearchevents"), "List events"));
    }

}
