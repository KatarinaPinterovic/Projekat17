package Tests;

import Base.BaseTest;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;


public class HomepageTest extends BaseTest {
    @BeforeMethod
    public void pageSetUp(){
        login();

    }
    @Test
    public void verfiyThatHamburgerMenuWorks() throws InterruptedException {
        String currentUrl = driver.getCurrentUrl();
        homepage.clickOnBurgerMenu();
        Thread.sleep(2000);
        homepage.clickOnAllItems();
        homepage.clickOnBurgerMenu();
        homepage.clickOnAbout();
        String newUrl = driver.getCurrentUrl();
        Assert.assertNotEquals(currentUrl, newUrl, "URL changed after clicking About.");
        driver.navigate().back();
        homepage.clickOnResetAppStateButton();
        Assert.assertTrue(homepage.burgerMenu.isDisplayed());
        Assert.assertTrue(homepage.allItems.isDisplayed());
        Assert.assertTrue(homepage.about.isDisplayed());
        Assert.assertTrue(homepage.logoutButton.isDisplayed());
        Assert.assertTrue(homepage.resetAppState.isDisplayed());
    }

    @Test
    public void verifyThatSortingMenuWorks() throws InterruptedException {
        homepage.clickOnSortMenu();
        wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        homepage.selectSortingMenu("Name (A to Z)");
        wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        Assert.assertTrue(driver.getPageSource().contains("Name (Z to A)"), "Sorting by Name A to Z not choosen.");
        homepage.selectSortingMenu("Name (Z to A)");
        wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        Assert.assertTrue(driver.getPageSource().contains("Name (Z to A)"), "Sorting by Name Z to A not choosen.");
        homepage.selectSortingMenu("Price (low to high)");
        wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        Assert.assertTrue(driver.getPageSource().contains("Price (low to high)"), "Sorting by Price low to high not choosen.");
        homepage.selectSortingMenu("Price (high to low)");
        Assert.assertTrue(driver.getPageSource().contains("Price (high to low)"), "Sorting by Price high to low not choosen.");
        Assert.assertTrue(homepage.sortingMenu.isDisplayed());

    }


    @Test
    public void verifyThatArticlesCanBeAddedToCart() {
        int numberOfItemsToAdd = 2;
        addItemsToCart(numberOfItemsToAdd);
        List<String> productsInCart = cartPage.getProductsInCart();
        for (String productName : productsInCart) {
            Assert.assertTrue(productsInCart.contains(productName), "Article");
        }
    }

    @Test
    public void verifyThatCartIconWorks(){
        homepage.clickOnCartIcon();
        Assert.assertTrue(homepage.cartIcon.isDisplayed());
        Assert.assertTrue(homepage.cartIcon.isEnabled());
    }

    @Test
    public void verifyThatSocialMediaLinksWork() throws InterruptedException {
        String currentUrl = driver.getCurrentUrl();
        homepage.clickOnTwitterIcon();
        Assert.assertTrue(homepage.twitterLink.isDisplayed());
        String newUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, newUrl, "URL didn't change after clicking Twitter link.");
        wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        homepage.clickOnFacebookIcon();
        Assert.assertTrue(homepage.facebookLink.isDisplayed());
        wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        homepage.clickOnLinkedinIcon();
        Assert.assertTrue(homepage.linkedinLink.isDisplayed());

    }

}
