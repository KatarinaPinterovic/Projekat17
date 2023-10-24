package Pages;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class Homepage extends BaseTest {

    public Homepage(){

        PageFactory.initElements(driver, this);


    }

    @FindBy(className = "bm-burger-button")
    public WebElement burgerMenu;
    @FindBy(id = "inventory_sidebar_link")
    public WebElement allItems;
    @FindBy(id = "about_sidebar_link")
    public WebElement about;
    @FindBy(id = "logout_sidebar_link")
    public WebElement logoutButton;

    @FindBy(id = "reset_sidebar_link")
    public WebElement resetAppState;
    @FindBy(className = "product_sort_container")
    public WebElement sortingMenu;
    @FindBy(css = ".btn_primary.btn_inventory")
    public WebElement addToCartButton;
    @FindBy(css = "btn_secondary btn_inventory")
    public WebElement removeButton;
    @FindBy(id = "shopping_cart_container")
    public WebElement cartIcon;
    @FindBy(className = "social_twitter")
    public WebElement twitterLink;
    @FindBy(className = "social_facebook")
    public WebElement facebookLink;
    @FindBy(className = "social_linkedin")
    public WebElement linkedinLink;

    @FindBy(className = "bm-cross-button")
    public WebElement closeBurgerMenuButton;


    //-----------------------------------

    public void clickOnBurgerMenu(){
        burgerMenu.click();
    }
    public void clickOnAllItems(){
        allItems.click();
    }
    public void clickOnAbout(){
        about.click();
    }

    public void clickOnLogoutButton(){
        logoutButton.click();
    }

    public void clickOnResetAppStateButton(){
        resetAppState.click();
    }
    public void clickOnCloseBurgerMenu(){
        closeBurgerMenuButton.click();
    }

    public void clickOnSortMenu(){
        sortingMenu.click();
    }
    public void selectSortingMenu(String text){
        Select select = new Select(driver.findElement(By.className("product_sort_container")));
        select.selectByVisibleText(text);
        String selectedOption = select.getFirstSelectedOption().getText();

    }



    public void clickOnAddToCartButton(){
        addToCartButton.click();

        }


        public void clickOnRemoveButton(){
        removeButton.click();
        }

        public void clickOnCartIcon(){
        cartIcon.click();
        }

        public void clickOnTwitterIcon(){
        twitterLink.click();
        }
        public void clickOnFacebookIcon(){
        facebookLink.click();
        }
        public void clickOnLinkedinIcon(){
        linkedinLink.click();
        }



    }













