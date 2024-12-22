import org.openqa.selenium.By;

public class Constants {
    //Ссылка на тестовое окружение сервиса «Яндекс.Самокат»
    public static final String LINK_FOR_TEST = "https://qa-scooter.praktikum-services.ru/";

    //Локаторы вопросов от первого до восьмого
    public static final By OPEN_FIRST_QUESTION = By.id("accordion__heading-0");
    public static final By OPEN_SECOND_QUESTION = By.id("accordion__heading-1");
    public static final By OPEN_THIRD_QUESTION = By.id("accordion__heading-2");
    public static final By OPEN_FOURTH_QUESTION = By.id("accordion__heading-3");
    public static final By OPEN_FIFTH_QUESTION = By.id("accordion__heading-4");
    public static final By OPEN_SIXTH_QUESTION = By.id("accordion__heading-5");
    public static final By OPEN_SEVENTH_QUESTION = By.id("accordion__heading-6");
    public static final By OPEN_EIGHTH_QUESTION = By.id("accordion__heading-7");

    //Локаторы ответов от первого до восьмого
    public static final By TEXT_OF_FIRST_ANSWER = By.xpath(".//div[@aria-labelledby='accordion__heading-0']");
    public static final By TEXT_OF_SECOND_ANSWER = By.xpath(".//div[@aria-labelledby='accordion__heading-1']");
    public static final By TEXT_OF_THIRD_ANSWER = By.xpath(".//div[@aria-labelledby='accordion__heading-2']");
    public static final By TEXT_OF_FOURTH_ANSWER = By.xpath(".//div[@aria-labelledby='accordion__heading-3']");
    public static final By TEXT_OF_FIFTH_ANSWER = By.xpath(".//div[@aria-labelledby='accordion__heading-4']");
    public static final By TEXT_OF_SIXTH_ANSWER = By.xpath(".//div[@aria-labelledby='accordion__heading-5']");
    public static final By TEXT_OF_SEVENTH_ANSWER = By.xpath(".//div[@aria-labelledby='accordion__heading-6']");
    public static final By TEXT_OF_EIGHTH_ANSWER = By.xpath(".//div[@aria-labelledby='accordion__heading-7']");

    //Ожидаемый текст ответов от первого до восьмого
    public static final String EXPECTED_TEXT_OF_FIRST_ANSWER = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
    public static final String EXPECTED_TEXT_OF_SECOND_ANSWER = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
    public static final String EXPECTED_TEXT_OF_THIRD_ANSWER = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
    public static final String EXPECTED_TEXT_OF_FOURTH_ANSWER = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
    public static final String EXPECTED_TEXT_OF_FIFTH_ANSWER = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
    public static final String EXPECTED_TEXT_OF_SIXTH_ANSWER = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
    public static final String EXPECTED_TEXT_OF_SEVENTH_ANSWER = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
    public static final String EXPECTED_EXT_OF_EIGHTH_ANSWER = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";

    //Данные для первого теста: локатор станции метро, локатор даты заказа, локатор количества дней заказа
    public static final By SPORTIVNAYA_METRO_STATION = By.xpath(".//li[@data-index='14']");
    public static final By FIRST_TEST_DATE = By.xpath(".//div[@aria-label='Choose воскресенье, 29-е декабря 2024 г.']");
    public static final By THREE_RENTAL_DAYS = By.xpath(".//div[text()='трое суток']");

    //Данные для второго теста: локатор станции метро, локатор даты заказа, локатор количества дней заказа
    public static final By SOKOLNIKI_METRO_STATION = By.xpath(".//li[@data-index='3']");
    public static final By SECOND_TEST_DATE = By.xpath(".//div[@aria-label='Choose вторник, 31-е декабря 2024 г.']");
    public static final By TWO_RENTAL_DAYS = By.xpath(".//div[text()='двое суток']");
}
