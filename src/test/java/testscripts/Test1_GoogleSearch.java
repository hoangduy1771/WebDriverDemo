package testscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import test.pageObjectModel.GoogleSearchPage;

public class Test1_GoogleSearch {
    public static void main(String[] args) {
        googleSearchTestScript();
    }

    public static void googleSearchTestScript() {
        ChromeOptions options = new ChromeOptions();
//        options.addArguments("incognito");
//        options.addArguments("--headless");
//        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        Actions action = new Actions(driver);
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");

        GoogleSearchPage.searchTextBox(driver).sendKeys("What time is it?", Keys.ENTER);
        driver.navigate().back();
        action.pause(3000).perform();
        driver.findElement(By.xpath("//a[text()='English']")).click();
        action.pause(3000).perform();
        GoogleSearchPage.searchButton(driver).click();
        action.pause(3000).perform();
        GoogleSearchPage.feelingLuckyButton(driver).click();

        action.pause(3000).perform();
        driver.quit();
    }
}
