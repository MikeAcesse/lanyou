package cn.lanyou.i2up;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scrollbar {
	WebDriver driver;
	
	public static void main(String[] args) {
		      String url="file:\\e:\\eclipse-workspace\\lanyou\\html\\scrollbar.html";
		      String scriptMaxLef = "document.getElementsByClassName('scroll')[0].scrollLeft=10000";
		      String scriptMinLef="document.getElementsByClassName('scroll')[0].scrollLeft=0";
		      String scriptMaxTop="document.getElementsByClassName('scroll')[0].scrollTop=10000";
		      String scriptMinTop="document.getElementsByClassName('scroll')[0].scrollTop=0";
		      Scrollbar  sb= new Scrollbar();
		      sb.initDriver();
		      sb.openURl(url);
		      //sb.executeScrollbar(scriptMaxLef);
		      //sb.executeScrollbar(scriptMinLef);
		      sb.executeScrollbar(scriptMaxTop);
		      //sb.executeScrollbar(scriptMinTop);
		      
			
				
				
	}
	
	
   public void initDriver() {
	    System.setProperty("webdriver.chrome.driver", "common\\chromedriver.exe");
		//初始化一个chrome实例，实例名称叫driver
		driver = new ChromeDriver();
		//最大化窗口
		driver.manage().window().maximize();
		//设置隐性等待时间
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
	   
   }
   public void testSrollBar() {
	   
   }
   public void quit() {
	   //关闭并退出浏览器
		driver.quit();
   }
   public void openURl(String url) {
	   driver.get(url);
   }
   public void getAssertInformation() {
	   //getTitle()获取当前页面title的值
	   System.out.println("当前打开页面的标题是： "+ driver.getTitle());
   }
   public void executeScrollbar(String script) {
	   try {
		Thread.sleep(10*1000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   ((JavascriptExecutor)driver).executeScript(script);
	  // driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
	   try {
			Thread.sleep(10*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   }
}
