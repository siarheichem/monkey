import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FinishRegTest {

    WebDriver driver;
    MailPage mailPage;
    private static final String URL = "https://mail.yandex.by/?uid=1492591961#tabs/news";

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        mailPage = openMailPage();
    }

//    @AfterMethod
//    public void close() {
//        driver.quit();
//    }

    private MailPage openMailPage() {
        driver.get(URL);
        return new MailPage(driver);
    }

    @Test
            public void openLetter() {
        mailPage.openLetter();
    }


}
