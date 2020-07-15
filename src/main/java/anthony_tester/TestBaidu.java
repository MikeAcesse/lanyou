package anthony_tester;


import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/**
 * @author fanzk
 * @version 1.8
 * @date 2020/7/14 10:58
 */
public class TestBaidu {

	public static void main(String[] args) {
		Logger logger = Logger.getLogger(TestBaidu.class);
		//PropertyConfigurator.configure("E:\\idea-workspace\\lanyou\\src\\log4j.properties");

		// 打开浏览器
		System.setProperty("webdriver.chrome.driver", "common/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		logger.info("启动浏览器");
		logger.error("我是error");
		logger.debug("我是debug");
		logger.warn("我是warn");


		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		logger.info("隐式等待10秒");

		driver.get("https://www.baidu.com");
		logger.info("打开百度首页");

		driver.findElement(By.id("kw")).sendKeys("Selenium");
		logger.info("在搜索输入框输入selenium");

	}
}
