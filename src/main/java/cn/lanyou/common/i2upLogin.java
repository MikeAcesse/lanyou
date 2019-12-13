package cn.lanyou.common;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class i2upLogin {
	WebDriver driver;
	WebElement RuleManagementEle;

	public void login(String username, String password) {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		int width = driver.manage().window().getSize().getWidth();
		System.out.println("current width: " + width);
		int height = driver.manage().window().getSize().getHeight();
		// driver.manage().window().setSize(new Dimension(600,500));
		System.out.println("current height: " + height);
		// driver.manage().window().setSize(new Dimension(width,height/2));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://172.20.68.105:58086/");
		WebElement loginEle = driver.findElement(By.xpath("//div[contains(text(),'登 录')]"));
		loginEle.click();
		WebElement usernameEle = driver.findElement(By.xpath("//input[@type='text']"));
		usernameEle.sendKeys(username);
		WebElement passwordEle = driver.findElement(By.xpath("//input[contains(@type,'password')]"));
		passwordEle.sendKeys(password);
		WebElement loginEleBtn = driver.findElement(By.xpath("//button/span[contains(text(),'登 录')]"));
		loginEleBtn.click();
		WebElement enterEleBtn = driver.findElement(By.xpath("//button[contains(text(),'点击进入')]"));
		enterEleBtn.click();
		WebElement expandRightIcon = driver.findElement(By.xpath("//aside/div/div/*[name()='svg'][1]"));
		expandRightIcon.click();
	}

	public void enterRuleManagement() {

		RuleManagementEle = driver
				.findElement(By.xpath("//span[contains(text(),'规则管理')]/preceding-sibling::*[name()='svg'][1]"));
		RuleManagementEle.click();
		WebElement CopyRuleEle = driver.findElement(By.xpath("//aside/div/ul/li[5]/ul/li[1]"));
		if (CopyRuleEle.isDisplayed()) {
			CopyRuleEle.click();
		} else {
			RuleManagementEle.click();
			CopyRuleEle.click();
		}

	}

	public void enterCompareRuleManagement() {
		try {
			Thread.sleep(10 * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RuleManagementEle = driver
				.findElement(By.xpath("//span[contains(text(),'实用工具')]/preceding-sibling::*[name()='svg'][1]"));
		RuleManagementEle.click();
		WebElement CompareRuleEle = driver.findElement(By.xpath("//li[contains(text(),'比较和同步')]"));
		if (CompareRuleEle.isDisplayed()) {
			CompareRuleEle.click();
		} else {
			RuleManagementEle.click();
			CompareRuleEle.click();
		}
	}

	public void deleteAllCompareRules() throws InterruptedException {
		Thread.sleep(5 * 1000);
		WebElement divEles = driver.findElement(By.xpath("//div[contains(@class,'el-table__body-wrapper')]"));
		List<WebElement> trs = divEles.findElements(By.tagName("tr"));
		
		while ( trs.size() > 0) {
			    WebElement AllSelectInput = driver
					.findElement(By.xpath("//div[contains(text(),'任务开始时间')]/../preceding-sibling::th//label"));
				AllSelectInput.click();
				WebElement CompareRuleDeleteBtn = driver
						.findElement(By.xpath("//div[@class='table-footer']//span[contains(text(),'删除')]"));
				CompareRuleDeleteBtn.click();
				try {
					Thread.sleep(10 * 1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				WebElement dialogConfirmBtn = driver
						.findElement(By.xpath("//div[contains(@aria-label,'消息')]//span[contains(text(),'确 定')]"));
				dialogConfirmBtn.click();
				Thread.sleep(5 * 1000);
				trs = divEles.findElements(By.tagName("tr"));
			} 
		}
	
	
	public void deleteAllCompareRuleOneByOne() throws InterruptedException {
		try {
			Thread.sleep(2 * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		WebElement divEles = driver.findElement(By.xpath("//div[contains(@class,'el-table__body-wrapper')]"));
		List<WebElement> trs = divEles.findElements(By.tagName("tr"));
		while ( trs.size() > 0) {
			Thread.sleep(2 * 1000);
			int trNum=trs.size();
			WebElement compareRuleNametdEle = trs.get(0).findElements(By.tagName("td")).get(2);
			String compareRuleName=compareRuleNametdEle.getText().trim();
			WebElement CompareRuleDeleteBtn = driver
					.findElement(By.xpath("//div[text()='" + compareRuleName + "']/../following-sibling::td[last()]//span[starts-with(text(),'删除')]"));
			CompareRuleDeleteBtn.click();
			try {
				Thread.sleep(2 * 1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			WebElement dialogConfirmBtn = driver
					.findElement(By.xpath("//div[contains(@aria-label,'消息')]//span[contains(text(),'确 定')]"));
			dialogConfirmBtn.click();
			try {
				Thread.sleep(2 * 1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			
			trs = divEles.findElements(By.tagName("tr"));
			System.out.println("trs-> "+trs.size());
			
		} 
		
		
	}
	
}
