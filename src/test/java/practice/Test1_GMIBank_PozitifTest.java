package practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.GMIBankPage;
import utilities.ConfigReader;

public class Test1_GMIBank_PozitifTest {
@Test
    public void SignInTesti(){
    GMIBankPage gmiBankPage=new GMIBankPage();
    gmiBankPage.GMIBankUserLogin();
    Assert.assertTrue(gmiBankPage.sagUstteKullaniciIsmi.isDisplayed());
}
@Test
    public void SignOutTest(){
    GMIBankPage gmiBankPage=new GMIBankPage();
    gmiBankPage.sagUstteKullaniciIsmi.click();
    gmiBankPage.signOutButonu.click();
}
}
