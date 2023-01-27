package techproed.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.TechproHomePage;
import techproed.pages.TechproLoginPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class TechproLoginTest {

    TechproLoginPage techproLoginPage;
    TechproHomePage techproHomePage;
    @Test
    public void testLogin() {
        Driver.getDriver().get(ConfigReader.getProperty("techpro_test_url"));
        techproLoginPage = new TechproLoginPage();
        techproLoginPage.userName.sendKeys(ConfigReader.getProperty("techpro_test_username"));
        techproLoginPage.password.sendKeys(ConfigReader.getProperty("techpro_test_password"));
        techproLoginPage.submitButton.click();

        techproHomePage = new TechproHomePage();
        Assert.assertTrue(techproHomePage.homeHeader.isDisplayed());

        techproHomePage.homeLogoutButton.click();
        Assert.assertTrue(techproLoginPage.submitButton.isDisplayed());

        Driver.closeDriver();
    }
}
