import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    WebDriver driver;

//    @FindBy(xpath = "//*[contains(text(), 'Welcome')]")
    @FindBy(id = "create-entry")
    private WebElement createEntry;

    @FindBy(xpath = "//button[@class='user-menu-btn']")
    private WebElement logOutBtn;

    @FindBy(xpath = "//*[@class='title ng-binding']")
    private WebElement welcome;

    @FindBy(xpath = "//div[@class='modal-content']")
    private WebElement feedMonkey;

    @FindBy(xpath = "//button/div[contains(text(),'Cancel')]")
    private WebElement cancelBtn;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public WebElement getCreateEntry() {
        return createEntry;
    }

    public WebElement getWelcome() {
        return welcome;
    }

    public WebElement getLogOutBtn() {
        return logOutBtn;
    }

    public WebElement getFeedMonkey() {
        return feedMonkey;
    }

    public WebElement getCancelBtn() {
        return cancelBtn;
    }

    public EntryPage entry() {
        createEntry.click();
        return new EntryPage(driver);
    }

    public HomePage cancelFeed() {
        cancelBtn.click();
        return new HomePage(driver);
    }

    public LoginPage logOutBtn() {
        logOutBtn.click();
        return new LoginPage(driver);
    }

}

//button/div[contains(text(),'Cancel')]
//div[@class='modal ng-scope in']
//div[@class='modal-content']
