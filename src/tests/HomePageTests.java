package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class HomePageTests extends TestBase {
    @Test
    public void homePageVerificationTest(){

        // ------ Find list events element ----
        WebElement listEvent
                = driver.findElement(By.id("idtitletypesearchevents"));
        //--Verify that listEvent elements contains 'list events' text
        System.out.println("Home Page Verification:"
                + listEvent.getText().equals("List events"));
        //System.out.println(listEvent.getAttribute("class"));

    }

}
