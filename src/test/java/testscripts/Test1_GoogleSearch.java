package testscripts;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import test.pageObjectModel.GoogleSearchPage;

public class Test1_GoogleSearch {
    public static void main(String[] args) {
        googleSearchTestScript();
    }

    public static void googleSearchTestScript() {
        WebDriver driver = new ChromeDriver();
        Actions action = new Actions(driver);
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");

        GoogleSearchPage.searchTextBox(driver).sendKeys("What time is it?", Keys.ENTER);
        driver.navigate().back();
        GoogleSearchPage.searchButton(driver).click();
        action.pause(3000).perform();
        GoogleSearchPage.feelingLuckyButton(driver).click();

        action.pause(3000).perform();
        driver.quit();
    }
}
