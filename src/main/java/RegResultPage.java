import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegResultPage extends BasePage {

    @FindBy (xpath = "//div[@class='content-container']/h1")
    private WebElement userReg;

    @FindBy (xpath = "//div[@class='content-container']//p")
    private WebElement regConfMsg;


    public RegResultPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getUserReg() {
        return userReg;
    }

    public WebElement getRegConfMsg() {
        return regConfMsg;
    }

 }
