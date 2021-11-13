package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.List;

public class QAConcortPage {
public   WebDriver driver;
    public QAConcortPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(linkText = "Log in")
    public WebElement ilkLoginLinki;
    @FindBy(id="UserName")
    public WebElement usernameKutusu;
    @FindBy(id="Password")
    public WebElement passwordKutusu;
    @FindBy(id="btnSubmit")
    public WebElement loginButonu;
    @FindBy(xpath="//span[text()='ListOfUsers']")
    public WebElement basariliGirisYaziElementi;
    @FindBy (xpath = "//*[.='Try again please']")
    public WebElement loginFailedYazisi;
    @FindBy(xpath = "//span[text()='Hotel Management']")
    public WebElement hotelManagementLinki;
    @FindBy(partialLinkText = "Hotel List")
    public WebElement hotelListLink;
    @FindBy(xpath = "//span[text()='Add Hotel ']")
    public WebElement addHotelLink;
    @FindBy(id = "Code")
    public WebElement addHotelCodeKutusu;
    @FindBy(partialLinkText = "Hotel Rooms")
    public WebElement hotelRoomsLink;
    @FindBy(xpath = "//span[text()='Add Hotelroom ']")
    public WebElement addAddHotelRoomButton;
    @FindBy(id = "IDHotel")
    public WebElement addRoomIdDropDown;
    @FindBy(id = "IDGroupRoomType")
    public WebElement addRoomTypeDropDown;
    @FindBy(id = "btnSubmit")
    public WebElement addRoomSaveButonu;
    @FindBy(xpath = "//div[@class='bootbox-body']")
    public WebElement addRoomSuccessfulYazisi;
    @FindBy(xpath = "//button[@class='btn btn-primary']")
    public WebElement addRoomAllertOkbutonu;
    @FindBy(linkText = "Hotelrooms")
    public WebElement addRoomHotelRoomsLink;
    @FindBy(xpath = "//span[text()='Lıst Of Hotelrooms']")
    public WebElement addRoomHotelRoomListYazisi;
    @FindBy(xpath = "//thead/tr[1]/th")
    public List<WebElement> basliklarListesi;
    @FindBy(xpath = "//tbody")
    public WebElement tBodyTumu;
    @FindBy(xpath = "//tbody//tr")
    public List<WebElement> satirlarListesi;

    @FindBy(xpath = "//tbody//tr[1]")
    public WebElement birinciSatir;
    @FindBy(xpath = "//tbody//tr//td[4]")
    public List<WebElement> dorduncuSutunListesi;




    public void ConcortHotelLogin(){
        Driver.getDriver().get(ConfigReader.getProperty("CHQAUrl"));
        QAConcortPage qaConcortPage=new QAConcortPage();
        qaConcortPage.ilkLoginLinki.click();
        qaConcortPage.usernameKutusu.sendKeys(ConfigReader.getProperty("CHQAValidUsername"));
        qaConcortPage.passwordKutusu.sendKeys(ConfigReader.getProperty("CHQAValidPassword"));
        qaConcortPage.loginButonu.click();
    }

    public String printData(int satir, int sutun) {
        //ornekteki hali ile 3. satir 5. sutuntaki elemani yazdiralim
        // String xpath =//tboyd//tr[3]//td[5]
        //degismeyecek kisimlari string olarak, degisecekler kisimlari ise parametre  ismi olarak yazdik

        String xpath="//tboyd//tr["+satir+"]//td["+sutun+"]";
        //@FindBy notasyonu parametreli calismadigi icin, onceki yontemle locate edelim
       String istenenData= Driver.getDriver().findElement(By.xpath(xpath)).getText();
        System.out.println("satir no "+satir+", sutun no : "+sutun+" deki data : "+istenenData);
        return istenenData;
    }
}
