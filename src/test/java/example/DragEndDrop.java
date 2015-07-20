package example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class DragEndDrop {

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new FirefoxDriver();
        driver.get("https://dl.dropboxusercontent.com/u/55228056/DragDropDemo.html");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void dragEndDropExample() {
        WebElement target = driver.findElement(By.id("droppable"));
        WebElement sors = driver.findElement(By.id("draggable"));

        Actions builder = new Actions(driver);
        builder.dragAndDrop(sors, target).perform();

        assertEquals("Dropped!", target.getText());

    }
}

