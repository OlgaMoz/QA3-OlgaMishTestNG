package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePageHelper extends PageBase {

    @FindBy(id = "idsignin")
    WebElement loginIcon;

    @FindBy(xpath = "//div[@class = 'itemEventInsert']")
    List<WebElement> eventsList;

    @FindBy(id = "idtitletypesearchevents")
    WebElement listEvent;

    @FindBy(name = "selectholidays")
    WebElement filterHolidays;

    @FindBy(name = "selectfood")
    WebElement filterFood;

    @FindBy(name = "selectlangues")
    WebElement filterLanguages;

    @FindBy (id = "idbtnclearfilter")
    WebElement clearFilterButton;

    @FindBy (css  = ".holidayItemEvents")
    List<WebElement> listHolidaysHoliday;

    @FindBy (xpath = "//i[@class='fa fa-cutlery']/..")
    List<WebElement> listHolidaysFood;

    @FindBy (xpath = "//i[@class='fa fa-globe']/..")
    List<WebElement> listHolidaysLanguage;

    @FindBy (xpath = "//select[@name = 'selectholidays']/option")
    List<WebElement> optionsHolidays;

    @FindBy (xpath = "//select[@name='selectfood']/option")
    List<WebElement> optionsFood;

    @FindBy (xpath = "//select[@name='selectlangues']/option")
    List<WebElement> optionsLanguage;

    @FindBy(xpath = "//option[@selected][@value = 'Shabbat']")
    WebElement chosenFilterHolidays;

    @FindBy(xpath = "//option[@selected][@value = 'Kosher']")
    WebElement chosenFilterFood;

    @FindBy(xpath = "//option[@selected][@value = 'English']")
    WebElement chosenFilterLanguage;

    public HomePageHelper(WebDriver driver) {
        super(driver);
    }

    public HomePageHelper waitUntilHomePageIsLoaded(){
        waitUntilPageIsLoaded(loginIcon,20);
        return this;
    }

    public boolean correctHomePageIsLoaded(){
        return correctPageIsLoaded(listEvent, "List events");
    }

    public boolean userIsNotLoggedIn(){
        return correctPageIsLoaded(loginIcon, "Login");
    }

    public boolean getAllHolidaysValuesForAllEventsChosenByFilterShabbat(){
        return getAllHolidaysValuesForAllEventsChosenByFilter(listHolidaysHoliday, "Shabbat");
    }

    public boolean getAllHolidaysValuesForAllEventsChosenByFilterKosher() {
        return getAllHolidaysValuesForAllEventsChosenByFilter(listHolidaysFood,"Kosher");
    }

    public boolean getAllHolidaysValuesForAllEventsChosenByFilterEnglish() {
       return getAllHolidaysValuesForAllEventsChosenByFilter(listHolidaysLanguage,"English");
    }

    public HomePageHelper waitThatFilterByHolidayAndAllOptionsAreLoaded() throws InterruptedException {
        waitThatFilterAndAllOptionsAreLoaded(filterHolidays, optionsHolidays);
        return this;
    }

    public HomePageHelper waitThatFilterByFoodAndAllOptionsAreLoaded() throws InterruptedException {
        waitThatFilterAndAllOptionsAreLoaded(filterFood, optionsFood);
        return this;
    }

    public HomePageHelper waitThatFilterByLanguageAndAllOptionsAreLoaded() throws InterruptedException {
        waitThatFilterAndAllOptionsAreLoaded(filterLanguages, optionsLanguage);
        return this;
    }

    public HomePageHelper getSelectElementFilterByHoliday() throws InterruptedException {
        getSelectElementFilterBy(filterHolidays, "Shabbat", optionsHolidays);
        return this;
    }

    public HomePageHelper getSelectElementFilterByFood() throws InterruptedException {
        getSelectElementFilterBy(filterFood, "Kosher", optionsFood);
        return this;
    }

    public HomePageHelper getSelectElementFilterByLanguage() throws InterruptedException {
        getSelectElementFilterBy(filterLanguages, "English", optionsLanguage);
        return this;
    }

    public HomePageHelper waitThatFilterHolidayIsChosenAndAllEventsByFilterAreLoaded() {
        waitThatFilterIsChosenAndAllEventsByFiterAreLoaded(chosenFilterHolidays);
        return this;
    }

    public HomePageHelper waitThatFilterFoodIsChosenAndAllEventsByFilterAreLoaded() {
        waitThatFilterIsChosenAndAllEventsByFiterAreLoaded(chosenFilterFood);
        return this;
    }

    public HomePageHelper waitThatFilterLanguageIsChosenAndAllEventsByFilterAreLoaded() {
        waitThatFilterIsChosenAndAllEventsByFiterAreLoaded(chosenFilterLanguage);
        return this;
    }

    public HomePageHelper verifyTheStatusClearButton() {

        System.out.println("is displayed: " + clearFilterButton.isDisplayed());
        System.out.println("is enabled: " + clearFilterButton.isEnabled());
        return this;
    }
}
