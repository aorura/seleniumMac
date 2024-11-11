package packageHello;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;

public class helloWorld {

	public static void main(String[] args) {
		System.out.println("Hello, World!!");
		System.setProperty("webdriver.chrome.driver","webdrivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("http://practice.bpbonline.com");
		driver.manage().window().maximize();
		WebElement searchField = driver.findElement(By.name("keywords"));
		searchField.clear();
		searchField.sendKeys("mouse");
		WebElement quickFind = driver.findElement(By.xpath("//input[@title=' Quick Find ']"));
		quickFind.click();
		driver.close();

	}

}
