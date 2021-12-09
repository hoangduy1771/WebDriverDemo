package test.Waits;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class FluentWait {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        Actions action = new Actions(driver);
        driver.manage().window().maximize();

        driver.get("https://google.com/");

        WebElement inputField = driver.findElement(By.name("q"));
        inputField.sendKeys("What time is it in Vietnam?", Keys.ENTER);

//        Fluent Wait
        Wait<WebDriver> fluentWait = new org.openqa.selenium.support.ui.FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(10))
                .ignoring(NoSuchElementException.class);

        WebElement link = fluentWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='https://time.is/vi/Vietnam']")));
        link.click();

        driver.close();
    }
}
