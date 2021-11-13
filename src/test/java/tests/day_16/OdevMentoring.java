package tests.day_16;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

import java.util.Random;

public class OdevMentoring extends TestBase {
    @Test
    public void test() throws InterruptedException {
        //  *  Open "https://courses.ultimateqa.com/users/sign_up"
        driver.get("https://courses.ultimateqa.com/users/sign_up");
        //     *  create random and valid first name, last name, email and password, store for later validating
        //     *  fill in account submission form with data above
        //     *  Click on checkbox with id="user[terms]" to agree with terms and conditions
        //     *  click on "Sign up" button
        Faker faker=new Faker();
        Actions actions=new Actions(driver);
        String name=faker.name().name();
        String lastNAme=faker.name().lastName();
        String eMail=faker.internet().emailAddress();
        String passWord=faker.internet().password();
        actions.sendKeys(name)
                .sendKeys(Keys.TAB)
                .sendKeys(lastNAme)
                .sendKeys(Keys.TAB)
                .sendKeys(eMail)
                .sendKeys(Keys.TAB)
                .sendKeys(passWord)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.SPACE)
                .click(driver.findElement(By.xpath("//input[@value='Sign up']")))

                .perform();


        //     *  go to https://courses.ultimateqa.com/account
        Thread.sleep(20000);
        driver.get("https://courses.ultimateqa.com/account");
//        actions.sendKeys("ahmet1@mehmet.com")
//                .sendKeys(Keys.TAB)
//                .sendKeys("12345678")
//                .click(driver.findElement(By.xpath("//input[@value='Sign up']")))
//                .perform();
        //     *  validate that first name, last name and email you provided earlier is correct
     //  SoftAssert softAssert=new SoftAssert();
//        Thread.sleep(3000);
      Assert.assertEquals(driver.findElement(By.xpath("(//input[@class='form__control'])[1]")).getText(),eMail);
//        Thread.sleep(3000);
//       Assert.assertEquals(driver.findElement(By.id("(//input[@class='form__control'])[2]")).getText(),name);
//        Thread.sleep(3000);
//       Assert.assertEquals(driver.findElement(By.id("(//input[@class='form__control'])[3]")).getText(),lastNAme);




        //     *
        //     * Part 2 (Optional)
        //     *  sign out of the website
        driver.findElement(By.xpath("//a[@class='dropdown__toggle-button']")).click();
        driver.findElement(By.partialLinkText("Sign Out")).click();

        //     *  go to "https://courses.ultimateqa.com/users/sign_in"
        Thread.sleep(2000);
        driver.findElement(By.partialLinkText("Sign In")).click();
        //     *  fill in sign in form with your stored email and password
        //     *  click on "Sign in" button
        Thread.sleep(2000);
     driver.findElement(By.id("user[email]")).sendKeys(eMail);
     driver.findElement(By.id("user[password]")).sendKeys(passWord);
        driver.findElement(By.xpath("//input[@value='Sign up']")).click();

        //     *  validate that message "Signed in successfully." is displayed
        //     *
        //     * NOTE:Captcha on this website is un-avoidable,
        //     * so you will have to solve it by hand to allow script to continue
    }
}
