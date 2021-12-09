package test.webBrowserActions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class JavaScriptExecutor {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        Actions action = new Actions(driver);
        driver.manage().window().maximize();
        driver.get("https://google.com/");

        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement button = driver.findElement(By.name("btnI"));
        String text = (String) js.executeScript("return arguments[0].innerText", button);
        js.executeScript("arguments[0].click()", button);
        js.executeScript("console.log('Hello world')");

        driver.get("https://zing.vn");
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");


    }
}
