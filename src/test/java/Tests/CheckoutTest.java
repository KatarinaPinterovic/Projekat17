package Tests;

import Base.BaseTest;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class CheckoutTest extends BaseTest {
    @BeforeMethod
    public void pageSetUp(){
        login();
        homepage.clickOnAddToCartButton();
        homepage.clickOnCartIcon();
        cartPage.clickOnCheckoutButton();
    }

    @Test
    public void verifyThatPurchaseOptionWorks() throws InterruptedException {
        String currentUrl = driver.getCurrentUrl();
        String firstName = excelReader.getStringData("Login", 1, 4);
        String lastName = excelReader.getStringData("Login", 1, 5);
        String zipCode = String.valueOf(excelReader.getIntegerData("Login", 1, 6));
        checkoutPage.inputFirstName(firstName);
        checkoutPage.inputLastName(lastName);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        checkoutPage.inputPostalCode(zipCode);
        checkoutPage.clickOnContinueButton();
        String newUrl = driver.getCurrentUrl();
        Assert.assertNotEquals(currentUrl, newUrl, "URL changed after clicking Continue button.");

    }
    @Test
    public void userCanPurchaseArticlesWithoutEnteredData() throws InterruptedException {
        String currentUrl = driver.getCurrentUrl();
        checkoutPage.inputFirstName(" ");
        checkoutPage.inputLastName(" ");
        checkoutPage.inputPostalCode(" ");
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        checkoutPage.clickOnContinueButton();
        String newUrl = driver.getCurrentUrl();
        Assert.assertNotEquals(currentUrl, newUrl, "URL changed after clicking Continue button.");

    }

}
