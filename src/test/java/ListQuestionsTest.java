import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.hamcrest.CoreMatchers.is;

@RunWith(Parameterized.class)
public class ListQuestionsTest {
    private WebDriver driver;
    //Локатор вопроса
    private final By questionLocator;
    //Локатор ответа
    private final By answerLocator;
    //Текст ожидаемого результата
    private final String expectedAnswer;

    public ListQuestionsTest(By questionLocator, By answerLocator, String expectedAnswer) {
        this.questionLocator = questionLocator;
        this.answerLocator = answerLocator;
        this.expectedAnswer = expectedAnswer;
    }

    @Parameterized.Parameters
    public static Object[][] openAndCheckAllAnswers() {
        return new Object[][]{
                {Constants.OPEN_FIRST_QUESTION, Constants.TEXT_OF_FIRST_ANSWER, Constants.EXPECTED_TEXT_OF_FIRST_ANSWER},
                {Constants.OPEN_SECOND_QUESTION, Constants.TEXT_OF_SECOND_ANSWER, Constants.EXPECTED_TEXT_OF_SECOND_ANSWER},
                {Constants.OPEN_THIRD_QUESTION, Constants.TEXT_OF_THIRD_ANSWER, Constants.EXPECTED_TEXT_OF_THIRD_ANSWER},
                {Constants.OPEN_FOURTH_QUESTION, Constants.TEXT_OF_FOURTH_ANSWER, Constants.EXPECTED_TEXT_OF_FOURTH_ANSWER},
                {Constants.OPEN_FIFTH_QUESTION, Constants.TEXT_OF_FIFTH_ANSWER, Constants.EXPECTED_TEXT_OF_FIFTH_ANSWER},
                {Constants.OPEN_SIXTH_QUESTION, Constants.TEXT_OF_SIXTH_ANSWER, Constants.EXPECTED_TEXT_OF_SIXTH_ANSWER},
                {Constants.OPEN_SEVENTH_QUESTION, Constants.TEXT_OF_SEVENTH_ANSWER, Constants.EXPECTED_TEXT_OF_SEVENTH_ANSWER},
                {Constants.OPEN_EIGHTH_QUESTION, Constants.TEXT_OF_EIGHTH_ANSWER, Constants.EXPECTED_EXT_OF_EIGHTH_ANSWER},
        };
    }

    @Before
    public void start() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //Открываем браузер
        driver.get(Constants.LINK_FOR_TEST);
    }

    @Test
    public void testListQuestions() {
        MainPage objQuestionsAboutImportant = new MainPage(driver);
        //Текст фактического результата
        String answerText = objQuestionsAboutImportant.clickAndGetAnswer(questionLocator, answerLocator);
        //Сравниваем фактический и ожидаемый текст ответа на вопрос
        MatcherAssert.assertThat(answerText, is(expectedAnswer));
    }

    @After
    public void closeBrowser() {
        // Закрываем браузер
        driver.quit();
    }
}