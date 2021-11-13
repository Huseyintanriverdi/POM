package tests.day_15;

import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

public class C01_DriverClassKullanimi {
    @Test
    public void test(){
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        Driver.getDriver().get(ConfigReader.getProperty("CHUrl"));
        Driver.getDriver().get(ConfigReader.getProperty("youtubeUrl"));
        Driver.getDriver().get(ConfigReader.getProperty("googleUrl"));
  //  Driver driver =new Driver();
//TOdo driver classindan obje uretilemesin istedigimiz icin driver classi SINGLETON yapiyoruz.
// bunun icin def const yerine parametresiz private cons olusturuyoruz.

        Driver.closeDriver();
    }
}
