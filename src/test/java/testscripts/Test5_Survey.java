package testscripts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Test5_Survey {
    public static <T> T getRandomElement(T[] arr) {
        return arr[ThreadLocalRandom.current().nextInt(arr.length)];
    }

    public static String xpathFormatterOption(String option) {
        return String.format("//span[text()='%s']/ancestor::div[@class='bzfPab wFGF8']//div[@class='AB7Lab Id5V1']", option);
    }

    public static String xpathFormatterCheckBoxes(String checkBoxes) {
        return String.format("//span[@dir='auto' and text()='%s']/../../preceding-sibling::div[@role='checkbox']", checkBoxes);
    }

    public static String xpathFormatterOptionYesNo(String question, String option) {
        return String.format("//span[text()='%s']/../../../../..//span[text()='%s']", question, option);
    }

    public static String xpathFormatterRatingOption(WebDriver driver, String question, int rateRowNum, int rateColumnNum) {

//        //span[contains(text(), 'hãy cho biết các yếu tố dưới đây')]/ancestor::div[@jscontroller]//div[@jsname='cnAzRb'][1]//div[@class='V4d7Ke'][1]
        for (int i = 1; i <= rateRowNum; i++) {
//            random the option from 1 - 5
            Random rand = new Random();
            int randomColumnNum = rand.nextInt(rateColumnNum) + 1;

//            specify the xpath to increment
            String xpath = String.format(
                    "//span[contains(text(), '%s')]/ancestor::div[@jscontroller]//div[@jsname='cnAzRb'][%s]//div[@class='V4d7Ke'][%s]",
                    question, i, randomColumnNum
            );

            driver.findElement(By.xpath(xpath)).click();

        }

        return "";
    }

    @Test(threadPoolSize = 3, invocationCount = 80)
    public void circleKSurvey() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("incognito");
//        options.addArguments("--headless");
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.get("");
        driver.manage().window().maximize();
        Actions action = new Actions(driver);


//        Page 1
//        pick convenience store
        String[] stores = {"Circle K", "GS25", "Ministop"};
        driver.findElement(By.xpath(xpathFormatterOption(getRandomElement(stores)))).click();

//        pick yes for have you shopped at Circle K?
        driver.findElement(By.xpath(xpathFormatterOption("Rồi"))).click();

//        click next
        driver.findElement(By.xpath("//span[text()='Tiếp']")).click();
        action.pause(3000).perform();

//        Page 2
//        shopping frequency in the last 3 months
        String[] frequency = {"Mỗi ngày", "1 - 2 lần/tuần", "2 - 3 lần/tuần", "3-4 lần/tuần", "1-2 lần/tháng"};
        driver.findElement(By.xpath(xpathFormatterOption(getRandomElement(frequency)))).click();

//        how many ppl you're shopping for?
        String[] people = {"1", "2", "3", "Trên 3"};
        driver.findElement(By.xpath(xpathFormatterOption(getRandomElement(people)))).click();

//        who do you usually shop for?
        String[] person = {"Cho bản thân", "Gia đình", "Đồng nghiệp"};
        driver.findElement(By.xpath(xpathFormatterCheckBoxes(getRandomElement(person)))).click();

//        where do you get information about Circle K
        String[] referenceSource = {"Mạng xã hội", "POSM tại cửa hàng (poster, sticker....)", "Qua bạn bè", "Qua nhân viên bán hàng", "Tự trải nghiệm"};
        driver.findElement(By.xpath(xpathFormatterCheckBoxes(getRandomElement(referenceSource)))).click();

//        which location you usually shop at
        String[] shopLocation = {"Gần trường học / nơi công tác", "Gần khu vực sinh sống"};
        driver.findElement(By.xpath(xpathFormatterCheckBoxes(getRandomElement(shopLocation)))).click();

//        who do you usually go with
        String[] shopBuddy = {"Đi 1 mình", "Đi với bạn bè", "Đi với người thân, gia đình", "Đi với đồng nghiệp"};
        driver.findElement(By.xpath(xpathFormatterOption(getRandomElement(shopBuddy)))).click();

//        does your shop buddy influence your decision?
        String[] yesNoOption = {"Có", "Không"};
        driver.findElement(By.xpath(xpathFormatterOptionYesNo("Khi đi chung với người khác, quyết định mua hàng của bạn có bị tác động bởi họ không?",
                getRandomElement(yesNoOption)))).click();

//        which commodity you usually bought?
        String[] commodity = {"Thức ăn chế biến tại chỗ", "Nước uống đóng chai", "Đồ ăn đóng gói", "Nước uống pha tại chỗ"
                , "Nhu yếu phẩm: dao cạo râu, bông ráy tai, chăm sóc cá nhân,..."};
        driver.findElement(By.xpath(xpathFormatterCheckBoxes(getRandomElement(commodity)))).click();

//        rate services and prices
        String[] rating = {"Giá cả hợp lý, ngang các CH khác", "Giá rẻ hơn thị trường", "Giá cao hơn so với các CH khác"
                , "Giá cả ổn định", "Nhiều chương trình khuyến mãi hấp dẫn"};
        driver.findElement(By.xpath(xpathFormatterCheckBoxes(getRandomElement(rating)))).click();

//        Circle K advantages over traditional market, supermarket
        String[] advantages = {"Cơ sở vật chất sạch sẽ", "Thức ăn đã được chế biến", "Có giá niêm yết rõ ràng", "Thức ăn / đồ uống có thể pha chế tại chỗ và mang đi",
                "Bãi giữ xe ngay cửa hàng", "Có máy lạnh, wifi", "Có khu vực ngồi ăn tại chỗ", "Bố trí ngăn nắp dễ dàng lựa chọn sản phẩm",
                "Hình thức thanh toán linh hoạt", "Dịch vụ chăm sóc khách hàng", "Thời gian mua hàng nhanh chóng", "Mua được sản phẩm số lượng nhỏ lẻ",
                "Đội ngũ nhân viên chuyên nghiệp", "Cơ sở vật chất mới"};
        driver.findElement(By.xpath(xpathFormatterCheckBoxes(getRandomElement(advantages)))).click();

//        1 - 5 rating elements that influence your shopping choice
        xpathFormatterRatingOption(driver,
                "hãy cho biết các yếu tố dưới đây ảnh hưởng như thế nào đến quyết định mua sắm tại Circle K của bạn:",
                26, 5);

//        1 - 5 rating elements that influence your shopping choice
        xpathFormatterRatingOption(driver,
                "hãy cho biết mức độ hài lòng của bạn đối với các yếu tố dưới đây khi mua sắm tại Circle K:",
                26, 5);

//        are you fulfilled by the service at circle K
        String[] fulfilledOption = {"Chưa đầy đủ", "Khá đầy đủ", "Đã đầy đủ"};
        driver.findElement(By.xpath(xpathFormatterOption(getRandomElement(fulfilledOption)))).click();

//        will you recommend Circle K to friends
        driver.findElement(By.xpath(xpathFormatterOptionYesNo("Bạn có sẵn sàng giới thiệu cho người thân / bạn bè của bạn mua sắm tại Circle K?",
                getRandomElement(yesNoOption)))).click();

        //        will you recommend Circle K to friends
        driver.findElement(By.xpath(xpathFormatterOptionYesNo("Bạn có tiếp tục mua sắm tại Circle K trong tương lai?",
                getRandomElement(yesNoOption)))).click();

//        click next
        driver.findElement(By.xpath("//span[text()='Tiếp']")).click();
        action.pause(3000).perform();

//        Page 3
//        your age
        String[] age = {"Dưới 18 tuổi", "Từ 18 - 25 tuổi", "Từ 26 - 30 tuổi", "Trên 30 tuổi"};
        driver.findElement(By.xpath(xpathFormatterOption(getRandomElement(age)))).click();

//        your gender
        String[] genders = {"Nam", "Nữ", "Khác"};
        driver.findElement(By.xpath(xpathFormatterOption(getRandomElement(genders)))).click();

//        your current job
        String[] jobs = {"Học sinh, sinh viên", "Nhân viên văn phòng", "Công chức", "Kinh doanh tự do", "Nội trợ", "Lao động phổ thông"};
        driver.findElement(By.xpath(xpathFormatterOption(getRandomElement(jobs)))).click();

//        your income
        String[] income = {"Dưới 5 triệu", "Từ 5 triệu - 10 triệu", "Từ 10 triệu - 15 triệu", "Trên 15 triệu"};
        driver.findElement(By.xpath(xpathFormatterOption(getRandomElement(income)))).click();

//       your degree level
        String[] degree = {"Cấp ba", "Cao đẳng/Học nghề", "Đại học", "Sau đại học"};
        driver.findElement(By.xpath(xpathFormatterOption(getRandomElement(degree)))).click();

//        pick who you get survey from
        driver.findElement(By.xpath(xpathFormatterOption(""))).click();

        driver.findElement(By.xpath("//span[text()='Gửi']")).click();

//        wait for submit successfull
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[text()='Cảm ơn bạn đã dành thời gian đóng góp thông tin và ý kiến cho đề tài của nhóm. Chúng mình đảm bảo những thông tin thu thập được từ bài khảo sát này sẽ bảo mật và chỉ sử dụng cho mục đích học tập. ']"))));

        driver.close();
        driver.quit();

    }




}
