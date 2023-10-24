package Tests;

import Base.BaseTest;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;


public class LoginTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver.navigate().to("https://www.saucedemo.com/v1/");


    }
    @Test(priority = 10)
    public void userCanLogIn() throws InterruptedException {
        String currentUrl = driver.getCurrentUrl();
            String validUsername = excelReader.getStringData("Login", 1, 0);
            String validPassword = excelReader.getStringData("Login", 1, 1);
            loginPage.inputUsername(validUsername);
            loginPage.inputPassword(validPassword);

            wait = new WebDriverWait(driver, Duration.ofSeconds(5));

            Assert.assertTrue(loginPage.loginButton.isDisplayed());
            loginPage.clickOnLoginButton();


            String newUrl = driver.getCurrentUrl();
            Assert.assertNotEquals(currentUrl, newUrl, "URL changed after user logged in.");
        }


    @Test(priority = 20)
    public void userCannotLogInWithInvalidUsername() throws InterruptedException {
        String invalidUsername = excelReader.getStringData("Login", 1, 2);
        String validPassword = excelReader.getStringData("Login", 1, 1);
        loginPage.inputUsername(invalidUsername);
        loginPage.inputPassword(validPassword);
        loginPage.clickOnLoginButton();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));


        Assert.assertTrue(loginPage.error.isDisplayed());
        String expectedURL = "https://www.saucedemo.com/v1/";
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(expectedURL, actualURL);

    }
    @Test(priority = 30)
    public void userCannotLogInWithInvalidPassword() throws InterruptedException {
        String validUsername = excelReader.getStringData("Login", 1, 0);
        String invalidPassword = excelReader.getStringData("Login", 1, 3);
        loginPage.inputUsername(validUsername);
        loginPage.inputPassword(invalidPassword);
        loginPage.clickOnLoginButton();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        Assert.assertTrue(loginPage.error.isDisplayed());
        String expectedURL = "https://www.saucedemo.com/v1/";
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(expectedURL, actualURL);

    }
    @Test(priority = 35)
    public void userCannotLoginWithInvalidUsernamAndPassword(){
        for (int i = 1; i < excelReader.getLastRow("Login"); i++) {
            String invalidUsername = excelReader.getStringData("Login", i, 2);
            String invalidPassword = excelReader.getStringData("Login", 1, 3);
            loginPage.inputUsername(invalidUsername);
            loginPage.inputPassword(invalidPassword);
            loginPage.clickOnLoginButton();
        }
    }
    @Test(priority = 40)
    public void userCannotLogInWithEmptyFields() throws InterruptedException {
        loginPage.inputUsername(" ");
        loginPage.inputPassword(" ");
        loginPage.clickOnLoginButton();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        Assert.assertTrue(loginPage.error.isDisplayed());
        String expectedURL = "https://www.saucedemo.com/v1/";
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(expectedURL, actualURL);

    }
    @Test(priority = 50)
    public void userCanLogOut() throws InterruptedException {
        String validUsername = excelReader.getStringData("Login", 1, 0);
        String validPassword = excelReader.getStringData("Login", 1, 1);
        loginPage.inputUsername(validUsername);
        loginPage.inputPassword(validPassword);
        loginPage.clickOnLoginButton();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        homepage.clickOnBurgerMenu();
        homepage.clickOnLogoutButton();

    }

}
