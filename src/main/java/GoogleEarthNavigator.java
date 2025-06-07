
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

        public class GoogleEarthNavigator {
            public static void main(String[] args) {
                // Set up the ChromeDriver using WebDriverManager
                WebDriverManager.chromedriver().setup();


                // Configure Chrome options
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                options.addArguments("--disable-blink-features=AutomationControlled");
                options.addArguments("--disable-extensions");
                options.addArguments("--disable-infobars");
                options.addArguments("--disable-notifications");
                options.addArguments("--no-sandbox");
                options.addArguments("--disable-dev-shm-usage");
                // Run Chrome in non-headless mode to see if it resolves the issue
                // options.addArguments("--headless"); // Uncomment this line if you want to run in headless mode

                // Initialize the ChromeDriver with the specified options
                WebDriver driver = new ChromeDriver(options);

                // Open Google Earth's website
                driver.get("https://earth.google.com/web/@17.41003483,78.41652182,583.88355392a,5686.80308819d,35y,0h,0t,0r/data=CgRCAggBOgMKATBCAggBSg0I____________ARAA");

                // Wait for the page to load (you may need to adjust the wait time)
                WebDriverWait wait = new WebDriverWait(driver, 10);
                try {
                    // Wait for the search box to be present and enabled
                    WebElement inputBox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/flutter-view/flt-text-editing-host/form/input[1]")));
                    inputBox.sendKeys("Delhi");
                    inputBox.submit();

                    // Wait for the search results to load
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='search-results']")));
                    // Perform any other actions you need
                    Thread.sleep(2000);

                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    // Close the browser
                    driver.quit();
                }
            }
        }

