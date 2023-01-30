package techproed.tests.dataprovider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalHomePage;
import techproed.pages.BlueRentalLoginPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ExcelUtils;
import techproed.utilities.ReusableMethods;

import java.io.IOException;

public class Day24_DataProviderTest3 {
//EXCEL DATALARI -> DATA PROVIDER -> TEST METHOD'LARI
//    DATA PROVIDER METHOD
    @DataProvider
    public Object[][] customerData() {
//        DataProviderTest2 ile bu method arasindaki tek fark bu method'da datalar Excel'den gelir
//        Bu kullanim daha guzeldir
        String path = "./src/test/java/resources/mysmoketestdata.xlsx";
        String sheetName = "customer_info";
        ExcelUtils excelUtils = new ExcelUtils(path,sheetName);
        Object[][] musteriBilgileri = excelUtils.getDataArrayWithoutFirstRow();
        return musteriBilgileri;
    }

    BlueRentalHomePage blueRentalHomePage;
    BlueRentalLoginPage blueRentalLoginPage;

    @Test(dataProvider = "customerData")
    public void dataProviderLoginTest(String email, String sifre) throws IOException {
//        Sayfaya git
        Driver.getDriver().get(ConfigReader.getProperty("app_url"));//HOME SAYFASINA
        blueRentalHomePage = new BlueRentalHomePage();
        blueRentalLoginPage = new BlueRentalLoginPage();
        blueRentalHomePage.loginLink.click();
        ReusableMethods.waitFor(1);// 1 saniye bekle
        blueRentalLoginPage.emailBox.sendKeys(email);
        ReusableMethods.waitFor(1);
        blueRentalLoginPage.passwordBox.sendKeys(sifre);
        ReusableMethods.waitFor(1);
        blueRentalLoginPage.loginButton.click();
//         GIRIS YAPILDI
        ReusableMethods.waitFor(1);
        ReusableMethods.verifyElementDisplayed(blueRentalHomePage.userID);//ASSERTION
        ReusableMethods.waitFor(1);
        ReusableMethods.getScreenshot("EkranGoruntusu");
        ReusableMethods.waitFor(1);
        blueRentalHomePage.userID.click();
        ReusableMethods.waitFor(1);
        blueRentalHomePage.logoutLink.click();
        ReusableMethods.waitFor(1);
        blueRentalHomePage.OK.click();
    }
}
