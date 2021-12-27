package testscripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.GoogleSearchPageObject;

public class Test2_WithTestNG {
    WebDriver driver = null;

    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
    }

    @Test
    public void test2() {
        GoogleSearchPageObject googlePage = new GoogleSearchPageObject(driver);
//        googlePage.navigateToWebsite("https://www.google.com/");
        googlePage.navigateToWebsite("https://www.google.com/");
        googlePage.inputAndEnterInSearchBox("What time is it in Vietnam?");
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
        System.out.println("Test run successfully");
    }


}
