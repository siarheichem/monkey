import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ConfirmPage extends BasePage {

    @FindBy(xpath = "//div[@class='content-container']/h1")
    private WebElement confirm;

    @FindBy(xpath = "//a[@class='donate-button']")
    private WebElement donateBtn;

    public ConfirmPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getConfirm() {
        return confirm;
    }

    public WebElement getDonateBtn() {
        return donateBtn;
    }

    public ConfirmPage checkReg() {
        System.out.println(getConfirm().getText());
        return new ConfirmPage(driver);
    }


}
