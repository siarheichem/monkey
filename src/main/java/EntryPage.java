import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EntryPage {

    WebDriver driver;

    @FindBy(id = "delete-entry")
    private WebElement deleteBtn;

    @FindBy(id = "back-to-overview")
    private WebElement backHomeBtn;

    @FindBy(xpath ="//div[@id='editable']/p")
    private WebElement editNote;

    @FindBy (xpath = "//span[@id='cke_341']/a[@class='cke_button cke_button__savetoggle cke_button_off cke_button_disabled']")
    private WebElement saveNote;

    public EntryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public WebElement getDeleteBtn() {
        return deleteBtn;
    }
    public WebElement getBackHomeBtn() {return backHomeBtn;}
    public WebElement getEditNote() {return editNote;}
    public WebElement getSaveNote() {return saveNote;}

    public HomePage deleteEntry() {
        deleteBtn.click();
        return new HomePage(driver);
    }

    public HomePage backHome() {
        backHomeBtn.click();
        return new HomePage(driver);
    }

    public HomePage editEntry(String messageText) {
        editNote.click();
        editNote.sendKeys(messageText);
//        saveNote.click();
        backHomeBtn.click();
        return new HomePage(driver);
    }

}
