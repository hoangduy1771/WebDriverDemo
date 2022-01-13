package test.wait;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SeleniumWaitDemo {
    static WebDriver driver = new ChromeDriver();

    public static void main(String[] args) {
//        implicitlyWaits();
        explicitWaits();
    }

    public static void implicitlyWaits() {
//        implicitly wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.manage().window().maximize();
        driver.get("https://google.com");
        driver.findElement(By.name("q")).sendKeys("What time is it in Vietnam?", Keys.ENTER);

        System.out.println("Wait for non-exist element with implicit wait");
        try {
            driver.findElement(By.name("abcd")).click();
        } catch (Exception e) {
            System.out.println("Wait time is over. closing browser");
            driver.quit();
        }
        driver.quit();
    }

    public static void explicitWaits() {
//        explicit wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.manage().window().maximize();
        driver.get("https://google.com");
        driver.findElement(By.name("q")).sendKeys("What time is it in Iceland?", Keys.ENTER);

        try {
            System.out.println("Wait for non-exist element with explicit wait");
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.name("abcd")));
            element.click();
        } catch (Exception e) {
            System.out.println("The Error: " + e.getMessage());
            System.out.println("Wait time is over.closing browser");
            driver.quit();
        }
        driver.quit();

    }


}
