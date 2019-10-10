package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class WebHomePageTests extends TestBase{

    @Test
    public void webHomePageTest()  {

        WebElement eventList = driver.findElement(By.id("idtitletypesearchevents"));

       // System.out.println("List events element exists: " + eventList.getText().equals("List events"));
        Assert.assertEquals(eventList.getText(), "List events",
                "There is no element named \"List events\" on the page");
        WebElement loginIcon = driver.findElement(By.id("idsignin"));
        //System.out.println("Login Icon exists: " + loginIcon.getText().equals("Login"));
        Assert.assertEquals(loginIcon.getText(), "Login");
    }

    @Test(enabled = false)
    public void homePageVerificationTest()  {

        // ------ Find list events element ----
        WebElement listEvent
                = driver.findElement(By.id("idtitletypesearchevents"));
        //--Verify that listEvent elements contains 'list events' text

        Assert.assertEquals(listEvent.getText(),"List events",
                "Name of the listEvent element is not 'List events'");

    }

    @Test(enabled = true)
    public void singleFilterHolidays(){
        // ----- to wait that select-element (filter by holiday) and all options are loaded ---
        waitUntilElementIsVisible(By.name("selectholidays"),30);
        waitUntilAllElementsVisible(driver
                .findElements(By.xpath("//select[@name = 'selectholidays']/option")),30);
        // --- get select-element (filter by holiday)
       // WebElement holidaysFilter = driver
            //   .findElement(By.name("selectholidays"));
        // --- verify states "clear" button ----
        System.out.println("is displayed: " + driver
                .findElement(By.xpath("//div[@id='idbtnclearfilter']")).isDisplayed());
        System.out.println("is enabled: " + driver
                .findElement(By.xpath("//div[@id='idbtnclearfilter']")).isEnabled());

        // --- get select-element (filter by holiday)
        WebElement holidaysFilter = driver
               .findElement(By.name("selectholidays"));
        // ------ choose filter "shabbat" ------
        waitUntilElementIsClickable(By.name("selectholidays"), 90);
        Select selector = new Select(holidaysFilter);
        waitUntilElementIsClickable(By.name("selectholidays"), 100);
        waitUntilAllElementsVisible(driver
               .findElements(By.xpath("//select[@name = 'selectholidays']/option")),90);
        selector.selectByValue("Shabbat");

        // ------ wait that filter "shabbat" is chosen -----
        waitUntilElementIsClickable(By
                .xpath("//div[@id='idbtnclearfilter']"),20);
        waitUntilElementIsPresent(By
                .xpath("//option[@selected][@value = 'Shabbat']"),20);
        // ------ wait that all events by fiter "shabbat" are loaded ----
        waitUntilAllElementsVisible(driver.findElements(By
                .xpath("//div[@class = 'itemEventInsert']")),40);

        // ------ get all holidays values for all chosen by filter "Shabbat" events

        //------------------------------------------------------------------------------------------------------
        List<WebElement> listHolidays = driver.findElements(By.xpath("//div[@class = 'holidayItemEvents']"));

        // --- verify that all holidays values are "Shabbat" ----
        int counter = 0;
        for (int i=0; i < listHolidays.size(); i++){
            if (listHolidays.get(i).getText().equals("Shabbat")) counter++;
        }
        Assert.assertEquals(counter, listHolidays.size());
        //------------------------------------------------------------------------------------------------------
    }

    @Test(enabled = false)
    public void singleFilterFood() {
        waitUntilElementIsVisible(By.xpath("//select[@name='selectfood']"), 30);
        waitUntilAllElementsVisible(driver.findElements(By.xpath("//select[@name='selectfood']/option")), 30);
        // --- verify states "clear" button ----
        System.out.println("is displayed: " + driver
                .findElement(By.xpath("//div[@id='idbtnclearfilter']")).isDisplayed());
        System.out.println("is enabled: " + driver
                .findElement(By.xpath("//div[@id='idbtnclearfilter']")).isEnabled());
        // --- get select-element (filter by food)
        WebElement holidaysFilter = driver
                .findElement(By.name("selectfood"));
        // ------ choose filter "Kosher" ------
        waitUntilElementIsClickable(By.name("selectfood"), 90);
        Select selector = new Select(holidaysFilter);
        waitUntilElementIsClickable(By.name("selectfood"), 100);
        waitUntilAllElementsVisible(driver
                .findElements(By.xpath("//select[@name = 'selectfood']/option")),90);
        selector.selectByValue("Kosher");
        // ------ wait that filter "shabbat" is chosen -----
        waitUntilElementIsClickable(By
                .xpath("//div[@id='idbtnclearfilter']"),20);
        waitUntilElementIsPresent(By
                .xpath("//option[@selected][@value = 'Kosher']"),20);
        // ------ wait that all events by fiter "Kosher" are loaded ----
        waitUntilAllElementsVisible(driver.findElements(By
                .xpath("//div[@class = 'itemEventInsert']")),40);

        // ------ get all holidays values for all chosen by filter "Kosher"-food
        //-------------ДОДЕЛАТЬ!-------------------------
        //------------------------------------------------------------------------------------------------------
        /*List<WebElement> listHolidaysByChosenFood = driver.findElements(By.className("itemEvent"));

        // --- verify that all holidays values are "Shabbat" ----
        int counter = 0;
        for (int i=0; i < listHolidaysByChosenFood.size(); i++){
            //if (listHolidaysByChosenFood.get(i).getText().equals("Shabbat")) counter++;
            if (listHolidaysByChosenFood.get(i).findElement(By.xpath("")).getText().equals("Shabbat")) counter++;
        }
        Assert.assertEquals(counter, listHolidaysByChosenFood.size());*/
        //------------------------------------------------------------------------------------------------------
    }

}
