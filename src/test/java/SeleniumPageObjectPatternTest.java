import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;
import io.github.bonigarcia.wdm.WebDriverManager;

import io.qameta.allure.*;

import java.time.Duration;

class PaymentPage {

    private final WebDriver driver;

    public static final String PHONE_NUMBER = "297777777";
    public static final String AMOUNT = "5.00";

    // Конструктор принимает драйвер
    public PaymentPage(WebDriver driver) {
        this.driver = driver;
    }

    // Метод кликания cookie баннера
    public void declineCookies() {
        WebElement cancelCookieButton = driver.findElement(By.cssSelector(".cookie__cancel"));
        cancelCookieButton.click();
    }

    // Получаем заголовок блока онлайн-пополнения
    public String getOnlineReplenishmentTitle() {
        return driver.findElement(By.xpath("//div[@class='pay__wrapper']/h2")).getText().trim();
    }

    // Возвращает контейнер с логотипами платёжных систем
    public WebElement getPaymentLogosContainer() {
        return driver.findElement(By.cssSelector(".pay__partners"));
    }

    public void fillPaymentForm() {
        WebElement inputPhone = driver.findElement(By.id("connection-phone"));
        inputPhone.clear();
        inputPhone.sendKeys(PHONE_NUMBER);

        WebElement sumField = driver.findElement(By.id("connection-sum"));
        sumField.clear();
        sumField.sendKeys(AMOUNT);

        WebElement continueButton = driver.findElement(By.cssSelector(".button__default"));
        continueButton.click();
    }

    public void switchToFrame(By frameLocator, Duration timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator));
    }


    public WebElement getElementToIframe(By elementLocator, Duration timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
    }

    public WebElement getElementTFromPaymentWidgetIframe(By elementLocator, Duration timeout) {
        driver.switchTo().defaultContent();
        fillPaymentForm();
        switchToFrame(By.cssSelector(".payment-widget-iframe"), Duration.ofSeconds(10));
        return getElementToIframe(elementLocator, timeout);
    }

    public WebElement getElement(By elementLocator) {
        return driver.findElement(elementLocator);
    }

    public void switchDefaultFrame() {
        driver.switchTo().defaultContent();
    }

    // Получаем заголовок списка элементов селекта услуги связи
    public WebElement getPaymentSelectlist() {
        WebElement blockTitleServices = driver.findElement(By.xpath("//*[contains(text(), 'Услуги связи')]"));
        blockTitleServices.click();
        return driver.findElement(By.cssSelector(".select__list"));
    }

    // Получаем заголовок списка элементов селекта услуги связи
    public WebElement getPaymentWidgetApp() {
        return driver.findElement(By.cssSelector(".payment-widget-app"));
    }
}

public class SeleniumPageObjectPatternTest {

    private static WebDriver driver;
    private static PaymentPage page;

    @BeforeAll
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.mts.by");

