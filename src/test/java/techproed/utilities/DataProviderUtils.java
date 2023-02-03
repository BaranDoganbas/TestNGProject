package techproed.utilities;

import org.testng.annotations.DataProvider;

public class DataProviderUtils {

    @DataProvider
    public Object[][] musteriVerileri() {
        Object[][] musteriGirisBilgileri = {
                {"menajer1", "12345", "besiktas"},
                {"menajer2", "98765", "cebeci"},
                {"menajer3", "5678", "karsiyaka"}
        };
        return musteriGirisBilgileri;
    }

    @DataProvider
    public Object[][] musteriHizmetleriVerileri() {
        Object[][] musteriHizmetleriGirisBilgileri = {
                {"adam", "3456"},
                {"ali", "1234"},
                {"nancy", "7890"}
        };
        return musteriHizmetleriGirisBilgileri;
    }

    @DataProvider
    public Object[][] personelVerileri() {
        Object[][] personelGirisBilgileri = {
                {"Rukiye", "abc1"},
                {"Mehmet", "123r"},
                {"Emin", "6e45"},
                {"Baran", "4asd"},
                {"Okumus", "3edc"}
        };
        return personelGirisBilgileri;
    }

    //    Excel'den dataProvider'a data gelir
//    Burdan da Test case'e gider
    @DataProvider
    public Object[][] customerData() {
//        DataProviderTest2 ile bu metot arasindaki tek fark bu metotda datalar Excelden gelir.
//        Bu kullanim daha guzeldir
        String path = "./src/test/java/resources/mysmoketestdata.xlsx";
        String sheetName = "customer_info";
        ExcelUtils excelUtils = new ExcelUtils(path, sheetName);
        Object[][] musteriBilgileri = excelUtils.getDataArrayWithoutFirstRow();
        return musteriBilgileri;
    }


}
