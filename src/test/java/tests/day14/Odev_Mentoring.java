package tests.day14;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.TestBase;

public class Odev_Mentoring extends TestBase {
    @Test
    public void test(){
        /*
    go to url : http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html
    Fill in capitals by country
     */
        driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
        Actions actions=new Actions(driver);
        actions.dragAndDrop(driver.findElement(By.id("box3")),driver.findElement(By.id("box103"))).perform();
        actions.dragAndDrop(driver.findElement(By.id("box1")),driver.findElement(By.id("box101"))).perform();
        actions.dragAndDrop(driver.findElement(By.id("box2")),driver.findElement(By.id("box102"))).perform();
        actions.dragAndDrop(driver.findElement(By.id("box4")),driver.findElement(By.id("box104"))).perform();
        actions.dragAndDrop(driver.findElement(By.id("box5")),driver.findElement(By.id("box105"))).perform();
        actions.dragAndDrop(driver.findElement(By.id("box6")),driver.findElement(By.id("box106"))).perform();
        actions.dragAndDrop(driver.findElement(By.id("box7")),driver.findElement(By.id("box107"))).perform();

    }
}
