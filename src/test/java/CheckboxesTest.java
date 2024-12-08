import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class CheckboxesTest {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        // options.addArguments("incognito");
        //    options.addArguments("headless"); // прогон тестов в скрытом режиме браузера
           options.addArguments("disable-notification"); // не показывать уведомления
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //неявное ожидание прогрузки элементов на странице

    }

    @Test
    public void checkCheckboxes() {
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        boolean checkbox1Unchecked = driver.findElement((By.xpath("//*[@id=\"checkboxes\"]/input[1]"))).isSelected(); //Проверка, что checkbox1 в состоянии не активен (выключен)
        Assert.assertFalse(checkbox1Unchecked);
        boolean checkbox2Checked = driver.findElement(By.xpath("/html/body/div[2]/div/div/form/input[2]")).isSelected(); //Проверка, что checkbox2 в состоянии активен (включен)
        Assert.assertTrue(checkbox2Checked);
        driver.findElement(By.xpath("/html/body/div[2]/div/div/form/input[2]")).click(); //Изменение состояния чекбокса2
        boolean checkbox2Unchecked = driver.findElement((By.xpath("/html/body/div[2]/div/div/form/input[2]"))).isSelected(); //Проверка, что checkbox2 в состоянии не активен (выключен)
        Assert.assertFalse(checkbox2Unchecked);

    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}
