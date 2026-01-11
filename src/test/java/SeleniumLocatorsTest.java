import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;

public class SeleniumLocatorsTest {

    private static WebDriver driver;

    @BeforeAll
    public static void setup() {
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.get("https://www.mts.by");
        // Отклоняем куки
        WebElement cancelCookieButton = driver.findElement(By.cssSelector(".cookie__cancel"));
        cancelCookieButton.click();
    }

    @AfterAll
    static void tearDown() {
        if(driver != null){
            driver.quit();
        }
    }
// 1. Проверить название блока «Онлайн пополнение без комиссии»
    @Test
    public void testBlockTitle() {
        String expectedTitle = "Онлайн пополнение\nбез комиссии";
        var blockElement = driver.findElement(By.xpath("//div[@class='pay__wrapper']/h2"));
        String actualTitle = blockElement.getText().trim();
        assertEquals(expectedTitle, actualTitle);
    }

// 2. Проверить наличие логотипов платёжных систем
    @Test
    public void checkPaymentLogos() {
       // Находим блок с логотипами платежных систем
        WebElement paymentBlock = driver.findElement(By.cssSelector(".pay__partners"));

        // Поиск логотипов платежных систем
        WebElement visaLogo = paymentBlock.findElement(By.cssSelector("[src*='visa']"));
        WebElement mastercardLogo = paymentBlock.findElement(By.cssSelector("[src*='mastercard']"));
        WebElement belkartLogo = paymentBlock.findElement(By.cssSelector("[src*='belkart']"));

        // Проверка существования логотипов
        assertNotNull(visaLogo);
        assertNotNull(mastercardLogo);
        assertNotNull(belkartLogo);
    }

// 3.Проверить работу ссылки «Подробнее о сервисе»
    @Test
    public void checkServiceDetailsLink() {

       // Вводим тестовый номер телефона
        WebElement inputPhone = driver.findElement(By.id("connection-phone"));
        inputPhone.clear();
        inputPhone.sendKeys("297777777");

        // Вводим тестовый номер телефона
        WebElement sum = driver.findElement(By.id("connection-sum"));
        sum.clear();
        sum.sendKeys("5");

        // Клик по кнопке "Продолжить"
        WebElement continueButton = driver.findElement(By.cssSelector(".button__default"));
        continueButton.click();

        // Ждем пока откроется новая
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        WebElement nextStepConfirmation = wait.until(
                ExpectedConditions.presenceOfElementLocated(By.cssSelector(".payment-widget-app"))
        );

        // Проверяем наличие подтверждающего сообщения или следующего шага
        assertTrue(nextStepConfirmation.isDisplayed());
    }
}