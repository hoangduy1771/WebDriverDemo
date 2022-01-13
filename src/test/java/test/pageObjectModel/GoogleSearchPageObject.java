package test.pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;


public class GoogleSearchPageObject {
    WebDriver driver = null;
    By textBoxSearch = By.name("q");
    By buttonSearch = By.xpath("(//input[@name='btnK'])[2]");
    By buttonFeelingLucky = By.xpath("(//input[@name='btnI'])[2]");

    public GoogleSearchPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void inputAndEnterInSearchBox(String inputText) {
        driver.findElement(textBoxSearch).sendKeys(inputText + Keys.ENTER);
    }

    public void clickOnLuckyButton() {
        driver.findElement(buttonFeelingLucky).click();
    }

    public void navigateToWebsite(String url) {
        driver.manage().window().maximize();
        driver.get(url);
    }

}
