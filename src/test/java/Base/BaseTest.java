package Base;

import Pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;



import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;


public class BaseTest {
    public static WebDriver driver;
    public WebDriverWait wait;
    public LoginPage loginPage;
    public Homepage homepage;
    public CartPage cartPage;
    public CheckoutPage checkoutPage;
    public CheckOutStepTwoPage checkOutStepTwoPage;
    public CheckoutCompletePage checkoutCompletePage;
    public ExcelReader excelReader;


    @BeforeClass
    public void setUp() throws IOException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        loginPage = new LoginPage();
        homepage = new Homepage();
        cartPage = new CartPage();
        checkoutPage = new CheckoutPage();
        checkOutStepTwoPage = new CheckOutStepTwoPage();
        checkoutCompletePage = new CheckoutCompletePage();

        excelReader = new ExcelReader("C:\\Users\\Katarina\\Desktop\\LoginData.xlsx.");
        //ChromeOptions options = new ChromeOptions();
        //options.addArguments("--headless");
        //driver = new ChromeDriver(options);


    }
    //Metoda za prijavu korisnika
    public void login(){
        driver.navigate().to("https://www.saucedemo.com/v1/");
        String validUsername = excelReader.getStringData("Login", 1, 0);
        String validPassword = excelReader.getStringData("Login", 1, 1);
        loginPage.inputUsername(validUsername);
        loginPage.inputPassword(validPassword);
        loginPage.clickOnLoginButton();
    }
    //Metoda za dodavanje artikala u korpu
    public void addItemsToCart(int numberOfItems) {
        for (int i = 0; i < numberOfItems; i++) {
            homepage.clickOnAddToCartButton();
        }
    }

   //Metoda za proveru dodatih artikala u korpu
        public List<String> getProductsInCart() {
        List<String> productNames = new ArrayList<>();
        List<WebElement> productElements = driver.findElements(By.cssSelector(".inventory_item_name"));

        for (WebElement productElement : productElements) {
            productNames.add(productElement.getText());
        }
        return productNames;
    }
    @AfterClass
    public void tearDown() {

        driver.quit();
    }
    }











