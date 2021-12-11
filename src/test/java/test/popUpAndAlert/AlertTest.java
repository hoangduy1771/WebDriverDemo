package test.popUpAndAlert;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class AlertTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        Actions action = new Actions(driver);

        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        WebElement alertButton = driver.findElement(By.xpath("//button[text()='Click for JS Alert']"));
        alertButton.click();
        Thread.sleep(2000);

        Alert alert1 = driver.switchTo().alert();
        String alertText = alert1.getText();
        System.out.println(alertText);
        alert1.accept();

        if(driver.getPageSource().contains("You successfully clicked an alert")) {
            System.out.println("PASSED");
        }
        else {
            System.out.println("FAILED");
        }
        Thread.sleep(2000);


        driver.close();
    }
}
