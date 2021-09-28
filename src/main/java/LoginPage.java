import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    @FindBy(id = "login")
    private WebElement loginInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(xpath = "//*[@class='btn-text-content']")
    private WebElement loginButton;

    @FindBy(xpath = "//div[@class='donation-notice-buttons']/button[1]")
    private WebElement logOutBtnNoDonation;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public HomePage login(String username, String password) {
        System.out.println("user logs in");
        loginInput.click();
        loginInput.clear();
        loginInput.sendKeys(username);
        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys(password);
        loginButton.click();
        System.out.println("login completed");
        return new HomePage(driver);
    }

    public HomePage notlogin(String username, String password) {
        loginInput.click();
        loginInput.clear();
        loginInput.sendKeys("1");
        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys(password);
        loginButton.click();
        return new HomePage(driver);
    }

    public LoginPage logOutCancelFeed() {
        logOutBtnNoDonation.click();
        return new LoginPage(driver);
    }

    public WebElement getLoginButton() {
        return loginButton;
    }

    public WebElement getLogOutBtnNoDonation() {
        return logOutBtnNoDonation;
    }

}
