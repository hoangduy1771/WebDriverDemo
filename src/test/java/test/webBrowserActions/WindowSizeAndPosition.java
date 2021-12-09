package test.webBrowserActions;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class WindowSizeAndPosition {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        Actions action = new Actions(driver);
        driver.manage().window().maximize();
        driver.get("https://google.com/");

        driver.manage().window().getSize().getWidth();
        driver.manage().window().getSize().getHeight();

        Dimension size = driver.manage().window().getSize();
        System.out.println(size.getWidth());
        System.out.println(size.getHeight());

        driver.quit();

    }
}
