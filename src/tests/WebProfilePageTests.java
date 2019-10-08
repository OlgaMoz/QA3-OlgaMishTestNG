package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WebProfilePageTests extends TestBase{

    @BeforeMethod
    public void startWorkProfilePage() throws InterruptedException {
        initLoginTests(LOGIN, PASSWORD);
        waitUntilElementIsClickable(By.id("profile"), 30);
        openElementById("profile");
        waitUntilElementIsVisible(By.id("idfamilyinfoimg"), 50);
    }

    @Test
    public void lastNameOfFamilyChanging() throws InterruptedException {

        //----------------New last name---------------------
       // Thread.sleep(5000);
      // waitUntilElementIsVisible(By.id("fieldobjfamilyName"), 50);
       waitUntilElementIsClickable(By.id("fieldobjfamilyName"), 50);

       // new WebDriverWait(driver, 40).until(ExpectedConditions.presenceOfElementLocated(By.id("fieldobjfamilyName")));
       // new WebDriverWait(driver, 40).until(ExpectedConditions.presenceOfElementLocated(By.id("fieldobjfamilyName")));
        String profileFamilyName =driver.findElement(By.xpath("//span[@id='fieldobjfamilyName']")).getText();
        System.out.println("profileFamilyName: " + profileFamilyName);
        String lastName;
        lastName = "Shapiro";
        if(!(profileFamilyName.equals("Abramov"))) {lastName = "Abramov";}
        System.out.println("lastName new: " + lastName);
        //-------------- Open in edit mode ----------------------
        openElementById("idbtneditprofile");
        waitUntilElementIsVisible(By.id("helpselectinfoinprofile"), 50);

        WebElement lastNameField = driver.findElement(By.xpath("//span[@id='fieldobjfamilyName']//input"));
      /*  new WebDriverWait(driver, 40).
                until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@id='fieldobjfamilyName']//input")));*/
       waitUntilElementIsPresent(By
                .xpath("//span[@id='fieldobjfamilyName']//input"),20);
        lastNameField.click();
       // Thread.sleep(5000);
        lastNameField.clear();
        lastNameField.sendKeys(lastName);
       // Thread.sleep(5000);

        //-----------------Save profile---------------------
        waitUntilElementIsClickable(By.xpath("//div[@id='idbtnsaveprofile']"), 40);
        driver.findElement(By.xpath("//div[@id='idbtnsaveprofile']")).click();
        waitUntilElementIsVisible(By.id("idbtneditprofile"), 30);
      //  Thread.sleep(5000);
        waitUntilElementIsVisible(By.xpath("//span[@id='fieldobjfamilyName']"), 50);
        profileFamilyName =driver.findElement(By.xpath("//span[@id='fieldobjfamilyName']")).getText();
        System.out.println("Family Name in the profile: " + profileFamilyName);

        Assert.assertEquals(profileFamilyName,lastName, "Last name not preserved.");
    }
    @Test
    public void webProfileAndFamilyPageComparing() throws InterruptedException {
       /* initLoginTests(LOGIN,PASSWORD);
        //---------------Go to the Profile Page -----------------
        openElementById("profile");*/
        waitUntilElementIsVisible(By.xpath("//span[@id='fieldobjconfession']"), 30);
       // Thread.sleep(5000);
        //---------------Save data from the Profile page-------------
        String profileConfession = driver.findElement(By.xpath("//span[@id='fieldobjconfession']")).getText();
        System.out.println("Profile confession: " + profileConfession);

        String profileLanguage = driver.findElement(By.cssSelector("#fieldobjlanguages")).getText();
        System.out.println("Profile Language: " + profileLanguage);

        String profileFoodPreference = driver.findElement(By.xpath("//*[@id='fieldobjfoodPreferences']")).getText();
        System.out.println("Profile Food Preference: " + profileFoodPreference);

        String profileEmail = driver.findElement(By.cssSelector("#fieldobjelMail")).getText();
        System.out.println("Email in the profile: " + profileEmail);

        String profileFamilyName =driver.findElement(By.xpath("//span[@id='fieldobjfamilyName']")).getText();
        System.out.println("Family Name in the profile: " + profileFamilyName);

        String profileFamilyDescription = driver.findElement(By.xpath
                ("//div[@class= 'itemprofilearea']/span[@id='fieldobjfamilyDescription']")).getText();
        System.out.println("Profile family description: " + profileFamilyDescription);
        //Thread.sleep(10000);

        //---------------Go to the Family Page -----------------
        //openElementById("family", 3000);
        waitUntilElementIsClickable(By.id("family"), 60);
        openElementById("family");
      //  Thread.sleep(5000);
       // waitUntilElementIsClickable(By.id("idnameuserinfamily"), 70);
        //----------------------Comparing--------------------------
        waitUntilElementIsVisible(By.cssSelector(".itemprofilefit #fieldobjconfession"), 40);
        String familyConfession = driver.findElement(
                By.cssSelector(".itemprofilefit #fieldobjconfession")).getText();
        System.out.println("Family confession: " + familyConfession);
        System.out.println("Confession of the profile is equivalent to confession of the family: "
                + profileConfession.equals(familyConfession));
        Boolean signOfTruth = profileConfession.equals(familyConfession);

        String familyLanguage = driver.findElement(
                By.xpath("//div[@class='row myrow']//span[@id='fieldobjlanguages']")).getText();
        System.out.println("Family language: " + familyLanguage);
        System.out.println("Language of the profile is equivalent to language of the family: "
                + profileLanguage.equals(familyLanguage));
        signOfTruth = signOfTruth&profileLanguage.equals(familyLanguage);

        String familyFoodPreference = driver.findElement(
                By.cssSelector(".itemprofilefit #fieldobjfoodPreferences")).getText();
        System.out.println("Family food preference: " + familyFoodPreference);
        System.out.println("Food preference of the profile is equivalent to food preference of the family: "
                + profileFoodPreference.equals(familyFoodPreference));
        signOfTruth=signOfTruth&profileFoodPreference.equals(familyFoodPreference);

        String familyEmail = driver.findElement(
                By.xpath("//div[@class='itemprofilefit']//span[@id='fieldobjelMail']")).getText();
        System.out.println("Family Email: " + familyEmail);
        System.out.println("Email of the profile is equivalent to email of the family: "
                + profileEmail.equals(familyEmail));
        signOfTruth=signOfTruth&profileEmail.equals(familyEmail);

        String familyLastName = driver.findElement(By.cssSelector(".formscroll #titleprofile")).getText();
        System.out.println("Family Last Name: " + familyLastName);
        System.out.println("The family name of the profile is equivalent to the last name of the family:"
                + familyLastName.contains(profileFamilyName));
        signOfTruth=signOfTruth&familyLastName.contains(profileFamilyName);

        String familyFamilyDescription = driver.findElement(
                By.xpath("//span[@id='fieldobjfamilyDescription']")).getText();
        System.out.println("Family Family Description: " + familyFamilyDescription);
        System.out.println("Family description of the profile is equivalent to family description of the family: "
                + profileFamilyDescription.equals(familyFamilyDescription));
        signOfTruth=signOfTruth&profileFamilyDescription.equals(familyFamilyDescription);

        Assert.assertTrue(signOfTruth);
    }

}
