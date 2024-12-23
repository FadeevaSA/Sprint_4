import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.hamcrest.CoreMatchers.is;

@RunWith(Parameterized.class)
public class ListQuestionsTest {
    private WebDriver driver;
    // Индекс вопроса
    private final int questionIndex;
    //Текст ожидаемого результата
    private final String expectedAnswer;

    public ListQuestionsTest(int questionIndex, String expectedAnswer) {
        this.questionIndex = questionIndex;
        this.expectedAnswer = expectedAnswer;
    }

    @Parameterized.Parameters
    public static Object[][] openAndCheckAllAnswers() {
        return new Object[][]{
                {0, MainPage.ANSWER_ABOUT_PAYMENT},
                {1, MainPage.ANSWER_ABOUT_THE_NUMBER_OF_SCOOTERS},
                {2, MainPage.ANSWER_ABOUT_RENT_TIME},
                {3, MainPage.ANSWER_ABOUT_ORDER_FOR_TODAY},
                {4, MainPage.ANSWER_ABOUT_ORDER_EXTENSION},
                {5, MainPage.ANSWER_ABOUT_SCOOTERS_CHARGER},
                {6, MainPage.ANSWER_ABOUT_ORDER_CANCELLATION},
                {7, MainPage.ANSWER_ABOUT_DELIVERY_OUTSIDE_THE_MOSCOW_RING_ROAD},
        };
    }

    @Before
    public void start() {
        //driver = new ChromeDriver();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        //Открываем браузер
        driver.get(Constants.LINK_FOR_TEST);
    }

    @Test
    public void testListQuestions() {
        MainPage objQuestionsAboutImportant = new MainPage(driver);
        //Текст фактического результата
        String answerText = objQuestionsAboutImportant.clickAndGetAnswer(questionIndex);
        //Сравниваем фактический и ожидаемый текст ответа на вопрос
        MatcherAssert.assertThat(answerText, is(expectedAnswer));
    }

    @After
    public void closeBrowser() {
        // Закрываем браузер
        driver.quit();
    }
}