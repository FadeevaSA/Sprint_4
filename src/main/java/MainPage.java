import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class MainPage {
    private final WebDriver driver;
    //Локатор кнопки Заказать вверху страницы
    private final By orderButtonOnTop = By.xpath(".//div[@class='Header_Nav__AGCXC']/button[@class='Button_Button__ra12g']");
    //Локатор кнопки Заказать внизу страницы
    private final By orderButtonBottomOfThePage = By.className("Button_Middle__1CSJM");

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
    public void clickOnQuestion(By questionLocator) {
        WebElement element = driver.findElement(questionLocator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        element.click();
    }

    //Получить текст ответа на выбранный вопрос
    public String getAnswer(By answerLocator) {
        return driver.findElement(answerLocator).getText();
    }

    //Объединяем методы в шаг Page Object
    public String clickAndGetAnswer(By questionLocator, By answerLocator) {
        // Кликаем на вопрос
        clickOnQuestion(questionLocator);
        // Получаем текст ответа
        return getAnswer(answerLocator);
    }
}
