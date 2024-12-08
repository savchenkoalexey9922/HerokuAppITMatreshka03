import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class AddRemoveElementsTest {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        //    options.addArguments("headless"); // прогон тестов в скрытом режиме браузера
        //    options.addArguments("incognito");
        options.addArguments("disable-notification"); // не показывать уведомления
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //неявное ожидание прогрузки элементов на странице

    }

    @Test
    public void checkAddRemoveElements() {
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
        driver.findElement(By.xpath("//button[text()='Add Element']")).click();
        driver.findElement(By.xpath("//button[text()='Add Element']")).click();
        boolean elementDeletePresent = driver.findElements(By.xpath("//button[text()='Delete']")).size() == 2; //Проверка, что на странице находится две кнопки Delete
        Assert.assertTrue(elementDeletePresent);


    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}
