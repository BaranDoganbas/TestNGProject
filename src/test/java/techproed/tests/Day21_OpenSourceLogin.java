package techproed.tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.OpenSourceDashboardPage;
import techproed.pages.OpenSourcePage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class Day21_OpenSourceLogin {
    //    https://opensource-demo.orangehrmlive.com/web/index.php/auth/login
    //    Page Class : OpenSourcePage
    //    kullaniciAdi, kullaniciSifre, submitButton elementlerini bul
    //    Test Class : OpenSourceLogin
    //    Page objesi olustur
    //    Login Testini basarili oldugunu test et
    OpenSourcePage openSourcePage;
    OpenSourceDashboardPage openSourceDashboardPage;
    @Test
    public void openSourceLogin() throws InterruptedException {
//        1. Sayfaya git
//        Driver.getDriver().get(ConfigReader.getProperty("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"));
        Driver.getDriver().get(ConfigReader.getProperty("open_source_url"));

//        2. Page Objecti'i olustur
        openSourcePage = new OpenSourcePage();

//        3. Bu object'i kullanarak o class'daki object'lere ulas
        openSourcePage.username.sendKeys(ConfigReader.getProperty("open_source_username"));
        openSourcePage.password.sendKeys(ConfigReader.getProperty("open_source_password"));
        openSourcePage.loginButton.click();

//        4. Assertion
        openSourceDashboardPage = new OpenSourceDashboardPage();
        Assert.assertTrue(openSourceDashboardPage.dashboardHeader.isDisplayed());

//        5. Driver'i kapat
        Driver.closeDriver();

    }
}
