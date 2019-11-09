package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FamilyPageHelper extends PageBase {

    @FindBy(id = "family")
    WebElement familyIcon;

    @FindBy(id = "fieldobjconfession")
    WebElement confessionField;

    public FamilyPageHelper(WebDriver driver) {
        super(driver);
    }

   /* public void openFamilyProfilePage() {
        openPage("family", By.id("fieldobjconfession"));
    }*/
    public void openFamilyProfilePage() {
        openPage(familyIcon, confessionField);
    }

    public String[] saveDataFromTheFamilyPage() {
        String[] array;
        Boolean familySign;
        familySign = false;
        array = saveDataFromTheProfileOrFamilyPage(familySign);
        return array;
    }
}
