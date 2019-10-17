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

    public void waitThatFilterAndAllOptionsAreLoaded(By locator1, By locator2) {


        waitUntilElementIsVisible(locator1,100);
        waitUntilAllElementsVisible(driver
                .findElements(locator2),90);
    }


    public void getSelectElementFilterBy(By locator1, String name, By locator2) {
        WebElement holidaysFilter = driver
                .findElement(locator1);
        // ------ choose filter "shabbat" ------
        waitUntilElementIsClickable(locator1, 90);
        Select selector = new Select(holidaysFilter);
        waitThatFilterAndAllOptionsAreLoaded(locator1, locator2);
        selector.selectByValue(name);
    }

    public void waitThatFilterIsChosenAndAllEventsByFiterAreLoaded(By locator) {
        waitUntilElementIsClickable(By.cssSelector("#idbtnclearfilter"),20);
        waitUntilElementIsPresent(locator,20);
        // ------ wait that all events by fiter "shabbat" are loaded ----
        waitUntilAllElementsVisible(driver.findElements(By
                .xpath("//div[@class = 'itemEventInsert']")),40);
    }

    public void getAllHolidaysValuesForAllEventsChosenByFilter(By locator, String name) {

        List<WebElement> listHolidays = driver.findElements(locator);

        // --- verify that all holidays values are "Shabbat" ----
        int counter = 0;
        for (int i=0; i < listHolidays.size(); i++){
            System.out.println("Filter: " + listHolidays.get(i).getText());
            if (listHolidays.get(i).getText().contains(name)) counter++;
        }
        Assert.assertEquals(counter, listHolidays.size());
    }
    public void verifyTheStatusClearButton() {

        System.out.println("is displayed: " + driver
                .findElement(By.cssSelector("#idbtnclearfilter")).isDisplayed());
        System.out.println("is enabled: " + driver
                .findElement(By.cssSelector("#idbtnclearfilter")).isEnabled());
    }

    public void filterEventsByHolidayShabbat() {
        // ----- to wait that select-element (filter by holiday) and all options are loaded ---
        waitUntilElementIsVisible(By.name("selectholidays"),30);
        waitUntilAllElementsVisible(driver
                .findElements(By.xpath("//select[@name = 'selectholidays']/option")),30);
        // --- get select-element (filter by holiday)
        WebElement holidaysFilter = driver
                .findElement(By.name("selectholidays"));
        // --- verify states clear button ----
        System.out.println("is displayed: " + driver
                .findElement(By.xpath("//div[@id='idbtnclearfilter']")).isDisplayed());
        System.out.println("is enabled: " + driver
                .findElement(By.xpath("//div[@id='idbtnclearfilter']")).isEnabled());

        // ------ choose filter "shabbat" ------
        Select selector = new Select(holidaysFilter);
        selector.selectByValue("Shabbat");

        // ------ wait that filter "shabbat" is chosen -----
        waitUntilElementIsClickable(By
                .xpath("//div[@id='idbtnclearfilter']"),20);
        waitUntilElementIsPresent(By
                .xpath("//option[@selected][@value = 'Shabbat']"),20);
        // ------ wait that all events by fiter "shabbat" are loaded ----
        waitUntilAllElementsVisible(driver.findElements(By
                .xpath("//div[@class = 'itemEventInsert']")),40);


    }

    public Boolean allEventsBelongToHolidayShabbat() {
        // ------ get all holidays values for all chosen by filter "Shabbat" events
        List<WebElement> listHolidays = driver.findElements(By.xpath("//div[@class = 'holidayItemEvents']"));

        // --- verify that all holidays values are "Shabbat" ----
        int counter = 0;
        for (int i=0; i < listHolidays.size(); i++){
            if (listHolidays.get(i).getText().equals("Shabbat")) counter++;
        }
        return counter == listHolidays.size();
    }
}
