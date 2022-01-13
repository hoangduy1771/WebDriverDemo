package testscripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import test.pageObjectModel.GoogleSearchPageObject;

public class Test2_GoogleSearch {
    public static void main(String[] args) {
        test2();

    }

    public static void test2() {
        WebDriver driver = new ChromeDriver();

        GoogleSearchPageObject googlePage = new GoogleSearchPageObject(driver);
        googlePage.navigateToWebsite("https://www.google.com/");
        googlePage.inputAndEnterInSearchBox("What time is it in Vietnam?");

        driver.navigate().back();

        googlePage.clickOnLuckyButton();

        driver.quit();

    }

}