        page = new PaymentPage(driver);
        page.declineCookies();
    }

    @AfterAll
    static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    // Тестируем название блока онлайн-пополнения
    @Test
    @Description("Проверка названия блока")
    @DisplayName("Онлайн пополнение без комиссии")
    public void testBlockTitle() {
        String expectedTitle = "Онлайн пополнение\nбез комиссии";
        String actualTitle = page.getOnlineReplenishmentTitle();
        assertEquals(expectedTitle, actualTitle);
    }

    // Проверяем наличие логотипов платежных систем
    @Test
    @Description("Проверка на наличие логотипов платежных систем")
    @DisplayName("Платежные системы: Visa, VfsterCard, Belkart")
    public void checkPaymentLogos() {
        WebElement logosContainer = page.getPaymentLogosContainer();
        WebElement visaLogo = logosContainer.findElement(By.cssSelector("[src*='visa']"));
        WebElement mastercardLogo = logosContainer.findElement(By.cssSelector("[src*='mastercard']"));
        WebElement belkartLogo = logosContainer.findElement(By.cssSelector("[src*='belkart']"));
        assertNotNull(visaLogo);
        assertNotNull(mastercardLogo);
        assertNotNull(belkartLogo);
    }

    // Проверяем ссылку "Подробнее о сервисе"
    @Test
    @Description("Проверка ссылки Подробнее о сервисе")
    @DisplayName("Подробнее о сервисе")
    public void checkServiceDetailsLink() {
        WebElement headerCloseButtonIframe = page.getElementTFromPaymentWidgetIframe(By.cssSelector(".header__close-button"), Duration.ofSeconds(10));
        headerCloseButtonIframe.click();
        page.switchDefaultFrame();
    }

    //1.Проверить надписи в незаполненных полях каждого варианта оплаты услуг
    // Тестируем название блока услуги связи
    @Test
    @Description("Проверка надписей в полях вариантов оплаты услуг")
    @DisplayName("Существование надписей в незаполненных полях вариантов оплаты услуг")
    public void checkTitleOptionsPayment() {
        WebElement selectlist = page.getPaymentSelectlist();
        WebElement optionCommunicationServices = selectlist.findElement(By.xpath("//*[text()='Услуги связи']"));
        WebElement optionHomeInternet = selectlist.findElement(By.xpath("//*[text()='Домашний интернет']"));
        WebElement optionInstallment = selectlist.findElement(By.xpath("//*[text()='Рассрочка']"));
        WebElement optionDebt = selectlist.findElement(By.xpath("//*[text()='Задолженность']"));
        assertNotNull(optionCommunicationServices);
        assertNotNull(optionHomeInternet);
        assertNotNull(optionInstallment);
        assertNotNull(optionDebt);
    }

    //2.Для варианта «Услуги связи» проверить корректность отображения суммы (в том числе на кнопке), номера телефона,
    // а также надписей в незаполненных полях для ввода реквизитов карты, наличие иконок платёжных систем.
    @Test
    @Description("Проверка корректности заполнения данных для варианта «Услуги связи»")
    @DisplayName("Ввод реквизитов карты, наличие иконок платёжных систем в незаполненных полях")
    public void checkCommunicationServices() {
        WebElement headerCloseButtonIframe = page.getElementTFromPaymentWidgetIframe(By.cssSelector(".header__close-button"), Duration.ofSeconds(10));
        WebElement coast = page.getElement(By.xpath(String.format("//*[contains(text(), '%s')]", PaymentPage.AMOUNT)));
        WebElement telephoneNumber = page.getElement(By.xpath(String.format("//*[contains(text(), '%s')]", PaymentPage.PHONE_NUMBER)));
        WebElement cardNumber = page.getElement(By.xpath("//*[text()='Номер карты']"));
        WebElement expiries = page.getElement(By.xpath("//*[text()='Срок действия']"));
        WebElement cardHolder = page.getElement(By.xpath("//*[text()='Имя и фамилия на карте']"));
        WebElement codeCVC = page.getElement(By.xpath("//*[text()='CVC']"));
        WebElement paymentIconsVisa = page.getElement(By.cssSelector("[src*='visa']"));
        WebElement paymentIconsMastercard = page.getElement(By.cssSelector("[src*='mastercard']"));
        WebElement paymentIconsBelkart = page.getElement(By.cssSelector("[src*='belkart']"));
        WebElement paymentIconsMir = page.getElement(By.cssSelector("[src*='mir']"));
        assertNotNull(coast);
        assertNotNull(telephoneNumber);
        assertNotNull(cardNumber);
        assertNotNull(expiries);
        assertNotNull(cardHolder);
        assertNotNull(codeCVC);
        assertNotNull(paymentIconsVisa);
        assertNotNull(paymentIconsMastercard);
        assertNotNull(paymentIconsBelkart);
        assertNotNull(paymentIconsMir);

        headerCloseButtonIframe.click();
        page.switchDefaultFrame();
    }
}