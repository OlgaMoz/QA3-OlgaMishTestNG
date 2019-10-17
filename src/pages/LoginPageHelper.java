package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPageHelper extends PageBase {

    public LoginPageHelper(WebDriver driver) {
        super(driver);
    }

    public void openLoginPage() {
        WebElement loginIcon = driver.findElement(By.id("idsignin"));
        loginIcon.click();
        waitUntilElementIsVisible(By.id("signinrequest"), 30);
    }

    public Boolean correctPageIsLoaded() {
        return driver
                .findElement(By.id("clickreg")).getText().contains("registration");
    }


    public void initLoginTests(String login, String passw) {
        driver.findElement(By.id("logininput")).sendKeys(login);
        driver.findElement(By.id("passwordinput")).sendKeys(passw);
        WebElement signInButton = driver.findElement(By.id("signinrequest"));
        signInButton.click();
        waitUntilElementIsPresent(By.id("ihome"), 30);
    }

    public void closeLoginWindowByX() {
        driver.findElement(By.id("closedsignin")).click();
    }

    public boolean loginToTheSystemIncorrect() {
        waitUntilElementIsVisible(By.id("wrongloginorpassword"), 30);
        String message = driver.findElement(By.id("wrongloginorpassword")).getText();
        return message.contains("Wrong Authorization!");
    }
}
