import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    private static final String USRNAME = "rabchinskij_sm@tut.by";
    private static final String PSWRD = "Dimosik16";

    @Test(groups = "positive")
    public void LoginTest() {
        HomePage homePage = loginPage.login(USRNAME, PSWRD);
        try {
            homePage.cancelFeed();
        } catch (Exception e) {
            System.out.println("No pop-up window 1");
        }
        Assert.assertTrue(homePage.getLogOutBtn().isEnabled(), "user is not logged in");
        System.out.println("user is logged in");
//        homePage.getCreateEntry().click();
//        EntryPage entryPage = new EntryPage(driver);
//        entryPage.getDeleteBtn().click();
//        driver.switchTo().alert().accept();
//        Assert.assertTrue(entryPage.getDeleteBtn().isEnabled(), "Note is not deleted");
        homePage.getLogOutBtn().click();
        try {
            loginPage.logOutCancelFeed();
        } catch (Exception e) {
            System.out.println("No pop-up window 2");
        }
        Assert.assertTrue(loginPage.getLoginButton().isEnabled(), "user is not logged out");
        System.out.println("user logged out");

    }

    @Test(groups = "negative")
    public void NotLoginTest() {
        HomePage homePage = loginPage.notlogin(USRNAME, PSWRD);
        Assert.assertTrue(loginPage.getLoginButton().isEnabled(), "You are logged in");

    }
}
