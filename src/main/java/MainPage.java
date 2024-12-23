import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class MainPage {
    private final WebDriver driver;
    //Локатор кнопки Заказать вверху страницы
    private final By orderButtonOnTop = By.xpath(".//div[@class='Header_Nav__AGCXC']/button[@class='Button_Button__ra12g']");
    //Локатор кнопки Заказать внизу страницы
    private final By orderButtonBottomOfThePage = By.className("Button_Middle__1CSJM");

    //Ожидаемый текст ответов от первого до восьмого
    public static final String ANSWER_ABOUT_PAYMENT = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
    public static final String ANSWER_ABOUT_THE_NUMBER_OF_SCOOTERS = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
    public static final String ANSWER_ABOUT_RENT_TIME = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
    public static final String ANSWER_ABOUT_ORDER_FOR_TODAY = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
    public static final String ANSWER_ABOUT_ORDER_EXTENSION = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
    public static final String ANSWER_ABOUT_SCOOTERS_CHARGER = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
    public static final String ANSWER_ABOUT_ORDER_CANCELLATION = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
    public static final String ANSWER_ABOUT_DELIVERY_OUTSIDE_THE_MOSCOW_RING_ROAD = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnOrderButtonOnTop() {
        //Нажать кнопку Заказать вверху страницы
        driver.findElement(orderButtonOnTop).click();
    }

    public void clickOnOrderButtonBottomOfThePage() {
        //Пролистать страницу до кнопки Заказать внизу страницы и нажать ее
        WebElement element = driver.findElement(orderButtonBottomOfThePage);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        element.click();
    }

    //Найти вопрос в разделе «Вопросы о важном» и нажать на него
    public void clickOnQuestion(int index) {
        WebElement element = driver.findElement(By.id("accordion__heading-" + index));
        // Прокручиваем страницу до элемента
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        // Ожидаем, пока элемент станет видимым
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5)); // 10 секунд ожидания
        wait.until(ExpectedConditions.visibilityOf(element));
        // Клик по элементу
        element.click();
    }

    //Получить текст ответа на выбранный вопрос
    public String getAnswer(int index) {
        return driver.findElement(By.xpath(".//div[@aria-labelledby='accordion__heading-" + index + "']")).getText();
    }

    //Объединяем методы в шаг Page Object
    public String clickAndGetAnswer(int index) {
        // Кликаем на вопрос
        clickOnQuestion(index);
        // Получаем текст ответа
        return getAnswer(index);
    }
}
