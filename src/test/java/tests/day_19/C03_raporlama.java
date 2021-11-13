package tests.day_19;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class C03_raporlama  extends TestBaseRapor {

    @Test
    public void test1(){
        extentTest=extentReports.createTest("Nutella testi","sonuc sayisi 1000 den az olmali");
        // amazon sayfasina gidip
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        extentTest.pass("amazon sayfasina gidildi");
        // nutella icin arama yapalim
        WebElement aramaKutusu=Driver.getDriver().findElement(By.id("twotabsearchtextbox"));

        aramaKutusu.sendKeys(ConfigReader.getProperty("amazonArananKelime")+Keys.ENTER);
        extentTest.pass("nutella aramasi yapildi");

        // sonuc sayisinin 1000'den az oldugunu test edelim
       WebElement sonucSayisiElementi=Driver.getDriver().findElement(By.xpath("(//span[@dir='auto'])[1]"));
       String sonucYazisi=sonucSayisiElementi.getText();
       String sonucArrayi[]=sonucYazisi.split(" ");
       int sonucSayisi= Integer.parseInt(sonucArrayi[2]);
       extentTest.info("sonuc yazisi int haline getirildi");
        Assert.assertTrue(sonucSayisi<1000);
       extentTest.pass("sonuc sayisinin 1000 den az oldugu test edildi");
    }
    @Test
    public void test2(){


        // sonuc sayisinin 1000'den az oldugunu test edelim
        extentTest=extentReports.createTest("Samsung testi","sonuc sayisi 1000 den fazla olmali");
        // amazon sayfasina gidip
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        extentTest.pass("amazon sayfasina gidildi");
        // samsung icin arama yapalim
        WebElement aramaKutusu=Driver.getDriver().findElement(By.id("twotabsearchtextbox"));

        aramaKutusu.sendKeys("Samsung"+Keys.ENTER);
        extentTest.pass("samsung aramasi yapildi");

        // sonuc sayisinin 1000'den fazla oldugunu test edelim
        WebElement sonucSayisiElementi=Driver.getDriver().findElement(By.xpath("(//span[@dir='auto'])[1]"));
        String sonucYazisi=sonucSayisiElementi.getText();
        String sonucArrayi[]=sonucYazisi.split(" ");
        String sonucAdedi=sonucArrayi[3];
         sonucAdedi=sonucAdedi.replace(",","");
        int sonucSayisi= Integer.parseInt(sonucAdedi);
        extentTest.info("sonuc yazisi int haline getirildi");
        Assert.assertTrue(sonucSayisi>1000);
        extentTest.pass("sonuc sayisinin 1000 den fazla oldugu test edildi");
    }
    @Test
    public void test3(){
        // amazon sayfasina gidip
        // electronic kategorisinde java icin arama yapalim
        // cikan sonuclardan ilkinin isminde java oldugunu test edelim
    }
}
