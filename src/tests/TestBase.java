package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.IntroPageHelper;
import pages.PageBase;
import pages.ProfilePageHelper;

public class TestBase {
    public static final String LOGIN = "olga_mo_";
    public static final String PASSWORD = "Anna2019";
    WebDriver driver;
   // PageBase pageBase = new PageBase(driver);
    IntroPageHelper introPage;

    @BeforeMethod
    public void driverInit() {
        driver = new ChromeDriver();
        driver.get("https://mishpahug.co.il/");
        introPage = new IntroPageHelper(driver);

        introPage = PageFactory.initElements(driver, IntroPageHelper.class);

        introPage.openIntroPage();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
