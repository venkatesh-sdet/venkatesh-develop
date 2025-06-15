package example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;



public class amazonPage {

    public WebDriver driver;
    public amazonPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    //pageFactory
    @FindBy(xpath = "//*[@role='searchbox']")
    WebElement searchBox;

    @FindBy(id = "add-to-cart-button")
    WebElement addCartButton;

    @FindBy(id = "nav-cart-count")
    WebElement cartIcon;

    @FindBy(id = "sc-subtotal-label-buybox")
    WebElement itemCount;

    @FindBy (xpath = "//*[@role='listitem']")
    List<WebElement> resultItems;


    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    public void searchProductInSearchBox(String productName)  {
        wait.until(ExpectedConditions.elementToBeClickable(searchBox));
        searchBox.sendKeys(productName);
        searchBox.submit();
    }
    public void selectItem() throws InterruptedException {
        JavascriptExecutor js =  (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,450)", "");
        resultItems.get(3).click();
        System.out.println("The Item selected");

    }
    public void addItemIntoCart(){
        Object[] windowHandles=driver.getWindowHandles().toArray();
        driver.switchTo().window((String) windowHandles[1]);
        JavascriptExecutor js =  (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,600)", "");
        addCartButton.click();
        System.out.println("The addToCart button clicked");
    }
    public void verifyCartHasAnItemAdded(){
        cartIcon.click();
        int count = Integer.parseInt(itemCount.getText().substring(10,11));
        Assert.assertEquals(count, 1, "The number of items added into cart is mis matched");
        System.out.println("The item is added into cart");
    }
}