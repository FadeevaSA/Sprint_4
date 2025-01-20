import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AboutRentForm {
    private final WebDriver driver;
    //Локатор поля даты доставки
    private final By fieldDeliveryDate = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    //Локатор поля количества дней аренды
    private final By fieldNumberOfRentalDays = By.xpath(".//div[text()='* Срок аренды']");
    //Локатор кнопки Заказать в форме "Про аренду"
    private final By buttonOrderInTheFormAboutRent = By.xpath(".//button[2][text()='Заказать']");
    //Локатор кнопки Да для подтверждения заказа
    private final By confirmTheOrder = By.xpath(".//button[2][text()='Да']");
    //Локатор уведомления об успешном заказе
    private final By notificationOrderCompleted = By.className("Order_Text__2broi");
    //Локатор кнопки Далее в календаре
    private final By buttonNextOfTheCalendar = By.xpath(".//button[text()='Next Month']");
    //Локатор 15-го числа в календаре
    private final By fifteenthDayOfTheCalendar= By.xpath(".//*[text()='15']");
    //Локатор трех дней аренды в поле Срок аренды
    private static final By THREE_RENTAL_DAYS = By.xpath(".//div[text()='трое суток']");
    //Локатор двух дней аренды в поле Срок аренды
    private static final By TWO_RENTAL_DAYS = By.xpath(".//div[text()='двое суток']");

    public AboutRentForm(WebDriver driver) {
        this.driver = driver;
    }


    public static By getThreeRentalDays() {
        return THREE_RENTAL_DAYS;
    }

    public static By getTwoRentalDays() {
        return TWO_RENTAL_DAYS;
    }

    public void setDeliveryDate() {
        //Нажать на поле даты доставки и выбрать дату в календаре
        driver.findElement(fieldDeliveryDate).click();
        driver.findElement(buttonNextOfTheCalendar).click();
        driver.findElement(fifteenthDayOfTheCalendar).click();
    }

    public void setNumberOfRentalDays(By numberOfRentalDays) {
        //Нажать на поле количества дней аренды и выбрать это количество из выпадающего списка
        driver.findElement(fieldNumberOfRentalDays).click();
        driver.findElement(numberOfRentalDays).click();
    }

    public void clickOnButtonOrderInTheFormAboutRent() {
        //Нажать кнопку Заказать в форме "Про аренду"
        driver.findElement(buttonOrderInTheFormAboutRent).click();
    }

    public void clickConfirmTheOrder() {
        //Подтвердить заказ
        driver.findElement(confirmTheOrder).click();
    }

    public void waitForNotificationOrderCompleted() {
        //Дождаться появления уведомления об успешном заказе самоката
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(notificationOrderCompleted));
    }

    public String getOrderNumber() {
        //Получить номер заказа
        return driver.findElement(notificationOrderCompleted).getText();
    }

    //Объединяем методы в шаг Page Object
    public String fillOutTheFormAndConfirmOrder(By numberOfRentalDays) {
        setDeliveryDate();
        setNumberOfRentalDays(numberOfRentalDays);
        clickOnButtonOrderInTheFormAboutRent();
        clickConfirmTheOrder();
        waitForNotificationOrderCompleted();
        return getOrderNumber();
    }
}


