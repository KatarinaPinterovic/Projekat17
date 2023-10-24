package Tests;

import Base.BaseTest;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;


public class CartTest extends BaseTest {
    @BeforeMethod
    public void pageSetUp() {
        login();
        homepage.clickOnAddToCartButton();
        homepage.clickOnCartIcon();
    }

    @Test
    public void verifyThatContinueShoppingButtonWorks() throws InterruptedException {
        Assert.assertTrue(cartPage.continueShoppingButton.isDisplayed());
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        cartPage.clickOnContinueShoppingButton();

    }
    @Test
    public void verifyThatArticlesAreRemovedFromTheCart() {
        cartPage.clickOnRemoveButton();

        boolean isCartEmpty = cartPage.isCartEmpty();
        Assert.assertTrue(cartPage.isCartEmpty());
    }

    @Test
    public void verifyThatCheckoutOptionWorks(){
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(cartPage.checkoutButton.isDisplayed());
        cartPage.clickOnCheckoutButton();
        String newUrl = driver.getCurrentUrl();
        Assert.assertNotEquals(currentUrl, newUrl, "URL changed after clicking Chekout.");

    }
}

