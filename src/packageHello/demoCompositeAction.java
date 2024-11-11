package packageHello;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.interactions.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class demoCompositeAction {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "webdrivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/key_presses");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("target")));
		WebElement textBox = driver.findElement(By.id("target"));
		Actions act = new Actions(driver);
		act.sendKeys(textBox, Keys.TAB).pause(5000).sendKeys(textBox, Keys.SPACE).pause(2000).sendKeys(textBox, "Hello, World!!").build().perform();
		Thread.sleep(5000);
		driver.close();

	}

}
