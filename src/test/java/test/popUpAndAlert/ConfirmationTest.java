package test.popUpAndAlert;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.logging.Logger;

public class ConfirmationTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        Actions action = new Actions(driver);
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement confirmBtn = driver.findElement(By.xpath("//button[text()='Click for JS Confirm']"));

        confirmBtn.click();
        Thread.sleep(2000);

        Alert confirm1 = driver.switchTo().alert();
        System.out.println(confirm1.getText());

        System.out.println("Clicking OK on Confirmation Alert");
        confirm1.accept();
        String acceptedResult = driver.findElement(By.xpath("//p[@id='result']")).getText();
        System.out.printf("Accepted Result is: %s %n",acceptedResult);
        if(driver.getPageSource().contains(acceptedResult)) {
            System.out.println("Accepted on Confirmation Alert successful");
        }
        else {
            System.out.println("Accepted on Confirmation Alert failed");
        }

        confirmBtn.click();

        Alert confirm2 = driver.switchTo().alert();
        confirm2.dismiss();
        String dismissedResult = driver.findElement(By.xpath("//p[@id='result']")).getText();
        System.out.printf("Dismissed Result is: %s%n",dismissedResult);
        if(driver.getPageSource().contains(dismissedResult)) {
            System.out.println("Dismissed on Confirmation Alert successful");
        }
        else {
            System.out.println("Dismissed on Confirmation Alert failed");
        }

        Thread.sleep(2000);
        driver.close();
    }
}
