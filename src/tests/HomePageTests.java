package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePageAuthHelper;
import pages.HomePageHelper;
import pages.LoginPageHelper;

import java.util.List;

public class HomePageTests extends TestBase{
    HomePageHelper homePage;
    LoginPageHelper loginPage;
    HomePageAuthHelper homePageAuth;

    @BeforeMethod
    public void initTests() {
        homePage = new HomePageHelper(driver);
        loginPage = new LoginPageHelper(driver);
        homePageAuth = new HomePageAuthHelper(driver);

        homePage.waitUntilPageIsLoaded(By.id("idsignin"),20);
    }

    @Test
    public void homePageVerificationTest() {
        //-----------------------"List events element exists: " -----------------------------------------
        Assert.assertTrue(homePage.correctPageIsLoaded(By.id("idtitletypesearchevents"), "List events"));
        //-----------------------"Login Icon exists: "-----------------------------------------
        Assert.assertTrue(homePage.correctPageIsLoaded(By.id("idsignin"), "Login"));
    }

    @Test(enabled = true)
    public void singleFilterHolidays(){
        // ----- to wait that select-element (filter by holiday) and all options are loaded ---
        homePage.waitThatFilterAndAllOptionsAreLoaded(By.name("selectholidays"),
                By.xpath("//select[@name = 'selectholidays']/option"));
        // --- verify states "clear" button ----
        homePage.verifyTheStatusClearButton();
        // --- get select-element (filter by holiday)
        homePage.getSelectElementFilterBy(By.name("selectholidays"), "Shabbat",
                By.xpath("//select[@name = 'selectholidays']/option"));

        // ------ wait that filter "shabbat" is chosen -----
        // ------ wait that all events by fiter "shabbat" are loaded ----
        homePage.waitThatFilterIsChosenAndAllEventsByFiterAreLoaded(By.xpath("//option[@selected][@value = 'Shabbat']"));

        // ------ get all holidays values for all events chosen by filter "Shabbat"
        homePage.getAllHolidaysValuesForAllEventsChosenByFilter(By.cssSelector(".holidayItemEvents"), "Shabbat");
    }

    @Test(enabled = true)
    public void singleFilterFood() {
        // ----- to wait that select-element (filter by food) and all options are loaded ---
        homePage.waitThatFilterAndAllOptionsAreLoaded(By.name("selectfood"),
                By.xpath("//select[@name='selectfood']/option"));
        // --- verify states "clear" button ----
        homePage.verifyTheStatusClearButton();
        // --- get select-element (filter by food)
        homePage.getSelectElementFilterBy(By.name("selectfood"), "Kosher",
                By.xpath("//select[@name = 'selectfood']/option"));
        // ------ wait that filter "shabbat" is chosen -----
        // ------ wait that all events by fiter "Kosher" are loaded ----
        homePage.waitThatFilterIsChosenAndAllEventsByFiterAreLoaded(By.xpath
                ("//option[@selected][@value = 'Kosher']"));

        // ------ get all holidays values for all chosen by filter "Kosher"-food
        homePage.getAllHolidaysValuesForAllEventsChosenByFilter(By.xpath("//i[@class='fa fa-cutlery']/.."),
                "Kosher");
        //------------------------------------------------------------------------------------------------------
    }

    @Test(enabled = true)
    public void singleFilterLanguage() {
        // ----- to wait that select-element (filter by language) and all options are loaded ---
        homePage.waitThatFilterAndAllOptionsAreLoaded(By.name("selectlangues"),
                By.xpath("//select[@name='selectlangues']/option"));
        // --- verify states "clear" button ----
        homePage.verifyTheStatusClearButton();
        // --- get select-element (filter by language)
        // ------ choose filter "English" ------
        homePage.getSelectElementFilterBy(By.name("selectlangues"), "English",
                By.xpath("//select[@name = 'selectlangues']/option"));
//----------------------------------------------------------------------------------------------
        // ------ wait that filter "English" is chosen -----
        // ------ wait that all events by fiter "English" are loaded ----
        homePage.waitThatFilterIsChosenAndAllEventsByFiterAreLoaded(
                By.xpath("//option[@selected][@value = 'English']"));
        // ------ get all holidays values for all chosen by filter "English"-language
        //------------------------------------------------------------------------------------------------------
        homePage.getAllHolidaysValuesForAllEventsChosenByFilter(By.xpath("//i[@class='fa fa-globe']/.."),"English");
    }

}
