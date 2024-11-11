package packageHello;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import java.util.concurrent.TimeUnit;
import java.io.*;
import org.apache.commons.io.FileUtils;

public class demoOfScreenShot {
    public static void main(String[] args) throws Exception {
    	FileReader readerObj = new FileReader("DataFiles/logininformation.csv");
    	BufferedReader bufReader = new BufferedReader(readerObj);
    	String line = bufReader.readLine();
    	System.setProperty("webdriver.chrome.driver", "webdrivers/chromedriver");
    	WebDriver driver = new ChromeDriver();
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	driver.get("http://www.practice.bpbonline.com/");
    	
    	while (line != null && !line.equals("")) {
    		String[] loginDetails = line.split(",");
    		System.out.print("Id: " + loginDetails[0] + " pw: " + loginDetails[1] + "\n");
    		driver.findElement(By.linkText("My Account")).click();
    		driver.findElement(By.name("email_address")).sendKeys(loginDetails[0]);
    		driver.findElement(By.name("password")).sendKeys(loginDetails[1]);
    		driver.findElement(By.name("password")).sendKeys(Keys.ENTER);
    		//driver.findElement(By.id("tdb1")).click();
    		if (driver.getPageSource().contains("My Account Information")) {
    			File scrnsht = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
    			String fname = "Screenshots/" + loginDetails[0] + ".jpg";
    			FileUtils.copyFile(scrnsht, new File(fname));
    			driver.findElement(By.linkText("Log Off")).click();
    			driver.findElement(By.linkText("Continue")).click();
    		} else {
    			File scrnsht = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
    			String fname = "Screenshots/" + loginDetails[0] + ".jpg";
    			FileUtils.copyFile(scrnsht, new File(fname));
    		}
    		line = bufReader.readLine();
    	}
    	driver.close();
    	
    }
}
