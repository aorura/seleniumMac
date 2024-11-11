package packageHello;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.interactions.*;
import org.openqa.selenium.support.ui.*;


public class demoDragAndDropAction {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "webdrivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://jqueryui.com/droppable/");
        //JavascriptExecutor js = (JavascriptExecutor) driver;
        //js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("demo-frame")));
        driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
        WebElement drag = driver.findElement(By.id("draggable"));
        WebElement drop = driver.findElement(By.id("droppable"));
        
        Actions act = new Actions(driver);
        act.dragAndDrop(drag, drop).perform();
        Thread.sleep(5000);
        driver.close();
	}
	
	private static Actions Actions(WebDriver driver) {
		return null;
	}

}
