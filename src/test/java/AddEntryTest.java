import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static org.openqa.selenium.By.xpath;

public class AddEntryTest extends BaseTest {
    private static final String USRNAME = "RabchynskiS@yandex.by";
    private static final String PSWRD = "Stand1234";
    private static final String MSG = "Diplom!";

    @Test
    public void AddEntry () {
        HomePage homePage = loginPage.login(USRNAME, PSWRD);
        try {
            homePage.cancelFeed();
        }
        catch (Exception e) {
            System.out.println("No pop-up window");
        }
        Assert.assertTrue(homePage.getLogOutBtn().isEnabled(), "You are not logged in");
        int before = driver.findElements(xpath("//div[@class='checkbox-wrapper']/input")).size();
        homePage.getCreateEntry().click();
        EntryPage entryPage = new EntryPage(driver);
        entryPage.editEntry(MSG);
        int after = driver.findElements(xpath("//div[@class='checkbox-wrapper']/input")).size();
        Assert.assertEquals(after,before+1);
        System.out.println("One new note is added");
        Assert.assertEquals(homePage.getLastNote().getText(),MSG);
        System.out.println("Note is correct");
    }
}
