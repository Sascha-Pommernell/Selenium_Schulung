import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ErsterSeleniumTest {

    @Test
    public void wikipediaAufrufTest(){

        System.setProperty("webdriver.chrome.driver", "../chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.wikipedia.de/");
        Assert.assertEquals("https://www.wikipedia.de/", driver.getCurrentUrl());
        driver.quit();
    }
}
