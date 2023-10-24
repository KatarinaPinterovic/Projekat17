package Tests;

import Base.BaseTest;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class CheckoutCompleteTest extends BaseTest {
    @BeforeMethod
    public void pageSetUp() throws InterruptedException {
        login();
        homepage.clickOnAddToCartButton();
        homepage.clickOnCartIcon();
        cartPage.clickOnCheckoutButton();
        String firstName = excelReader.getStringData("Login", 1, 4);
        String lastName = excelReader.getStringData("Login", 1, 5);
        String zipCode = String.valueOf(excelReader.getIntegerData("Login", 1, 6));
        checkoutPage.inputFirstName(firstName);
        checkoutPage.inputLastName(lastName);
        wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        checkoutPage.inputPostalCode(zipCode);
        checkoutPage.clickOnContinueButton();
        checkOutStepTwoPage.clickOnFinishButton();
    }
    @Test
    public void verifyMessageAfterPurchaseIsFinished(){
        Assert.assertTrue(checkoutCompletePage.message.isDisplayed());
        Assert.assertTrue(checkoutCompletePage.ponyImage.isDisplayed());
    }
}
