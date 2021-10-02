import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistTest extends BaseTest {

    private static final String EMAIL = "RabchynskiS@yandex.by";
    private static final String INVALIDEMAIL = "1234";
    private static final String PSWRD = "Stand1234";
    private static final String SHORTPASS = "St12";
    private static final String INVALIDPASS = "Станд1234";
    private static final String PSWRDCONF = "Stand1234";
    private static final String PSWRDHINT = "Stand1234";

    @Test(groups = "positive")
    public void RegistrationWindowTest() {
        RegistPage registPage = loginPage.regist();
        Assert.assertFalse(registPage.getOkBtn().isEnabled(), "OkBtn should be disabled");
        System.out.println(registPage.getExplanation().getText());
    }

    @Test
    public void RegistrationTest() {
        RegistPage registPage = loginPage.regist();
        System.out.println(registPage.getExplanation().getText());
        Assert.assertFalse(registPage.getOkBtn().isEnabled(), "OkBtn should be disabled");
        RegResultPage resultPage = registPage.registration(EMAIL, PSWRD, PSWRDCONF, PSWRDHINT);
        Assert.assertEquals(resultPage.getUserReg().getText(), "Registration", "User is not registered");
        System.out.println("Confirm your registration using the link sent by email");
    }

    @Test
    public void ValidPassTest() {
        RegistPage registPage = loginPage.regist();
        System.out.println(registPage.getExplanation().getText());
        Assert.assertFalse(registPage.getOkBtn().isEnabled(), "OkBtn should be disabled");
        registPage.enterPass(PSWRD);
        Assert.assertTrue(registPage.getOkBtn().isEnabled(), "OkBtn should be enabled");
        System.out.println(registPage.getPasswordIndicator().getText());
    }

    @Test
    public void ShortPass() {
        RegistPage registPage = loginPage.regist();
        System.out.println(registPage.getExplanation().getText());
        Assert.assertFalse(registPage.getOkBtn().isEnabled(), "OkBtn should be disabled");
        registPage.enterPass(SHORTPASS);
        Assert.assertFalse(registPage.getOkBtn().isEnabled(), "OkBtn should be disabled");
        System.out.println(registPage.getPasswordIndicator().getText());
    }

    @Test
    public void InvalidPass() {
        RegistPage registPage = loginPage.regist();
        System.out.println(registPage.getExplanation().getText());
        Assert.assertFalse(registPage.getOkBtn().isEnabled(), "OkBtn should be disabled");
        registPage.enterPass(INVALIDPASS);
        Assert.assertFalse(registPage.getOkBtn().isEnabled(), "OkBtn should be disabled");
        System.out.println(registPage.getPasswordIndicator().getText());
    }

    @Test(groups = "negative")
    public void InvalidEmailTest() {
        RegistPage registPage = loginPage.regist();
        System.out.println(registPage.getExplanation().getText());
        Assert.assertFalse(registPage.getOkBtn().isEnabled(), "OkBtn should be disabled");
        registPage.invalidEmail(INVALIDEMAIL, PSWRD, PSWRDCONF, PSWRDHINT);
        System.out.println(registPage.getAlert().getText());
        System.out.println(registPage.getHelpBlock().getText());
    }

//        System.out.println("start registration");
//        registPage.getRegEmail().click();
////        Assert.assertEquals(registPage.getRegEmail().getText(), "", "Clear Email");
////        registPage.getRegPass().clear();
//        registPage.getRegEmail().sendKeys(USRNAME);
//        registPage.getRegPass().click();
//        registPage.getRegPass().sendKeys(PSWRD);
//        Assert.assertTrue(registPage.getOkBtn().isEnabled(),"Ok is not Enabled");
////        registPage.getOkBtn().click();
//        registPage.getRegPassConfirm().click();
//        registPage.getRegPassConfirm().sendKeys(PSWRDCONF);
//        registPage.getTermsOfUseChBox().click();
//        registPage.getWarningChBox().click();
//        System.out.println(registPage.getRegEmail().getAttribute(toString()));
//        registPage.getOkBtn().click();

//        Assert.assertEquals(registPage.getRegEmail().getText(),"1@tut.by","Correct");
//        System.out.println("correct");

}
