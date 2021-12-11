package test.popUpAndAlert;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class PromptTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        Actions action = new Actions(driver);
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        String resultXpath = "//p[@id='result']";

        WebElement promptBtn = driver.findElement(By.xpath("//button[text()='Click for JS Prompt']"));

//        Input and accepted
        promptBtn.click();
        Alert prompt1 = driver.switchTo().alert();
        System.out.println(prompt1.getText());
        prompt1.sendKeys("Accepted");
        Thread.sleep(3000);
        prompt1.accept();
        String acceptedAndSendkeyResult = driver.findElement(By.xpath(resultXpath)).getText();
        System.out.printf("Accepted result is: %s%n", acceptedAndSendkeyResult);
        if (driver.getPageSource().contains(acceptedAndSendkeyResult)) {
            System.out.println("PASSED: Input and accepted successfully");
        }
        else {
            System.out.println("FAILED: Input and accepted failed");
        }

        //        Input and dismissed
        promptBtn.click();
        Alert prompt2 = driver.switchTo().alert();
        System.out.println(prompt2.getText());
        prompt2.sendKeys("Dismissed");
        Thread.sleep(3000);
        prompt2.accept();
        String dismissedAndSendkeyResult = driver.findElement(By.xpath(resultXpath)).getText();
        System.out.printf("Accepted result is: %s%n", dismissedAndSendkeyResult);
        if (driver.getPageSource().contains(dismissedAndSendkeyResult)) {
            System.out.println("PASSED: Input and dismissed successfully");
        }
        else {
            System.out.println("FAILED: Input and dismissed failed");
        }

        Thread.sleep(2000);
        driver.quit();
    }
}
