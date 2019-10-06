package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WebLoginPageTests extends TestBase{
    @Test
    public void webLoginPositiveTest() throws InterruptedException {

        initLoginTests(LOGIN, PASSWORD);

        waitUntilElementIsVisible(By.id("profile"), 30);

        WebElement profileIcon = driver.findElement(By.id("profile"));

        // ------ Check that we on the HomePage for authorized user---
      /*  System.out.println("We logged in: "
                + profileIcon.getAttribute("title").contains("olga_mo_"));*/
        Assert.assertTrue(profileIcon.getAttribute("title").contains("olga_mo_"));

      //  Thread.sleep(10000);
    }
    @Test
    public void webLoginNegativeTest() throws InterruptedException {

        initLoginTests(LOGIN, "Olga1");
        waitUntilElementIsVisible(By.id("wrongloginorpassword"), 30);
        String message = driver.findElement(By.id("wrongloginorpassword")).getText();
        System.out.println("Message 'Wrong Authorization!' is visible: " + message.contains("Wrong Authorization!"));
        Assert.assertTrue(message.contains("Wrong Authorization!"));
        WebElement closeSignIn =driver.findElement(By.id("closedsignin"));
        closeSignIn.click();
        //System.out.println("HomePage - loginIcon exists, user unauthorized: " + driver.findElement(By.id("idsignin"))
        //        .getText().equals("Login"));
        //Thread.sleep(3000);
        Assert.assertEquals(driver.findElement(By.id("idsignin")).getText(), "Login");
    }

    @Test
    public void webLoginExitByCancelTest() throws InterruptedException {

        initLoginTestsStart();
        WebElement signInButton = driver.findElement(By.id("signinrequest"));
        System.out.println("SignInButton exists: " + signInButton.getText().equals("Sign in"));
        Assert.assertEquals(signInButton.getText(), "Sign in", "The button 'Sign in' is not exist");
        WebElement closeSignIn =driver.findElement(By.id("closedsignin"));
        closeSignIn.click();
        //System.out.println("HomePage - loginIcon exists: " + driver.findElement(By.id("idsignin"))
        //        .getText().equals("Login"));
        Assert.assertEquals(driver.findElement(By.id("idsignin")).getText(), "Login");

    }

}
