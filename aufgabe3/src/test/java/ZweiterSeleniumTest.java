import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ZweiterSeleniumTest {

    private WebDriver driver = null;

    @Before
    public void initTest(){
        System.setProperty("webdriver.chrome.driver", "../chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("--start-maximized");
        options.addArguments("--headless");

        driver = new ChromeDriver(options);
    }

    @After
    public void cleanupTest(){
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    @Test
    public void wikipediaSucheTest(){
       try {
            driver.navigate().to("https://www.wikipedia.de/");
            Assert.assertEquals("https://www.wikipedia.de/", driver.getCurrentUrl());

            WebElement txtBox = driver.findElement(By.id("txtSearch"));
            txtBox.sendKeys("Hallo Welt!");

            driver.findElement(By.id("cmdSearch")).click();

            WebElement header = driver.findElement(By.id("firstHeading"));
            Assert.assertEquals("Hallo Welt!", header.getText());
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            throw e;
        }
    }
}
