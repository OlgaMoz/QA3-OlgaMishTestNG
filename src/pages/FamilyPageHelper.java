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

    public void openFamilyProfilePage() {
        waitUntilElementIsClickable(By.id("family"), 30);
        openElementById("family");
        waitUntilElementIsVisible(By.id("fieldobjconfession"), 50);
    }

    public String[] saveDataFromTheFamilyPage() {
        String[] array;
        //  array1 = new String[6];
        Boolean familySign;
        familySign = false;
        array = saveDataFromTheProfileOrFamilyPage(familySign);
        return array;
    }
}
