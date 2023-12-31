package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutCompletePage extends BaseTest {
    public CheckoutCompletePage(){
        PageFactory.initElements(driver, this);
    }
    @FindBy(className = "complete-header")
    public WebElement message;

    @FindBy(className = "pony_express")
    public WebElement ponyImage;

}
