package cn.lanyou.i2up;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class scrollTest {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver;

		System.setProperty("webdriver.chrome.driver", "common\\chromedriver.exe");
		// 初始化一个chrome实例，实例名称叫driver
		driver = new ChromeDriver();
		// 最大化窗口
		driver.manage().window().maximize();
		// 设置隐性等待时间
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		driver.get("https://www.baidu.com/s?wd=window");
		Thread.sleep(1000);
		
		/*
		 * 方法二：利用JavaScript实现页面滚动；
		 * scrollTo滚动到指定位置；
		 * scrollBy指定滚动方向和滚动量；
		 */
		String js1 = "window.scrollTo(0,300);";
		((JavascriptExecutor) driver).executeScript(js1);
		Thread.sleep(1000);
		String js2 = "window.scrollBy(0,-200);";
		((JavascriptExecutor) driver).executeScript(js2);
		Thread.sleep(1000);


       
       

	}

}
