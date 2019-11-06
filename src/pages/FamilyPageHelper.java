package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class FamilyPageHelper extends PageBase {

    public FamilyPageHelper(WebDriver driver) {
        super(driver);
    }

    public void waitUntilFamilyPageIsExist() {
        waitUntilPageIsLoaded(By.id("family"), 60);
    }

}
