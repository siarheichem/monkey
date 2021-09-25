import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EntryPage {

    WebDriver driver;

    @FindBy(id = "delete-entry")
    private WebElement deleteBtn;

    public EntryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public WebElement getDeleteBtn() {
        return deleteBtn;
    }

    public HomePage deleteEntry() {
        deleteBtn.click();
        return new HomePage(driver);
    }

}
