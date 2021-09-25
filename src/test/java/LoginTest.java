import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    private static final String USRNAME = "rabchinskij_sm@tut.by";
    private static final String PSWRD = "Siarhei82";

    @Test
    public void LoginTest() {
        HomePage homePage = loginPage.login(USRNAME, PSWRD);
        try {
                homePage.cancelFeed();
        }
        catch (Exception e) {
         System.out.println("No pop-up window");
        }
            Assert.assertTrue(homePage.getLogOutBtn().isEnabled(), "You are not logged in");
            homePage.getCreateEntry().click();
            EntryPage entryPage = new EntryPage(driver);
            entryPage.getDeleteBtn().click();
            driver.switchTo().alert().accept();
            Assert.assertTrue(entryPage.getDeleteBtn().isEnabled(), "You are not entry");
//            entryPage.getDeleteBtn().click();
//            homePage.getLogOutBtn().click();
    }
}
