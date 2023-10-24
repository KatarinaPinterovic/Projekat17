package Pages;

import Base.BaseTest;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseTest {
    public LoginPage(){
        PageFactory.initElements(driver, this);


    }
    @FindBy(id = "user-name")
    public WebElement usernameField;

    @FindBy(id = "password")
    public WebElement passwordField;

    @FindBy(id = "login-button")
    public WebElement loginButton;

    @FindBy(className = "error-button")
    public WebElement error;

    //-----------------------------

    public void inputUsername(String validUsername){
        usernameField.clear();
        usernameField.sendKeys(validUsername);
    }
    public void inputPassword(String validPassword){
        passwordField.clear();
        passwordField.sendKeys(validPassword);
    }
    public void clickOnLoginButton(){
        loginButton.click();
    }

}
