package testscripts;

import config.PropertiesFile;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static config.PropertiesFile.getProperties;

public class Test3_ConfigFiles {
    WebDriver driver = null;
    public static String browserName = null;

    @BeforeTest
    public void setUp() {
        getProperties();
        if (browserName.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        }
    }

    @Test
    public void test3() {
        driver.manage().window().maximize();
        driver.get("https://google.com");
    }

    @AfterTest
    public void tearDown() {
        driver.close();
        System.out.println("Test completed successfully");
        PropertiesFile.setProperties();

    }
}
