package techproed.tests.excelautomation;

import org.testng.annotations.Test;
import techproed.pages.BlueRentalHomePage;
import techproed.pages.BlueRentalLoginPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ExcelUtils;
import techproed.utilities.ReusableMethods;

import java.util.List;
import java.util.Map;

public class Day23_ExcelLogin {

    BlueRentalHomePage blueRentalHomePage;
    BlueRentalLoginPage blueRentalLoginPage;
    ExcelUtils excelUtils;
    List<Map<String, String>> excelDatalari;

//    Bu method login sayfasina gitmek icin kullanilacak
    public void login() {
//        Sayfaya git
        Driver.getDriver().get(ConfigReader.getProperty("app_url"));
//        home page login'e tikla
        blueRentalHomePage = new BlueRentalHomePage();
        blueRentalLoginPage = new BlueRentalLoginPage();

//        ------SADECE ILK GIRIS-------
//        loginLink butonu sadece ilk giriste sayfada gorunur
//        Ikinci ve ucuncu girislerde sayfada gorunmeyeceginden NoSuchElementException alinir
//        Biz bu exception'i try-catch kullanarak yakalariz ve test case calismaya devam eder
        try {
            blueRentalHomePage.loginLink.click();
            ReusableMethods.waitFor(1);// 1 saniye bekle
        }catch (Exception e){
        }

//        -------SONRAKI GIRISLER-------
        try {
//            Kullanici id'ye tikla           -> try catch
            blueRentalHomePage.userID.click();
            ReusableMethods.waitFor(1);
//            Logout linkine tikla            -> try catch
            blueRentalHomePage.logoutLink.click();
            ReusableMethods.waitFor(1);
//            OK'e tikla                      -> try catch
            blueRentalHomePage.OK.click();
            ReusableMethods.waitFor(1);
//            home page Login linkine tikla   -> try catch
            blueRentalHomePage.loginLink.click();
            ReusableMethods.waitFor(1);
        }catch (Exception e){
        }
    }

    @Test
    public void customerLogin() {
        String path = "./src/test/java/resources/mysmoketestdata.xlsx";
//                     ./ ONCEKI TUM DOSYALARI ICER. RELATIVE PATH
        String sheetName = "customer_info";
//        DATALARI EXCEL UTILS METHOD'LARINI KULLANARAK BURAYA ALACAGIZ
        excelUtils = new ExcelUtils(path,sheetName);
//        Excel data'larini getDataList method'u ile cekelim
        excelDatalari = excelUtils.getDataList();
//        LOOP KULLANARAK DATALARI TEK TEK TEST CASE'DE KULLAN
        for (Map<String,String> data : excelDatalari) {
            login();// Her Loop'da Login Sayfasina Goturecek
            ReusableMethods.waitFor(1);
//            Kullanici adini gir
            blueRentalLoginPage.emailBox.sendKeys(data.get("username"));
            ReusableMethods.waitFor(1);
//            Kullanici sifresini gir
            blueRentalLoginPage.passwordBox.sendKeys(data.get("password"));
            ReusableMethods.waitFor(1);
//            Login butonuna tikla
            blueRentalLoginPage.loginButton.click();
        }

    }

}

/*
sam.walker@bluerentalcars.com	c!fas_art
kate.brown@bluerentalcars.com	tad1$Fas
raj.khan@bluerentalcars.com	v7Hg_va^
pam.raymond@bluerentalcars.com	Nga^g6!

-----ILK GIRIS-------
HOME PAGE'DEYIZ
home page login'e tikla
LOGIN PAGE'DEYIZ
kullanici adini gir (Excel'den al)
kullanici sifresini gir (Excel'den al)
login page'deki login butonuna tikla
------2. GIRIS------
HOME PAGE'DEYIZ
kullanici ID'ye tikla
Logout butonuna tikla
OK'e tikla
home page login'e tikla
LOGIN PAGE'DEYIZ
kullanici adini gir (Excel'den al)
kullanici sifresini gir (Excel'den al)
login page'deki login butonuna tikla
-----3. GIRIS-------
HOME PAGE'DEYIZ
kullanici ID'ye tikla
Logout butonuna tikla
OK'e tikla
home page login'e tikla
LOGIN PAGE'DEYIZ
kullanici adini gir (Excel'den al)
kullanici sifresini gir (Excel'den al)
login page'deki login butonuna tikla
---------4. GIRIS------------
HOME PAGE DEYIZ
kullanici ID ye tikla
Logout linkine tikla
OK e tikla
home page logine tikla
LOGIN PAGE DEYIZ
kullanici adini gir(excelden al)
kullanici sifresini git(excelden al)
login page login buttonuna tikla

 */