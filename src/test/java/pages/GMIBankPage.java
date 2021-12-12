package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
import utilities.Driver;

public class GMIBankPage {
public GMIBankPage(){
    PageFactory.initElements(Driver.getDriver(),this);

}
@FindBy(xpath = "//*[@class='svg-inline--fa fa-user fa-w-14 ']")
    public WebElement ilkGirisButonu;
@FindBy(xpath = "//span[text()='Sign in']")
    public WebElement signInButonu;
@FindBy(xpath = "//span[text()='Register']")
    public WebElement registerButonu;
@FindBy(xpath = "//input[@name='username']")
public WebElement loginUserNameTextBox;
@FindBy(xpath = "//input[@name='password']")
public WebElement loginPasswordTextBox;
@FindBy(xpath = "//button[@class='btn btn-primary']")
public WebElement ikinciSignInButonu;
@FindBy(xpath = "//*[text()='employee73 employee73']")
public WebElement sagUstteKullaniciIsmi;
@FindBy (xpath = "//*[text()='My Operations']")
public WebElement myOperationSekmesi;
@FindBy (xpath = "//*[text()='Manage Customers']")
public WebElement manageCustomers;

    @FindBy(xpath = "//span[text()='Sign out']")
    public WebElement signOutButonu;
    @FindBy (xpath = "(//*[@class='svg-inline--fa fa-pencil-alt fa-w-16 '])[1]")
    public WebElement ilkMusteriEditButonu;
    @FindBy (xpath = "//input[@name='firstName']")
    public WebElement fakerFirstNameToStart;
    @FindBy (id = "tp-customer-country")
    public WebElement countryDropDown;
    @FindBy (xpath = "//span[text()='Save']")
    public WebElement customerManagementSaveButonu;

public void GMIBankUserLogin(){
    Driver.getDriver().get(ConfigReader.getProperty("GMIBankUrl"));
    GMIBankPage gmiBankPage =new GMIBankPage();
    gmiBankPage.ilkGirisButonu.click();
    gmiBankPage.signInButonu.click();
    gmiBankPage.loginUserNameTextBox.sendKeys(ConfigReader.getProperty("GMIBankEmployeeValidUserName"));
    gmiBankPage.loginPasswordTextBox.sendKeys(ConfigReader.getProperty("GMIBankEmployeeValidPassoword"));
    gmiBankPage.ikinciSignInButonu.click();

}
}
