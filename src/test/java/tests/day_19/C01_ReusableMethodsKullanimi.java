package tests.day_19;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.Set;

public class C01_ReusableMethodsKullanimi {
    @Test
    public void test(){
    //https://the-internet.herokuapp.com/windows adresine gidelim
        // click here yazisina basalim

        Driver.getDriver().get("https://the-internet.herokuapp.com/windows");
        String ilkSayfaHandle=Driver.getDriver().getWindowHandle();
        Driver.getDriver().findElement(By.linkText("Click Here")).click();
        Set<String> windowHandleKumesi=Driver.getDriver().getWindowHandles();
        String ikinciSAyfaHandleDegeri="";

        for (String each:windowHandleKumesi
             ) {
            if (!each.equals(ilkSayfaHandle)){
                ikinciSAyfaHandleDegeri=each;
            }
        }
        Driver.getDriver().switchTo().window(ikinciSAyfaHandleDegeri);
        System.out.println(Driver.getDriver().getTitle());
        //yeni sayafada new window yazisinin gorundugunu test edelim
        WebElement newWindowYaziElementi=Driver.getDriver().findElement(By.tagName("h3"));
        Assert.assertTrue(newWindowYaziElementi.isDisplayed());
}
    @Test
    public void testReusable(){
        Driver.getDriver().get("https://the-internet.herokuapp.com/windows");
        Driver.getDriver().findElement(By.linkText("Click Here")).click();
        ReusableMethods.switchToWindow("New Window");

        WebElement newWindowYaziElementi=Driver.getDriver().findElement(By.tagName("h3"));
        Assert.assertTrue(newWindowYaziElementi.isDisplayed());
        Driver.closeDriver();
    }
}
