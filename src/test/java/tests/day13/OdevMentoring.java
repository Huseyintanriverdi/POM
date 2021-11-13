package tests.day13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.util.List;

public class OdevMentoring extends TestBase {
    @Test
    public void test() throws InterruptedException {
        /*
    ~ Navigate to http://tutorialsninja.com/demo/index.php?route=common/home
    ~ click on Phones & PDAs
    ~ get the brandName of phones
    ~ click on add to button for all elements
    ~ click on black total added cart button
    ~ get the names of list from the cart
    ~ compare the names from displaying list and cart list

     */
    driver.get("http://tutorialsninja.com/demo/index.php?route=common/home");
    driver.findElement(By.linkText("Phones & PDAs")).click();
    List<WebElement> listOfPhones=driver.findElements(By.tagName("h4"));
        for (WebElement each:listOfPhones
             ) {
            System.out.println(each.getText());

        }
        List<WebElement> addToCart = driver.findElements(By.xpath("//span[text()='Add to Cart']"));
        for (WebElement w : addToCart) {
            Thread.sleep(5000);
            w.click();
        }
        Thread.sleep(2000);
        driver.findElement(By.id("cart-total")).click();
        List<WebElement> itemsOnChartList=driver.findElements(By.xpath("//td[@class='text-left']"));
        for (WebElement each:itemsOnChartList
             ) {
            System.out.println(each.getText());

        }
    Assert.assertTrue(listOfPhones.listIterator().next().getText().contains(itemsOnChartList.listIterator().next().getText()));
    }
}
