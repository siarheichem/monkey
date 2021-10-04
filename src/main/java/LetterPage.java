import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LetterPage extends MailPage {

    @FindBy(xpath = "//*[contains(text(), 'Рас')]")
    private WebElement news;

    @FindBy (xpath = "//span[@title='team@monkkee.com']")
    private WebElement monkeyLetter;

    @FindBy(xpath = "//table[@class='815d836d1c464417button c07fe0e697fb1807float-center c07fe0e697fb1807float-center']//a")
    private WebElement confirmBtn;

    public LetterPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getNews() {
        return news;
    }

    public WebElement getMonkeyLetter() {
        return monkeyLetter;
    }

    public WebElement getConfirmBtn() {
        return confirmBtn;
    }

    public LetterPage confirmLink() {
        getNews().click();
        getMonkeyLetter().click();
        getConfirmBtn().click();
        return new LetterPage(driver);
    }

    public ConfirmPage checkReg() {
        ConfirmPage confirmPage = new ConfirmPage(driver);
        System.out.println(confirmPage.getConfirm().getText());
        return new ConfirmPage(driver);
    }


}
