package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class EnabledAndSelected {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        WebElement checkbox1 = driver.findElement(By.xpath("//input[@type='checkbox'][1]"));
        WebElement checkbox2 = driver.findElement(By.xpath("//input[@type='checkbox'][2]"));
        System.out.println(checkbox1.isEnabled());
        System.out.println(checkbox1.isSelected());
        System.out.println("===========================");
        System.out.println(checkbox2.isEnabled());
        System.out.println(checkbox2.isSelected());

        driver.quit();
    }
}
