package tests.day14;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ConcortHotelPage;
import utilities.ConfigReader;
import utilities.TestBase;

public class C03_PositiveTestConfigReaderIle extends TestBase {

    @Test
    public void PositiveTestConfig(){
        //        https://www.concorthotel.com/ adresine git
        driver.get(ConfigReader.getProperty("CHUrl"));
        ConcortHotelPage concortHotelPage=new ConcortHotelPage(driver);
        //login butonuna bas
        concortHotelPage.ilkLoginLinki.click();
        //username manager
        concortHotelPage.usernameKutusu.sendKeys(ConfigReader.getProperty("CHValidUsername"));
        //username Manager1!
        concortHotelPage.usernameKutusu.sendKeys(ConfigReader.getProperty("CHValidPassword"));
        concortHotelPage.loginButonu.click();

        Assert.assertTrue(concortHotelPage.basariliGirisYaziElementi.isDisplayed(),"basarili sekilde giris yapilamadi");

    }
}
