package test.webBrowserActions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Frame {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        Actions action = new Actions(driver);

        driver.get("https://www.selenium.dev/selenium/docs/api/java/index.html?overview-summary.html");
        action.pause(3000).perform();
        driver.switchTo().frame("packageFrame");
        driver.findElement(By.linkText("Action")).click();
        action.pause(3000).perform();

        driver.close();

    }
}
