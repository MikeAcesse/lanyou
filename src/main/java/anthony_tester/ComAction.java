package anthony_tester;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * @author fanzk
 * @version 1.8
 * @date 2020/7/14 10:34
 */
public class ComAction {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".\\common\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.baidu.com");
		driver.findElement(By.xpath("//body")).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		Thread.sleep(2);
		driver.findElement(By.xpath("//body")).sendKeys(Keys.chord(Keys.CONTROL, "t"));

	}
}
