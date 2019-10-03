package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class TestBase {
    public static final String LOGIN = "olga_mo_";
    public static final String PASSWORD = "Anna2019";
    WebDriver driver;

    @BeforeMethod
    public void driverInit() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("https://mishpahug.co.il/");
        Thread.sleep(3000);
        driver.findElement(By.id("closedIntro")).click();
        Thread.sleep(5000);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    public void initLoginTestsStart() throws InterruptedException {
        WebElement loginIcon = driver.findElement(By.id("idsignin"));
        loginIcon.click();
        Thread.sleep(2000);

    }

    public void initLoginTests(String login, String passw) throws InterruptedException {
        WebElement loginIcon = driver.findElement(By.id("idsignin"));
        loginIcon.click();
        Thread.sleep(2000);
        driver.findElement(By.id("logininput")).sendKeys(login);
        driver.findElement(By.id("passwordinput")).sendKeys(passw);
        WebElement signInButton = driver.findElement(By.id("signinrequest"));
        signInButton.click();
        Thread.sleep(7000);
    }

    public void openElementById(String profile, int i) throws InterruptedException {
        driver.findElement(By.id(profile)).click();
        Thread.sleep(i);
    }
}
