package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class OpenSourcePage {

//    Page Object'lerini bu sinifta buluruz

//    1. Constuctor
    public OpenSourcePage() {
//        PageFactory selenium'dan gelen ve bu sayfa elementlerini intantiate etmek icin kullanilir
//        Bu sekilde sayfa objeleri cagrildiginda NullPointerException alinmaz
        PageFactory.initElements(Driver.getDriver(), this);
    }

//    PAGE OBJECT'LERINI OLUSTUR
//    public WebElement username = Driver.getDriver().findElement(By.name("username"));
    @FindBy(name = "username")
    public WebElement username;

    @FindBy(name = "password")
    public WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement loginButton;


}
