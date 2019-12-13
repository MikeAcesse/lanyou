package cn.lanyou.i2up;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ElementOpration {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver;

		System.setProperty("webdriver.chrome.driver", "common\\chromedriver.exe");
		// 初始化一个chrome实例，实例名称叫driver
		driver = new ChromeDriver();
		// 最大化窗口
		driver.manage().window().maximize();
		// 设置隐性等待时间
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		driver.get("http://blog.csdn.net/u011541946");
		
       Thread.sleep(500);
        
        // 定义csdn底部 公司简介 这个元素
        WebElement element = driver.findElement(By.xpath("//a[contains(text(),'关于我们')]"));
        //创建一个javascript 执行实例
      	JavascriptExecutor je = (JavascriptExecutor) driver;
      		
      	//执行js语句，拖拽浏览器滚动条，直到该元素到底部，马上就不可以见
      	je.executeScript("arguments[0].scrollIntoView(true);",element);
      	Thread.sleep(500);
      	
      	WebElement userele =driver.findElement(By.xpath("//a[@id='uid']"));
      	je.executeScript("arguments[0].scrollIntoView(true)", userele);


	}

}
