package techproed.tests.smoketests;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalHomePage;
import techproed.pages.BlueRentalLoginPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
public class Day22_PositiveLoginTest {
    /*
Name: US100201_Admin_Login
Description:
Admin bilgileriyle giriş
Acceptance Criteria:
Admin olarak, uygulamaya giriş yapabilmeliyim
https://www.bluerentalcars.com/
Admin email: jack@gmail.com
Admin password: 12345
     */
    BlueRentalHomePage blueRentalHomePage;
    BlueRentalLoginPage blueRentalLoginPage;
    @Test
    public void US100201_Admin_Login(){
        Reporter.log("SAYFAYA GIT");
        Driver.getDriver().get(ConfigReader.getProperty("app_url"));
        blueRentalHomePage = new BlueRentalHomePage();
        blueRentalLoginPage = new BlueRentalLoginPage();
        Reporter.log("LOGIN BUTONUNA TIKLA");
        blueRentalHomePage.loginLink.click();
        Reporter.log("GIRIS BILGILERINI GIR");
        blueRentalLoginPage.emailBox.sendKeys(ConfigReader.getProperty("admin_email"));
        blueRentalLoginPage.passwordBox.sendKeys(ConfigReader.getProperty("admin_sifre"));
        blueRentalLoginPage.loginButton.click();
        Reporter.log("GIRIS YAPILDIGINI DOGRULA");
        Assert.assertTrue(blueRentalHomePage.userID.isDisplayed());
        Reporter.log("DRIVER'I KAPAT");
        Driver.closeDriver();
    }
}