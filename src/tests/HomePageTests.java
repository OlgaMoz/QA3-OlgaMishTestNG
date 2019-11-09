package tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePageAuthHelper;
import pages.HomePageHelper;
import pages.LoginPageHelper;

public class HomePageTests extends TestBase{
    HomePageHelper homePage;
    HomePageAuthHelper homePageAuth;

    @BeforeMethod
    public void initTests() {
        homePage = new HomePageHelper(driver);
        homePageAuth = new HomePageAuthHelper(driver);

        homePageAuth = PageFactory.initElements(driver, HomePageAuthHelper.class);
        homePage = PageFactory.initElements(driver, HomePageHelper.class);

        homePage.waitUntilHomePageIsLoaded();


    }

    @Test
    public void homePageVerificationTest() {
        //-----------------------"List events element exists: " -----------------------------------------
        Assert.assertTrue(homePage.correctHomePageIsLoaded());
        //-----------------------"Login Icon exists: "-----------------------------------------
        Assert.assertTrue(homePage.userIsNotLoggedIn());
    }

    @Test(enabled = true)
    public void singleFilterHolidays() throws InterruptedException {

        homePage.waitThatFilterByHolidayAndAllOptionsAreLoaded();

        homePage.verifyTheStatusClearButton();

        homePage.getSelectElementFilterByHoliday();

        homePage.waitThatFilterHolidayIsChosenAndAllEventsByFilterAreLoaded();

        Assert.assertTrue(homePage.getAllHolidaysValuesForAllEventsChosenByFilterShabbat());

    }

    @Test(enabled = true)
    public void singleFilterFood() throws InterruptedException {

        homePage.waitThatFilterByFoodAndAllOptionsAreLoaded();

        homePage.verifyTheStatusClearButton();

        homePage.getSelectElementFilterByFood();

        homePage.waitThatFilterFoodIsChosenAndAllEventsByFilterAreLoaded();

        Assert.assertTrue(homePage.getAllHolidaysValuesForAllEventsChosenByFilterKosher());
    }

    @Test(enabled = true)
    public void singleFilterLanguage() throws InterruptedException {

        homePage.waitThatFilterByLanguageAndAllOptionsAreLoaded();

        homePage.verifyTheStatusClearButton();

        homePage.getSelectElementFilterByLanguage();

        homePage.waitThatFilterLanguageIsChosenAndAllEventsByFilterAreLoaded();

        Assert.assertTrue(homePage.getAllHolidaysValuesForAllEventsChosenByFilterEnglish());
    }

}
