package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleSearchPage {
    private static WebElement element = null;

    public static WebElement searchTextBox(WebDriver driver) {
        return element = driver.findElement(By.name("q"));
    }

    public static WebElement searchButton(WebDriver driver) {
        return element = driver.findElement(By.xpath("(//input[@name='btnK'])[2]"));
    }

    public static WebElement feelingLuckyButton(WebDriver driver) {
        return element = driver.findElement(By.xpath("(//input[@name='btnI'])[2]"));
    }


}
