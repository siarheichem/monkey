import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    WebDriver driver;
    LoginPage loginPage;
    private static final String URL = "https://my.monkkee.com/#/";

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        loginPage = openLoginPage();
    }

//    @AfterMethod
//    public void close() {
//        driver.quit();
//    }

    private LoginPage openLoginPage() {
        driver.get(URL);
        return new LoginPage(driver);
    }

}
