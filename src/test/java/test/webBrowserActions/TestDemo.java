package test.webBrowserActions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class TestDemo {
    public static void main(String[] args) {
//        Setup
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        Actions action = new Actions(driver);

//        Test
        driver.get("https://zing.vn/");

        action.pause(3000).perform();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().scriptTimeout(Duration.ofMinutes(2));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));


//        TearDown
        driver.close();
    }


}


