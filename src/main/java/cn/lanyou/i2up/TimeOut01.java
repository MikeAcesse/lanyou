package cn.lanyou.i2up;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TimeOut01 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".\\common\\chromedriver.exe"); 
		WebDriver driver = new ChromeDriver();
	    driver.get("https://www.baidu.com");
	    
	    
	    WebDriverWait wait = new WebDriverWait(driver, 10,1);
	    wait.until(new ExpectedCondition<WebElement>() {

			public WebElement apply(WebDriver input) {
				
				return input.findElement(By.id("kw"));
			}
		}).sendKeys("selenium");
	    
	    driver.findElement(By.id("su")).click();
	    Thread.sleep(2000);

				
				
	}
	


}
