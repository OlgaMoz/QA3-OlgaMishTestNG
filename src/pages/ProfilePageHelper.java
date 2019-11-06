package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProfilePageHelper extends PageBase {

    public ProfilePageHelper(WebDriver driver) {
        super(driver);
    }

    public void openProfilePage() {
        waitUntilElementIsClickable(By.id("profile"), 30);
        openElementById("profile");
        waitUntilElementIsVisible(By.id("idfamilyinfoimg"), 50);
    }

    public String[] saveDataFromTheProfilePage() {
        waitUntilElementIsVisible(By.cssSelector(".itemprofilefit #fieldobjconfession"), 40);
        String[] array;
        //  array1 = new String[6];
        Boolean familySign;
        familySign = true;
        array = saveDataFromTheProfileOrFamilyPage(familySign);
        return array;
    }

    public String saveProfile() {
        String profileFamilyName;
        waitUntilElementIsClickable(By.xpath("//div[@id='idbtnsaveprofile']"), 40);
        driver.findElement(By.xpath("//div[@id='idbtnsaveprofile']")).click();
        waitUntilElementIsVisible(By.id("idbtneditprofile"), 30);

        waitUntilElementIsVisible(By.xpath("//span[@id='fieldobjfamilyName']"), 50);
        profileFamilyName =driver.findElement(By.xpath("//span[@id='fieldobjfamilyName']")).getText();
        System.out.println("Family Name in the profile: " + profileFamilyName);
        return profileFamilyName;
    }

    public void changeLastName(String lastName) throws InterruptedException {
        openElementById("idbtneditprofile");
        waitUntilElementIsVisible(By.id("helpselectinfoinprofile"), 50);

        WebElement lastNameField = driver.findElement(By.xpath("//span[@id='fieldobjfamilyName']//input"));
        waitUntilElementIsPresent(By
                .xpath("//span[@id='fieldobjfamilyName']//input"),20);
        lastNameField.click();

        lastNameField.clear();
        lastNameField.sendKeys(lastName);
        Thread.sleep(7000);
    }
    public String newLastNameGeneration() {
        waitUntilElementIsClickable(By.id("fieldobjfamilyName"), 50);

        String profileFamilyName =driver.findElement(By.xpath("//span[@id='fieldobjfamilyName']")).getText();
        System.out.println("profileFamilyName: " + profileFamilyName);
        String lastName;
        lastName = "Shapiro";
        if(!(profileFamilyName.equals("Abramov"))) {lastName = "Abramov";}
        System.out.println("lastName new: " + lastName);
        return lastName;
    }

    public Boolean comparingProfileAndFamilyPage(String[] arrayProfile, String[] arrayFamily) {
        System.out.println("Profile confession: " + arrayProfile[0]);
        System.out.println("Family confession: " + arrayFamily[0]);
        Boolean signOfTruth = arrayProfile[0].equals(arrayFamily[0]);
        System.out.println("Confession of the profile is equivalent to confession of the family: "
                + signOfTruth);

        System.out.println("Profile language: " + arrayProfile[1]);
        System.out.println("Family language: " + arrayFamily[1]);
        signOfTruth = signOfTruth&arrayProfile[1].equals(arrayFamily[1]);
        System.out.println("Language of the profile is equivalent to language of the family: "
                + signOfTruth);

        System.out.println("Profile Food preference: " + arrayProfile[2]);
        System.out.println("Family Food preference: " + arrayFamily[2]);
        signOfTruth = signOfTruth&arrayProfile[2].equals(arrayFamily[2]);
        System.out.println("Food preference of the profile is equivalent to food preference of the family: "
                + signOfTruth);

        System.out.println("Profile Email: " + arrayProfile[3]);
        System.out.println("Family Email: " + arrayFamily[3]);
        signOfTruth = signOfTruth&arrayProfile[3].equals(arrayFamily[3]);
        System.out.println("Email of the profile is equivalent to email of the family: "
                + signOfTruth);

        System.out.println("Profile Last Name: : " + arrayProfile[4]);
        System.out.println("Family Last Name: : " + arrayFamily[4]);
        signOfTruth = signOfTruth&arrayFamily[4].contains(arrayProfile[4]);
        System.out.println("The family name of the profile is equivalent to the last name of the family: "
                + signOfTruth);

        System.out.println("Profile Family Description: " + arrayProfile[5]);
        System.out.println("Family Family Description: " + arrayFamily[5]);
        signOfTruth = signOfTruth&arrayProfile[5].equals(arrayFamily[5]);
        System.out.println("Family description of the profile is equivalent to family description of the family: "
                + signOfTruth);

        return signOfTruth;
    }
}
