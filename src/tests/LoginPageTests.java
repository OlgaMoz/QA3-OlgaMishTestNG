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

        homePage.waitUntilHomePageIsLoaded();
        loginPage.openLoginPage();
        loginPage.waitUntilLoginPageIsLoaded();
    }

    @Test
    public void loginPositiveTest() {

        loginPage.initLoginTests(LOGIN, PASSWORD);
        homePageAuth.waitUntilHomePageAuthIsLoaded();
        Assert.assertTrue(homePageAuth.correctAuthorizationIsEnded());

    }

    @Test
    public void loginNegativeTest() {
        loginPage.initLoginTests(LOGIN, LOGIN);
        Assert.assertTrue(loginPage.loginToTheSystemIncorrect());
        loginPage.closeLoginWindowByX();
        Assert.assertTrue(homePage.correctHomePageIsLoaded());
    }


    @Test
    public void loginExitByCancelTest() {
        loginPage.waitUntilLoginPageIsLoaded();
        loginPage.closeLoginWindowByX();
        Assert.assertTrue(homePage.correctHomePageIsLoaded()&homePage.userIsNotLoggedIn());
    }

}
