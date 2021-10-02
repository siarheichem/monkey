import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistPage extends BasePage {

    @FindBy(xpath = "//button[@class='btn btn-primary']")
    private WebElement okBtn;

    @FindBy(id = "registration_email")
    private WebElement regEmail;

    @FindBy(id = "registration_password")
    private WebElement regPass;

    @FindBy(id = "registration_password_confirmation")
    private WebElement regPassConfirm;

    @FindBy(id = "registration_password_hint")
    private WebElement regPassHint;

    @FindBy (id ="registration_terms_of_use")
    private WebElement termsOfUseChBox;

    @FindBy (id ="registration_lost_password_warning_registered")
    private WebElement warningChBox;

    @FindBy (xpath = "//div[@class='explanation']/p[1]")
    private WebElement explanation;

    @FindBy (id = "registration_password-strength-indicator")
    private WebElement passwordIndicator;

    @FindBy (xpath = "//div[@class='alert alert-danger']")
    private WebElement alert;

    @FindBy (xpath = "//div[@class='help-block']")
    private WebElement helpBlock;


    //div[@class='alert alert-danger']
    //div[@class='field_with_errors']/input
    //div[@class='help-block']


    public RegistPage(WebDriver driver) {
        super(driver);
    }

    public RegResultPage registration(String email, String password, String confirmation, String hint) {

        System.out.println("Registration starts");
        getRegEmail().click();
        getRegEmail().clear();
        getRegEmail().sendKeys(email);
        getRegPass().click();
        getRegPass().clear();
        getRegPass().sendKeys(password);
        getRegPassConfirm().click();
        getRegPassConfirm().clear();
        getRegPassConfirm().sendKeys(confirmation);
        getRegPassHint().click();
        getRegPassHint().clear();
        getRegPassHint().sendKeys(hint);
        getTermsOfUseChBox().click();
        getWarningChBox().click();
        getOkBtn().click();
        return new RegResultPage(driver);
    }

    public RegistPage enterPass (String password) {

        getRegPass().click();
        getRegPass().clear();
        getRegPass().sendKeys(password);
        return new RegistPage(driver);
    }

    public RegistPage invalidEmail(String email, String password, String confirmation, String hint) {

        System.out.println("Registration starts");
        getRegEmail().click();
        getRegEmail().clear();
        getRegEmail().sendKeys(email);
        getRegPass().click();
        getRegPass().clear();
        getRegPass().sendKeys(password);
        getRegPassConfirm().click();
        getRegPassConfirm().clear();
        getRegPassConfirm().sendKeys(confirmation);
        getRegPassHint().click();
        getRegPassHint().clear();
        getRegPassHint().sendKeys(hint);
        getTermsOfUseChBox().click();
        getWarningChBox().click();
        getOkBtn().click();
        return new RegistPage(driver);
    }

    public WebElement getOkBtn() {
        return okBtn;
    }

    public WebElement getRegEmail() {
        return regEmail;
    }

    public WebElement getRegPass() {
        return regPass;
    }

    public WebElement getRegPassConfirm() {
        return regPassConfirm;
    }

    public WebElement getRegPassHint() {
        return  regPassHint;
    }

    public WebElement getTermsOfUseChBox() {
        return termsOfUseChBox;
    }

    public WebElement getWarningChBox() {
        return warningChBox;
    }

    public WebElement getExplanation() {
        return explanation;
    }

    public WebElement getPasswordIndicator() {
        return passwordIndicator;
    }

    public WebElement getAlert() {
        return alert;
    }

    public WebElement getHelpBlock() {
        return helpBlock;
    }

}
