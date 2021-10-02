import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    @FindBy(id = "login")
    private WebElement loginInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(xpath = "//*[@class='btn-text-content']")
    private WebElement loginBtn;

    @FindBy(xpath = "//div[@class='donation-notice-buttons']/button[1]")
    private WebElement logOutBtnNoDonation;

    @FindBy (xpath = "//div[@class='login-links']/a[2]")
    private WebElement register;

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
        loginBtn.click();
        System.out.println("login completed");
        return new HomePage(driver);
    }

    public RegistPage regist() {
        register.click();
        return new RegistPage(driver);
    }

    public HomePage notlogin(String username, String password) {
        loginInput.click();
        loginInput.clear();
        loginInput.sendKeys("1");
        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys(password);
        loginBtn.click();
        return new HomePage(driver);
    }

    public LoginPage logOutCancelFeed() {
        logOutBtnNoDonation.click();
        return new LoginPage(driver);
    }

    public WebElement getLoginButton() {
        return loginBtn;
    }

    public WebElement getLogOutBtnNoDonation() {
        return logOutBtnNoDonation;
    }

}
