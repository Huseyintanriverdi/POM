package tests.day13;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FacebookPage;
import utilities.TestBase;

public class C02_PagesFacebook extends TestBase {

    @Test
    public void test(){
        // facebook login sayfasina gidin
        driver.get("https://www.facebook.com/");
        FacebookPage facebookPage=new FacebookPage(driver);
// kullanici adi : techproed
        facebookPage.mailKutusu.sendKeys("techproed");
// sifre : 12345
        facebookPage.passKutusu.sendKeys("12345");
        facebookPage.loginButonu.click();
// yazdigimizda giris yapamadigimizi test edin
        Assert.assertTrue(facebookPage.redAlert.isDisplayed(),"giris basarili sekilde gerceklestirildi");

    }
}
