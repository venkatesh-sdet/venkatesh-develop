package example.steps;

import example.pages.amazonPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class amazonSteps {

    private WebDriver driver;
    private amazonPage page;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Given("user launch the amazon application")
    public void userLaunchTheAmazonApplication() throws InterruptedException {
        System.out.println("User launched Amazon application.");
        driver.get("https://www.amazon.in/");
        page = new amazonPage(driver);
        Thread.sleep(2000);
    }

    @When("user search the product {string} in search box")
    public void userSearchTheProductInSearchBox(String productName) {
        page.searchProductInSearchBox(productName);
    }

    @Then("user added a item into cart")
    public void userAddedAItemIntoCart() throws InterruptedException {
        page.selectItem();
        page.addItemIntoCart();
    }

    @And("verify the cart has an item")
    public void verifyTheCartHasAnItem() {
        page.verifyCartHasAnItemAdded();
    }
}
