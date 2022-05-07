package testscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Test4_Survey {
    public static <T> T getRandomElement(T[] arr) {
        return arr[ThreadLocalRandom.current().nextInt(arr.length)];
    }

    @Test(invocationCount = 100)
    public void adMusicSurvey() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("incognito");
        options.addArguments("--headless");
        WebDriver driver = new ChromeDriver(options);
        driver.get("");
        driver.manage().window().maximize();
        Actions action = new Actions(driver);

//        Page 1
//        pick yes for Do you watch ads?
        driver.findElement(By.xpath("//label[@for='i5']")).click();

//        pick gender
        String[] genders = {"i15", "i18", "i21"};
        driver.findElement(By.xpath(String.format("//label[@for='%s']", getRandomElement(genders)))).click();

//        pick age
        String[] ages = {"i28", "i31", "i34", "i37"};
        driver.findElement(By.xpath(String.format("//label[@for='%s']", getRandomElement(ages)))).click();

//        pick location
        String[] locations = {"i44", "i47", "i50"};
        driver.findElement(By.xpath(String.format("//label[@for='%s']", getRandomElement(locations)))).click();

//        fill occupation
        String[] occupations = {"nhân viên kế toán", "chuyên viên thống kê", "trưởng phòng quảng cáo", "nhân viên giao dịch ngân hàng", "doanh nhân", "thư ký riêng", "trợ lý giám đốc", "nhân viên văn phòng", "lễ tân", "nhân viên môi giới chứng khoán", "giám đốc marketing", "cố vấn giám đốc", "lập trình viên máy tính", "thợ làm bánh", "thợ cắt tóc", "thu ngân", "nha sĩ", "bác sĩ", "thợ mộc", "bác sĩ thú y", "thợ xăm", "đầu bếp", "hướng dẫn viên du lịch", "nhà báo", "họa sĩ", "thiết kế đồ họa", "thám tử", "giảng viên", "trợ giảng", "bảo vệ", "diễn viên múa", "dancer", "rapper"};
        driver.findElement(By.xpath("//input[@aria-describedby='i54 i55']")).sendKeys(getRandomElement(occupations));

//        pick degree
        String[] degrees = {"i61", "i64", "i67", "i70"};
        driver.findElement(By.xpath(String.format("//label[@for='%s']", getRandomElement(degrees)))).click();

//        pick incomes
        String[] incomes = {"i77", "i80", "i83", "i86"};
        driver.findElement(By.xpath(String.format("//label[@for='%s']", getRandomElement(incomes)))).click();

//        fill singers
        String[] singers = {"Tóc Tiên", "Chi Pu", "Miu Lê", "Gil Lê", "Karik", "Wowy", "Hòa Minzy", "Min", "Hồ Ngọc Hà", "Khởi My", "Mỹ Tâm", "Sơn Tùng MTP", "Đức Phúc", "Erik", "Hoàng Thùy Linh", "Đông Nhi", "Văn Mai Hương", "Bích Phương", "Jack", "Noo Phước Thịnh", "Amee", "Hiền Hồ", "Soobin Hoàng Sơn", "Selena Gomez", "Đan Trường", "Ngọc Sơn", "Taylor Swift", "Ưng Hoàng Phúc", "Chi Dân", "Bùi Lan Hương", "Maroon 5", "Bảo Anh", "Bùi Anh Tuấn", "Hà Anh Tuấn", "Trúc Nhân", "Lý Hải", "Đen Vâu", "Vũ", "Trọng Hiếu Idol", "Vũ Cát Tường", "BLACKPINK", "Justin Bieber", "Big Bang", "Đan Nguyên", "Isaac", "Hương Tràm", "Bảo Thy", "Lệ Quyên", "Hari Won", "Đàm Vĩnh Hưng", "Hồ Quang Hiếu", "Đạt G", "Thu Minh", "Minh Hằng", "Cẩm Ly", "Lam Trường"};
        driver.findElement(By.xpath("//input[@aria-describedby='i90 i91']")).sendKeys(getRandomElement(singers));

//        pick music genre
        String[] musicGenre = {"i97", "i100", "i103", "i106", "i109", "i112", "i115", "i118", "i121", "i124", "i127"};
        driver.findElement(By.xpath(String.format("//label[@for='%s']", getRandomElement(musicGenre)))).click();

//        pick social media
        String[] socialMedia = {"i134", "i137", "i140", "i143", "i146"};
        driver.findElement(By.xpath(String.format("//label[@for='%s']", getRandomElement(socialMedia)))).click();

//        pick yes for do you like to watch ad?
        driver.findElement(By.xpath("//label[@for='i153']")).click();

//        fill ad watched
        String[] adWatched = {"điện thoại Oppo", "Samsung OLED TV", "Mirinda", "Quảng cáo biti's hunter", "Tiki", "Shopee cùng đội tuyển U23 Việt Nam", "Sữa tươi Vinamilk", "Koreno", "Omachi", "Pepsi", "Coca-Cola", "Lazada", "bột ngọt Vedan", "hạt nêm Knorr", "dầu gội Rejoice", "Sữa tắm Oliv", "Em bé  - Baemin", "Strongbow", "dầu ăn Simply", "bánh Chocopie của Orion", "bột giặt Aba", "heneiken", "Bia Sài Gòn", "thép Hòa Phát", "máy điều hòa Hòa Phát", "TH True Milk - thật sự thiên nhiên", "Lotteria", "KFC", "kem đánh răng P/S", "mì Hảo Hảo", "dầu gội Clear", "nước xả Comfort", "Downy", "Vifon", "điện thoại Vivo", "Điện máy xanh", "Honda Winner", "TRESEMME Keratin Smooth", "dầu gội head and shoulder"};
        driver.findElement(By.xpath("//input[@aria-describedby='i160 i161']")).sendKeys(getRandomElement(adWatched));

//        click next
        driver.findElement(By.xpath("//span[text()='Tiếp']")).click();
        action.pause(3000).perform();

//        Page 2 - 5
        for (int i = 0; i <= 3; i++) {
            String[] choiceNum = {"1", "2", "3", "4", "5", "6", "7"};
            driver.findElement
                    (By.xpath(String.format("//div[@class='Zki2Ve' and text()='%s']", getRandomElement(choiceNum)))).click();
            driver.findElement
                    (By.xpath(String.format("(//div[@class='Zki2Ve' and text()='%s'])[2]", getRandomElement(choiceNum)))).click();
            driver.findElement
                    (By.xpath(String.format("(//div[@class='Zki2Ve' and text()='%s'])[3]", getRandomElement(choiceNum)))).click();
            driver.findElement
                    (By.xpath(String.format("(//div[@class='Zki2Ve' and text()='%s'])[4]", getRandomElement(choiceNum)))).click();
            try {
                driver.findElement
                        (By.xpath(String.format("(//div[@class='Zki2Ve' and text()='%s'])[5]", getRandomElement(choiceNum)))).click();
                driver.findElement
                        (By.xpath(String.format("(//div[@class='Zki2Ve' and text()='%s'])[6]", getRandomElement(choiceNum)))).click();
                driver.findElement
                        (By.xpath(String.format("(//div[@class='Zki2Ve' and text()='%s'])[7]", getRandomElement(choiceNum)))).click();
                driver.findElement
                        (By.xpath(String.format("(//div[@class='Zki2Ve' and text()='%s'])[8]", getRandomElement(choiceNum)))).click();
            } catch (Exception e) {
                driver.findElement(By.xpath("//span[text()='Tiếp']")).click();
                action.pause(1000).perform();
            }
            try {
                //        click next
                driver.findElement(By.xpath("//span[text()='Tiếp']")).click();
                action.pause(1000).perform();
            } catch (Exception e) {
            }
        }

//        Page 6

        String[] choiceNum = {"1", "2", "3", "4", "5"};
        driver.findElement
                (By.xpath(String.format("//div[@class='Zki2Ve' and text()='%s']", getRandomElement(choiceNum)))).click();
        driver.findElement
                (By.xpath(String.format("(//div[@class='Zki2Ve' and text()='%s'])[2]", getRandomElement(choiceNum)))).click();
        driver.findElement
                (By.xpath(String.format("(//div[@class='Zki2Ve' and text()='%s'])[3]", getRandomElement(choiceNum)))).click();
        driver.findElement
                (By.xpath(String.format("(//div[@class='Zki2Ve' and text()='%s'])[4]", getRandomElement(choiceNum)))).click();
        driver.findElement
                (By.xpath(String.format("(//div[@class='Zki2Ve' and text()='%s'])[5]", getRandomElement(choiceNum)))).click();
        driver.findElement
                (By.xpath(String.format("(//div[@class='Zki2Ve' and text()='%s'])[6]", getRandomElement(choiceNum)))).click();
        driver.findElement
                (By.xpath(String.format("(//div[@class='Zki2Ve' and text()='%s'])[7]", getRandomElement(choiceNum)))).click();

        driver.findElement(By.xpath("//span[text()='Ngọc Thuý']")).click();

//        click send
        driver.findElement(By.xpath("//span[text()='Gửi']")).click();

        driver.quit();

    }


}
