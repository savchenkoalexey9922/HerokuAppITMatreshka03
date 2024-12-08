import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class InputsTest {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("incognito");
        //    options.addArguments("headless"); // прогон тестов в скрытом режиме браузера
        // tions.addArguments("disable-notification"); // не показывать уведомления
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //неявное ожидание прогрузки элементов на странице

    }


    @Test
    public void checkInputs() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/inputs");
        Thread.sleep(1000);
        boolean checkInput = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/input")).isDisplayed(); //Как проверить, что в импуте отображается значение "0"?
        Assert.assertTrue(checkInput);
        driver.findElement(By.tagName("input")).sendKeys(Keys.ARROW_UP);
        driver.findElement(By.tagName("input")).sendKeys(Keys.ARROW_UP);
        driver.findElement(By.tagName("input")).sendKeys(Keys.ARROW_UP);
        boolean checkInput3 = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/input")).isDisplayed(); //Как проверить, что в импуте отображается значение "3"?
        Assert.assertTrue(checkInput3);
        Thread.sleep(2000);
        driver.findElement(By.tagName("input")).sendKeys(Keys.ARROW_DOWN);
        boolean checkInput2 = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/input")).isDisplayed(); //Как проверить, что в импуте отображается значение "2"?
        Assert.assertTrue(checkInput2);
        Thread.sleep(2000);


    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}
