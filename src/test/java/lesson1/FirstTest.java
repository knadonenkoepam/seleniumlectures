package lesson1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class FirstTest {

    private WebDriverWait webDriverWait;
    private WebDriver webDriver;

    private WebElement webElement;

    @BeforeClass
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
//        System.setProperty("webdriver.chrome.driver", "");
    }

    @Test
    public void simpleTest() {
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts()
                .implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.navigate().to("https://www.epam.com");
        webElement = webDriver.findElement(By.xpath("//span[text() = 'Home']"));
        webElement.click();
        webDriverWait = new WebDriverWait(webDriver, 10);
        webDriverWait.until(ExpectedConditions.visibilityOf(webElement));
        assertEquals("EPAM | Enterprise Software Development, Design & Consulting",
                webDriver.getTitle());
    }

    @After
    public void clear() {
        webDriver.close();
    }

}
