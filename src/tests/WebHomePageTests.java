package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

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
}
