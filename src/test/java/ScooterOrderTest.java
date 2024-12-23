import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.assertTrue;


@RunWith(Parameterized.class)
public class ScooterOrderTest {
    private WebDriver driver;
    //Текст поля Имя
    private final String name;
    //Текст поля Фамилия
    private final String lastName;
    //Текст поля Адрес
    private final String address;
    //Локатор станции метро
    private final By metroStation;
    //Текст поля Телефон
    private final String phone;
    //Локатор даты доставки
    private final By deliveryDate;
    //Локатор количества дней аренды самоката
    private final By numberOfRentalDays;

    public ScooterOrderTest(String name, String lastName, String address, By metroStation, String phone, By deliveryDate, By numberOfRentalDays) {
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.metroStation = metroStation;
        this.phone = phone;
        this.deliveryDate = deliveryDate;
        this.numberOfRentalDays = numberOfRentalDays;
    }

    @Parameterized.Parameters(name = "Тест {index}")
    public static Object[][] getOrderDetails() {
        return new Object[][]{
                {"Маша", "Петрова", "Молодежная 5", ScooterForWhomForm.getSportivnayaMetro(), "+77172400792", AboutRentForm.getDecember29(), AboutRentForm.getThreeRentalDays()},
                {"Петя", "Иванов", "Левкова 34", ScooterForWhomForm.getSokolnikiMetro(), "+77172400888", AboutRentForm.getDecember31(), AboutRentForm.getTwoRentalDays()},
        };
    }

    @Before
    public void start() {
        driver = new ChromeDriver();
        //driver = new FirefoxDriver();
        driver.manage().window().maximize();
        //Открываем браузер
        driver.get(Constants.LINK_FOR_TEST);
    }

    @Test
    public void testScooterOrderWithTopButtonOrder() {
        MainPage objMainPage = new MainPage(driver);
        //Нажать кнопку Заказать вверху страницы
        objMainPage.clickOnOrderButtonOnTop();

        ScooterForWhomForm objScooterForWhomForm = new ScooterForWhomForm(driver);
        //Заполнить данные формы "Для кого самокат"
        objScooterForWhomForm.enterOrderDetails(name, lastName, address, metroStation, phone);

        AboutRentForm objAboutRentForm = new AboutRentForm(driver);
        //Заполнить данные формы "Про аренду", подтвердить заказ и получить номер заказа
        String orderNumber = objAboutRentForm.fillOutTheFormAndConfirmOrder(deliveryDate, numberOfRentalDays);
        System.out.println(orderNumber);
        assertTrue("Уведомление об успешном заказе не найдено", orderNumber.contains("Номер заказа"));

    }

    @Test
    public void testScooterOrderWithBottomButtonOrder() {
        MainPage objMainPage = new MainPage(driver);
        //Нажать кнопку Заказать внизу страницы
        objMainPage.clickOnOrderButtonBottomOfThePage();

        ScooterForWhomForm objScooterForWhomForm = new ScooterForWhomForm(driver);
        //Заполнить данные формы "Для кого самокат"
        objScooterForWhomForm.enterOrderDetails(name, lastName, address, metroStation, phone);

        AboutRentForm objAboutRentForm = new AboutRentForm(driver);
        //Заполнить данные формы "Про аренду", подтвердить заказ и получить номер заказа
        String orderNumber = objAboutRentForm.fillOutTheFormAndConfirmOrder(deliveryDate, numberOfRentalDays);
        System.out.println(orderNumber);
        assertTrue("Уведомление об успешном заказе не найдено", orderNumber.contains("Номер заказа"));

    }

    @After
    public void closeBrowser() {
        //Закрываем браузер
        driver.quit();
    }

}