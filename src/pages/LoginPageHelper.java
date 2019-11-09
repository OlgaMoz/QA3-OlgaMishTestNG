package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageHelper extends PageBase {

    @FindBy(id = "signinrequest")
    WebElement signInButton;

    @FindBy(id = "idsignin")
    WebElement loginIcon;

  /*  @FindBy(id = "clickreg")
    WebElement registrationLink;*/

    @FindBy(id = "logininput")
    WebElement loginField;

    @FindBy(id = "passwordinput")
    WebElement passwordField;

   // @FindBy(id = "ihome")
   // WebElement iconHomForAuthorizedUser;

    @FindBy(id = "wrongloginorpassword")
    WebElement wrongAuth;

    @FindBy(id = "closedsignin")
    WebElement closeByXButton;

    public LoginPageHelper(WebDriver driver) {
        super(driver);
    }

    public void openLoginPage() {
        openPage(loginIcon, signInButton);
    }

    public void waitUntilLoginPageIsLoaded() {
        waitUntilPageIsLoaded(signInButton, 20);
    }

  /*  public Boolean correctPageIsLoaded() {
       return registrationLink.getText().contains("registration");
    }*/

    public void initLoginTests(String login, String passw) {
        loginField.sendKeys(login);
        passwordField.sendKeys(passw);
        signInButton.click();
    }

    public void closeLoginWindowByX() {
        closeByXButton.click();
    }

    public boolean loginToTheSystemIncorrect() {
        waitUntilElementIsVisible(wrongAuth, 30);
        return wrongAuth.getText().contains("Wrong Authorization!");
    }
}
