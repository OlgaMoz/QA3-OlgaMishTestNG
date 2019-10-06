package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class LoginPageTests extends TestBase{


    @Test
    public void loginPositiveTest() throws InterruptedException {

        initLoginTestsStart();
        initLoginTests(LOGIN, PASSWORD);

        WebElement profileIcon = driver.findElement(By.id("profile"));

        // ------ Check that we on the HomePage for authorized user---
        System.out.println("We logged in: "
                + profileIcon.getAttribute("title").contains("olga_mo_"));

        Thread.sleep(10000);
    }
    @Test
    public void loginNegativeTest() {

        initLoginTestsStart();
        initLoginTests(LOGIN, "Olga1");
        String message = driver.findElement(By.id("wrongloginorpassword")).getText();
        System.out.println("Message 'Wrong Authorization!' is visible: " + message.contains("Wrong Authorization!"));
        WebElement closeSignIn =driver.findElement(By.id("closedsignin"));
        closeSignIn.click();
       // System.out.println("HomePage - loginIcon exists, user unauthorized: " + loginIcon.getText().equals("Login"));
    }

    @Test
    public void loginExitByCancelTest() throws InterruptedException {

        initLoginTestsStart();
        WebElement signInButton = driver.findElement(By.id("signinrequest"));
        System.out.println("SignInButton exists: " + signInButton.getText().equals("Sign in"));
        WebElement closeSignIn =driver.findElement(By.id("closedsignin"));
        closeSignIn.click();
       // System.out.println("HomePage - loginIcon exists: " + loginIcon.getText().equals("Login"));

    }

}
