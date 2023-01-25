package techproed.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import techproed.utilities.Driver;

public class FirstTestNG {

    @Test
    public void firstAttempt() {
        Driver.getDriver().get("youtube_url");
        Fi("youtube_searchbox_xpath")
    }

}
