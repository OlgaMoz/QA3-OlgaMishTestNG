package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.PageBase;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class TestBase {
    public static final String LOGIN = "olga_mo_";
    public static final String PASSWORD = "Anna2019";
    WebDriver driver;
    PageBase pageBase = new PageBase(driver);

    @BeforeMethod
    public void driverInit() {
        driver = new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        driver.get("https://mishpahug.co.il/");
       // Thread.sleep(3000);
        waitUntilElementIsClickable(By.id("closedIntro"), 30);
        driver.findElement(By.id("closedIntro")).click();
        waitUntilElementIsVisible(By.className("titlefilter"), 30);
       // Thread.sleep(5000);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    public void initLoginTestsStart(){
        WebElement loginIcon = driver.findElement(By.id("idsignin"));
        loginIcon.click();

        waitUntilElementIsVisible(By.id("signinrequest"), 30);
    }

  /*  public void initLoginTests(String login, String passw) {

        initLoginTestsStart();
        driver.findElement(By.id("logininput")).sendKeys(login);
        driver.findElement(By.id("passwordinput")).sendKeys(passw);
        WebElement signInButton = driver.findElement(By.id("signinrequest"));
        signInButton.click();
        //waitUntilElementIsClickable(By.id("profile"), 30);
        waitUntilElementIsPresent(By.id("ihome"), 30);
    }*/

 /*   public void openElementById(String id){
        driver.findElement(By.id(id)).click();
              // Thread.sleep(i);
    }*/
    public void waitUntilElementIsVisible(By locator, int time){
        try{
            new WebDriverWait(driver, time)
                    .until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public void waitUntilAllElementsVisible(List<WebElement> listOptions, int time){
        try{
            new WebDriverWait(driver, time)
                    .until(ExpectedConditions.visibilityOfAllElements(listOptions));
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public void waitUntilElementIsClickable(By locator, int time){
        try{
            new WebDriverWait(driver, time)
                    .until(ExpectedConditions.elementToBeClickable(locator));
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public void waitUntilElementContains(By locator, int time){

    }

    public void waitUntilElementIsPresent(By locator, int time){
        try{
            new WebDriverWait(driver, time)
                    .until(ExpectedConditions.presenceOfElementLocated(locator));
        } catch(Exception e){
            e.printStackTrace();
        }
    }

}
