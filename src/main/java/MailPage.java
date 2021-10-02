import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class MailPage {
    WebDriver driver;

    @FindBy (xpath = "//span[@class='mail-MessageSnippet-FromText']")
    private WebElement letter;

    public MailPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public WebElement getLetter() {
        return letter;
    }

    public MailPage openLetter() {
        getLetter().click();
        return new MailPage(driver);
    }
}
