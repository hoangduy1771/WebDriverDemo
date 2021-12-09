package test.locatorsAndSelectors;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class LocatorsAndSelectors {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        Actions action = new Actions(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        driver.get("https://trytestingthis.netlify.app/");
        List<WebElement> options = driver.findElements(By.name("Optionwithcheck[]"));
        for (WebElement option : options) {
            System.out.println(option.getText());
        }

        WebElement firstName = driver.findElement(By.cssSelector("#fname"));
        firstName.sendKeys("Duy");
        action.pause(3000).perform();

        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        WebElement contactBtn = driver.findElement(By.cssSelector(".btn-success"));
        contactBtn.click();
        action.pause(3000).perform();

        driver.quit();
    }

}
