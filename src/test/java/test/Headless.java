package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Headless {

    public static void main(String[] args) {
        test();

    }

    public static void test() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("window-size=1920,1080");
        WebDriver driver = new ChromeDriver(options);


        driver.get("https://google.com");
        driver.quit();
        System.out.println("test done");
    }

}
