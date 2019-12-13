package cn.lanyou.i2up;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

class Thescrollbarlement {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver;

		System.setProperty("webdriver.chrome.driver", "common\\chromedriver.exe");
		// 初始化一个chrome实例，实例名称叫driver
		driver = new ChromeDriver();
		// 最大化窗口
		driver.manage().window().maximize();
		// 设置隐性等待时间
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		driver.get("https://jqueryui.com/slider/");

		// 设置隐性等待
		Thread.sleep(3000);
		// 切换到iframe
		driver.switchTo().frame(0);
		// 查找可拖拽元素
		WebElement Rolling = driver.findElement(By.xpath("//div[@id='slider']/span"));
		// 新建Actions类
		Actions actions = new Actions(driver);
		// 拖动滚动条
		actions.dragAndDropBy(Rolling, 1000, 0).perform();
		System.out.println("拖动滚动条完成，测试成功");

	}

	

}
