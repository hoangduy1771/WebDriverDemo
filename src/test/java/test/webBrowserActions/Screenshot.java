package test.webBrowserActions;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

public class Screenshot {
    public static void main(String[] args) throws IOException {
        WebDriver driver = new ChromeDriver();
        Actions action = new Actions(driver);
        driver.manage().window().maximize();
        driver.get("https://google.com/");
        int randomNumber = ThreadLocalRandom.current().nextInt();

        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("./Screenshot/" + randomNumber + " screen.png"));

//        Taking screenshot of an element
        WebElement element = driver.findElement(By.id("hplogo"));
        File scrFile1 = element.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile1, new File("./Screenshot/" + randomNumber + " element.png"));

        driver.close();
    }
}
