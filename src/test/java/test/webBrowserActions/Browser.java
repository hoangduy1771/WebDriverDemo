package test.webBrowserActions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class Browser {

    public static void main(String[] args) {
//        Setup
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        Actions action = new Actions(driver);

//        Test
//        Navigate
        driver.get("https://zing.vn/");
        action.pause(1000).perform();
        String originalWindow = driver.getWindowHandle();
        driver.navigate().to("https://google.com/");
        action.pause(1000).perform();

        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());

        driver.navigate().back();
        action.pause(1000).perform();
        driver.navigate().forward();
        action.pause(1000).perform();
        driver.navigate().refresh();
        action.pause(1000).perform();

        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.manage().window().maximize();
        action.pause(3000).perform();
        driver.switchTo().newWindow(WindowType.TAB);
        action.pause(3000).perform();
        driver.switchTo().window(originalWindow);



//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.manage().timeouts().scriptTimeout(Duration.ofMinutes(2));
//        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

//        TearDown
        driver.quit();
    }

}























