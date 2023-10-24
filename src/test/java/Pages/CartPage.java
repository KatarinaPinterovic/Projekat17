package Pages;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage extends BaseTest {
    public CartPage(){
        PageFactory.initElements(driver, this);
    }
    @FindBy(className = "btn_secondary")
    public WebElement continueShoppingButton;

    @FindBy(css = ".btn_secondary.cart_button")
    public WebElement removeButton;

    @FindBy(css = ".btn_action.checkout_button")
    public WebElement checkoutButton;


    //---------------------------------------

    public void clickOnContinueShoppingButton(){
        continueShoppingButton.click();
    }
    public void clickOnRemoveButton(){
        removeButton.click();
    }

    public void clickOnCheckoutButton(){
        checkoutButton.click();
    }
    public boolean isCartEmpty() {
        List<WebElement> productElements = driver.findElements(By.cssSelector(".inventory_item_name"));
        return productElements.isEmpty();
    }

}
