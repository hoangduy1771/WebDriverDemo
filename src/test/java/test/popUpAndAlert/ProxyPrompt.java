package test.popUpAndAlert;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ProxyPrompt {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        String username = "guru99";
        String password = "guru99";

        driver.get("http://demo.guru99.com/test/basic_auth.php");
        Alert usernamePrompt = driver.switchTo().alert();
        usernamePrompt.sendKeys(username);
        usernamePrompt.accept();

        Alert passwordPrompt = driver.switchTo().alert();
        passwordPrompt.sendKeys(password);
        passwordPrompt.accept();

        WebElement authenticateResult = driver.findElement(By.xpath("//div[@style='margin-left:20px;']"));
        System.out.println(authenticateResult.getText());

        driver.quit();
    }
}
