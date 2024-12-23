import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ScooterForWhomForm {
    private final WebDriver driver;
    //Локатор куки
    private final By closeCookie = By.className("App_CookieButton__3cvqF");
    //Локатор заголовка формы заказа
    private final By headerOrderForms = By.className("Order_Header__BZXOb");
    //Локатор поля Имя
    private final By fieldName = By.xpath(".//input[@placeholder='* Имя']");
    //Локатор поля Фамилия
    private final By fieldLastName = By.xpath(".//input[@placeholder='* Фамилия']");
    //Локатор поля Адрес
    private final By fieldAddress = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    //Локатор поля Метро
    private final By fieldMetro = By.xpath(".//input[@placeholder='* Станция метро']");
    //Локатор поля Телефон
    private final By fieldPhone = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    //Локатор кнопки Далее в форме "Для кого самокат"
    private final By buttonNext = By.className("Button_Middle__1CSJM");
    //Локатор станции метро Спортивная
    private static final By SPORTIVNAYA_METRO_STATION = By.xpath(".//li[@data-index='14']");
    //Локатор станции метро Сокольники
    private static final By SOKOLNIKI_METRO_STATION = By.xpath(".//li[@data-index='3']");

    public ScooterForWhomForm(WebDriver driver) {
        this.driver = driver;
    }

    public void clickCloseCookie() {
        //Закрыть куки
        driver.findElement(closeCookie).click();
    }

    public void waitForLoadHeader() {
        //Подождать появление заголовка формы заказа
        new WebDriverWait(driver, Duration.ofSeconds(2))
                .until(ExpectedConditions.visibilityOfElementLocated(headerOrderForms));
    }

    public void setName(String name) {
        //Заполнить поле Имя
        driver.findElement(fieldName).sendKeys(name);
    }

    public void setLastName(String lastName) {
        //Заполнить поле Фамилия
        driver.findElement(fieldLastName).sendKeys(lastName);
    }

    public void setAddress(String address) {
        //Заполнить поле Адрес
        driver.findElement(fieldAddress).sendKeys(address);
    }

    public void setMetro(By metroStation) {
        //Нажать на поле Метро и выбрать станцию из выпадающего списка
        driver.findElement(fieldMetro).click();
        driver.findElement(metroStation).click();
    }

    public void setPhone(String phone) {
        //Заполнить поле Телефон
        driver.findElement(fieldPhone).sendKeys(phone);
    }

    public void clickButtonNext() {
        //Пролистать до кнопки Далее в форме "Для кого самокат" и нажать на нее
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(buttonNext));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();
    }
    public static By getSportivnayaMetro() {
        return SPORTIVNAYA_METRO_STATION;
    }
    public static By getSokolnikiMetro() {
        return SOKOLNIKI_METRO_STATION;
    }
    //Объединяем методы в шаг Page Object
    public void enterOrderDetails(String name, String lastName, String address, By metroStation, String phone) {
        waitForLoadHeader();
        clickCloseCookie();
        setName(name);
        setLastName(lastName);
        setAddress(address);
        setMetro(metroStation);
        setPhone(phone);
        clickButtonNext();
    }
}
