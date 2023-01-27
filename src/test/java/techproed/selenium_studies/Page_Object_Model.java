package techproed.selenium_studies;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import techproed.utilities.Driver;

public class Page_Object_Model {

    @Test
    public void test1() {
//        GELENEKSEL DRIVER
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();// 1. DRIVER
        driver.manage().window().maximize();
        driver.get("https://testcenter.techproeducation.com/index.php?page=form-authentication");
        driver.findElement(By.id("exampleInputEmail1")).sendKeys("techproed");
//        PAGE OBJECT MODEL DRIVER.
        Driver.getDriver().findElement(By.id("SuperSecretPassword")).sendKeys("SuperSecretPassword");//2.DRIVER

//        BU TEST CASE FAIL EDER CUNKI IKI FARKLI DRIVER KULLANILMAKTADIR
    }
}

