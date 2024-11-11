package packageHello;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;

public class AlertBox {
    public static void main(String[] args) throws Exception {	
		System.setProperty("webdriver.chrome.driver", "webdrivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("http://the-internet.herokuapp.com/javascript_alerts");
		driver.findElement(By.xpath("//button[normalize-space()='Click for JS Alert']")).click();
		Thread.sleep(6000);
		Alert alertBox = driver.switchTo().alert();
		
		alertBox.accept();
		if (driver.findElement(By.xpath("//p[@id='result']")).getText().contains("You successfully clicked an alert")) {
			System.out.println("Alert was handled");
		
		} else {
			System.out.println("Alert was not handled");
		
		}
		driver.close();

	}

}
