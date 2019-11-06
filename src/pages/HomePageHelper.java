package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class HomePageHelper extends PageBase {

    public HomePageHelper(WebDriver driver) {
        super(driver);
    }

    public void waitUntilHomePageIsLoaded(){
        waitUntilPageIsLoaded(By.id("idsignin"),20);
    }

    public Boolean correctHomePageIsLoaded(){
        return correctPageIsLoaded(By.id("idtitletypesearchevents"), "List events");
    }

    public Boolean userIsNotLoggedIn(){
        return correctPageIsLoaded(By.id("idsignin"), "Login");
    }

    public boolean getAllHolidaysValuesForAllEventsChosenByFilterShabbat(){
        return getAllHolidaysValuesForAllEventsChosenByFilter(By.cssSelector(".holidayItemEvents"), "Shabbat");
    }

    public boolean getAllHolidaysValuesForAllEventsChosenByFilterKosher() {
        return getAllHolidaysValuesForAllEventsChosenByFilter(By.xpath("//i[@class='fa fa-cutlery']/.."),
                "Kosher");
    }

    public boolean getAllHolidaysValuesForAllEventsChosenByFilterEnglish() {
       return getAllHolidaysValuesForAllEventsChosenByFilter(By.xpath("//i[@class='fa fa-globe']/.."),"English");
    }

    public void waitThatFilterByHolidayAndAllOptionsAreLoaded() throws InterruptedException {
        waitThatFilterAndAllOptionsAreLoaded(By.name("selectholidays"),
                By.xpath("//select[@name = 'selectholidays']/option"));
    }

    public void waitThatFilterByFoodAndAllOptionsAreLoaded() throws InterruptedException {
        waitThatFilterAndAllOptionsAreLoaded(By.name("selectfood"),
                By.xpath("//select[@name='selectfood']/option"));
    }

    public void waitThatFilterByLanguageAndAllOptionsAreLoaded() throws InterruptedException {
        waitThatFilterAndAllOptionsAreLoaded(By.name("selectlangues"),
                By.xpath("//select[@name='selectlangues']/option"));
    }

    public void getSelectElementFilterByHoliday() throws InterruptedException {
        getSelectElementFilterBy(By.name("selectholidays"), "Shabbat",
                By.xpath("//select[@name = 'selectholidays']/option"));
    }

    public void getSelectElementFilterByFood() throws InterruptedException {
        getSelectElementFilterBy(By.name("selectfood"), "Kosher",
                By.xpath("//select[@name = 'selectfood']/option"));
    }

    public void getSelectElementFilterByLanguage() throws InterruptedException {
        getSelectElementFilterBy(By.name("selectlangues"), "English",
                By.xpath("//select[@name = 'selectlangues']/option"));
    }

    public void waitThatFilterHolidayIsChosenAndAllEventsByFilterAreLoaded() {
        waitThatFilterIsChosenAndAllEventsByFiterAreLoaded(By.xpath("//option[@selected][@value = 'Shabbat']"));
    }

    public void waitThatFilterFoodIsChosenAndAllEventsByFilterAreLoaded() {
        waitThatFilterIsChosenAndAllEventsByFiterAreLoaded(By.xpath
                ("//option[@selected][@value = 'Kosher']"));
    }

    public void waitThatFilterLanguageIsChosenAndAllEventsByFilterAreLoaded() {
        waitThatFilterIsChosenAndAllEventsByFiterAreLoaded(
                By.xpath("//option[@selected][@value = 'English']"));
    }

    public void verifyTheStatusClearButton() {

        System.out.println("is displayed: " + driver
                .findElement(By.cssSelector("#idbtnclearfilter")).isDisplayed());
        System.out.println("is enabled: " + driver
                .findElement(By.cssSelector("#idbtnclearfilter")).isEnabled());
    }
}
