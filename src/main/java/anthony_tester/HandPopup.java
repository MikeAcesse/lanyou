package anthony_tester;

import org.apache.log4j.Logger;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * @author fanzk
 * @version 1.8
 * @date 2020/7/14 18:32
 */
public class HandPopup {
	public static void main(String[] args) {
		Logger logger = Logger.getLogger(HandPopup.class);
		// 创建DesiredCapabilities类的一个对象实例
		DesiredCapabilities cap = DesiredCapabilities.chrome();
		logger.info("创建DesiredCapabilities类的一个对象实例");
		// 设置变量ACCEPT_SSL_CERTS的值为True
		cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS,true);
		logger.info("设置变量ACCEPT_SSL_CERTS的值为True");
		System.setProperty("webdriver.chrome.driver", "common/chromedriver.exe");
		// 打开带capability设置选项的浏览器
		WebDriver driver = new ChromeDriver(cap);
		driver.manage().window().maximize();
		driver.get("https://kyfw.12306.cn/otn");


	}
}
