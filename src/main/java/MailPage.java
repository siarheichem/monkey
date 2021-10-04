import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class MailPage {
    WebDriver driver;

    @FindBy(xpath = "//div[@class='HeadBanner-ButtonsWrapper']//a[2]")
    private WebElement enterBtn;

    @FindBy(id = "passp-field-login")
    private WebElement identificator;

    @FindBy(id = "passp:sign-in")
    private WebElement signInBtn;

    @FindBy(id = "passp-field-passwd")
    private WebElement pswrdField;

    //span[@class='mail-MessageSnippet-FromText']

    public MailPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public WebElement getEnterBtn() {
        return enterBtn;
    }

    public WebElement getIdentificator() {
        return identificator;
    }

    public WebElement getSignInBtn() {
        return signInBtn;
    }

    public WebElement getPswrdField() {
        return pswrdField;
    }

    public LetterPage openLetter() {
        getEnterBtn().click();
        getIdentificator().click();
        getIdentificator().clear();
        getIdentificator().sendKeys("RabchynskiS@yandex.by");
        getSignInBtn().click();
        getPswrdField().click();
        getPswrdField().clear();
        getPswrdField().sendKeys("Siarhei82");
        getSignInBtn().click();
        return new LetterPage(driver);

    }
}
