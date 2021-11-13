package tests.day14;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ConcortHotelPage;
import utilities.ConfigReader;
import utilities.TestBase;

public class C05_NegativeTestConfigReader extends TestBase {
    @Test(groups = "birinciGrup")
    public void test(){
        driver.get(ConfigReader.getProperty("CHUrl"));
        ConcortHotelPage concortHotelPage=new ConcortHotelPage(driver);
        concortHotelPage.ilkLoginLinki.click();
        concortHotelPage.usernameKutusu.sendKeys(ConfigReader.getProperty("CHInvalidUserName"));
        concortHotelPage.passwordKutusu.sendKeys(ConfigReader.getProperty("CHInvalidPassword"));
        Assert.assertTrue(concortHotelPage.loginFailedYazisi.isDisplayed(),"giris Basarisiz");
    }
}
