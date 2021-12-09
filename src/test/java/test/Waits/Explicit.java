package test.Waits;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Explicit {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        Actions action = new Actions(driver);
        driver.manage().window().maximize();

        driver.get("https://google.com/");

        WebElement inputField = driver.findElement(By.name("q"));
        inputField.sendKeys("What time is it in Vietnam?", Keys.ENTER);

//        Explicit wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement link =
                wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//a[@href='https://time.is/vi/Vietnam']"))));

        link.click();
        driver.quit();
    }
}
