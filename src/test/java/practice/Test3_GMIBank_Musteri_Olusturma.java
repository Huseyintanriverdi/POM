package practice;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import pages.GMIBankPage;
import utilities.ConfigReader;
import utilities.Driver;

public class Test3_GMIBank_Musteri_Olusturma {

    @Test
    public void test(){
        GMIBankPage  gmiBankPage=new GMIBankPage();
        gmiBankPage.GMIBankUserLogin();
        gmiBankPage.myOperationSekmesi.click();
        gmiBankPage.manageCustomers.click();
        gmiBankPage.ilkMusteriEditButonu.click();

        Faker faker =new Faker();
        Actions actions=new Actions(Driver.getDriver());
    gmiBankPage.fakerFirstNameToStart.clear();
    gmiBankPage.fakerFirstNameToStart.click();
    actions.sendKeys(faker.name().name()).sendKeys(Keys.TAB).sendKeys(faker.name().lastName()).sendKeys(Keys.TAB)
            .sendKeys(faker.name().nameWithMiddle()).sendKeys(Keys.TAB).sendKeys(faker.internet().emailAddress()).sendKeys(Keys.TAB)
            .sendKeys(ConfigReader.getProperty("MPhoneNumber")).sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("PhoneNumber"))
            .sendKeys(Keys.TAB).sendKeys(faker.address().zipCode()).sendKeys(Keys.TAB).sendKeys(faker.address().fullAddress())
            .sendKeys(Keys.TAB).sendKeys(faker.address().city()).sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("SSNNumber")).perform();

        Select select =new Select(gmiBankPage.countryDropDown);
        select.selectByVisibleText("USA");
        actions.sendKeys(Keys.TAB).sendKeys(faker.address().state()).perform();
        gmiBankPage.customerManagementSaveButonu.click();

    }
}
