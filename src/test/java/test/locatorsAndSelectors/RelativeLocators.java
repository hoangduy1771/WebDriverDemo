package test.locatorsAndSelectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.locators.RelativeLocator;

public class RelativeLocators {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        Actions action = new Actions(driver);

        driver.get("https://opensource-demo.orangehrmlive.com/");

        WebElement loginBtn = driver.findElement(By.id("btnLogin"));
        WebElement passwordInput = driver.findElement(RelativeLocator.with(By.tagName("input")).above(loginBtn));
//        action.doubleClick(passwordInput).perform();
        passwordInput.sendKeys("AAAA");

        action.pause(3000).perform();

        driver.close();
    }
}
