package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class CheckOutStepTwoPage extends BaseTest {
    public CheckOutStepTwoPage(){
        PageFactory.initElements(driver, this);
    }
    @FindBy(css = ".btn_action.cart_button")
    public WebElement finishButton;


    //-----------------------------------

    public void clickOnFinishButton(){
        finishButton.click();
    }
}
