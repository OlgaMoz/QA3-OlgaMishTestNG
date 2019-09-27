package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class ProfilePageTests extends TestBase{

    @Test
    public void lastNameOfFamilyChanging() throws InterruptedException {

        //-------------Login--------------
        initLoginTestsStart();
        initLoginTestsEnd(LOGIN, PASSWORD);
        //---------------Go to the Profile Page -----------------
        openElementById("profile", 3000);
        //-------------- Open in edit mode ----------------------
        openElementById("idbtneditprofile", 5000);
        //----------------New last name---------------------
        WebElement lastNameField = driver.findElement(By.xpath("//span[@id='fieldobjfamilyName']//input"));
        // WebElement lastNameField = driver.findElement(By.id("fieldobjfamilyName"));
        lastNameField.click();
        lastNameField.clear();
        lastNameField.sendKeys("Shapirko");
        Thread.sleep(7000);
        //-----------------Save profile---------------------
        WebElement saver = driver.findElement(By.xpath("//div[@id='idbtnsaveprofile']"));
        String saver1 = saver.getText();

        System.out.println("Text saved: " + saver1);
        saver.click();
        Thread.sleep(5000);
    }
    @Test
    public void profileAndFamilyPageComparing() throws InterruptedException {
        initLoginTestsStart();
        initLoginTestsEnd(LOGIN,PASSWORD);
        //---------------Save data from the Profile page-------------
        //---------------Go to the Profile Page -----------------
        openElementById("profile", 3000);
       /* driver.findElement(By.xpath("//i[@id='profile']")).click();
        Thread.sleep(3000);*/
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

        //---------------Go to the Family Page -----------------
        openElementById("family", 3000);
        //----------------------Comparing--------------------------
        String familyConfession = driver.findElement(
                By.cssSelector(".itemprofilefit #fieldobjconfession")).getText();
        System.out.println("Family confession: " + familyConfession);
        System.out.println("Confession of the profile is equivalent to confession of the family: "
                + profileConfession.equals(familyConfession));

        String familyLanguage = driver.findElement(
                By.xpath("//div[@class='row myrow']//span[@id='fieldobjlanguages']")).getText();
        System.out.println("Family language: " + familyLanguage);
        System.out.println("Language of the profile is equivalent to language of the family: "
                + profileLanguage.equals(familyLanguage));

        String familyFoodPreference = driver.findElement(
                By.cssSelector(".itemprofilefit #fieldobjfoodPreferences")).getText();
        System.out.println("Family food preference: " + familyFoodPreference);
        System.out.println("Food preference of the profile is equivalent to food preference of the family: "
                + profileFoodPreference.equals(familyFoodPreference));

        String familyEmail = driver.findElement(
                By.xpath("//div[@class='itemprofilefit']//span[@id='fieldobjelMail']")).getText();
        System.out.println("Family Email: " + familyEmail);
        System.out.println("Email of the profile is equivalent to email of the family: "
                + profileEmail.equals(familyEmail));

        String familyLastName = driver.findElement(By.cssSelector(".formscroll #titleprofile")).getText();
        System.out.println("Family Last Name: " + familyLastName);
        System.out.println("The family name of the profile is equivalent to the last name of the family:"
                + familyLastName.contains(profileFamilyName));

        String familyFamilyDescription = driver.findElement(
                By.xpath("//span[@id='fieldobjfamilyDescription']")).getText();
        System.out.println("Family Family Description: " + familyFamilyDescription);
        System.out.println("Family description of the profile is equivalent to family description of the family: "
                + profileFamilyDescription.equals(familyFamilyDescription));

    }

}
