package utilities;

import org.jsoup.select.Evaluator;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    //Todo 1- Properties objesi olusturacagiz
  static  Properties properties;
    // Todo    2- Bu classin amaci configuration.properties dosyasini okumak
    // ve oradaki key value ikililerini kullanarak istedigimiz key e ait value yi
    // bize getirmek
    static {
        String dosyaYolu= "configuration.properties";

        try {
            FileInputStream fileInputStream=new FileInputStream(dosyaYolu);
            properties=new Properties();
            properties.load(fileInputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //Todo    3- Test classlarindan cogfigreader classina ulasip yukaridaki islemleri
    // yapmamizi saglayacak bir method olusturacagiz
    public static String getProperty(String key){
        String value=properties.getProperty(key);
        return value;
    }
}
