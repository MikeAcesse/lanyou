package cn.lanyou.login;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import info2soft.qa.common.model.page.PageFragmentBaseUILocatorUtils;
import info2soft.qa.common.util.SeleniumUtil;

public class LoginTest extends PageFragmentBaseUILocatorUtils{
	WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		 System.setProperty("webdriver.chrome.driver", ".\\common\\chromedriver.exe");  
	     LoginTest lt = new LoginTest();
	     lt.login("admin", "123123qwe");
	     lt.enterRuleManagement();
		 //lt.deleteAllCopyRules();
		lt.checkLog();
	     lt.checkLog2();
	
	}
	
	public void login(String username,String password) {
		 driver = new ChromeDriver();  
		 driver.manage().window().maximize();  
		 int  width= driver.manage().window().getSize().getWidth();
		 System.out.println("current width: "+width);
		 int  height =driver.manage().window().getSize().getHeight();
		 //driver.manage().window().setSize(new Dimension(600,500));
		 System.out.println("current height: "+ height);
       //  driver.manage().window().setSize(new Dimension(width,height/2));
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
		 driver.get("https://172.20.18.210:58086/"); 
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
		
	    WebElement RuleManagementEle = driver.findElement(By.xpath("//span[contains(text(),'规则管理')]/preceding-sibling::*[name()='svg'][1]"));
	    RuleManagementEle.click();
	    WebElement CopyRuleEle = driver.findElement(By.xpath("//aside/div/ul/li[5]/ul/li[1]"));
		if(CopyRuleEle.isDisplayed()) {
			CopyRuleEle.click();
		} else {
			 RuleManagementEle.click();
			 CopyRuleEle.click();
		}
		
	}
	public void deleteAllCopyRules() throws InterruptedException {
	
		Thread.sleep(5*1000);
		 WebElement AllSelectInput =driver.findElement(By.xpath("//div[contains(text(),'名称')]/../preceding-sibling::th//label"));
		// WebElement AllSelectInput =driver.findElement(By.xpath("//thead[@class='has-gutter']/tr/th[1]//input"));
//		 JavascriptExecutor js= (JavascriptExecutor)driver;
//		 js.executeScript("arguments[0].click()", AllSelectInput);
		 String classstr=AllSelectInput.getAttribute("class");
		 System.out.println("classstr= "+classstr);
		 if(!classstr.contains("is-disabled")) {
			System.out.println("before click allselect ");
			System.out.println("111111111AllSelectInput.isEnabled()= " + AllSelectInput.isEnabled());
			System.out.println("111111111111AllSelectInput.isDisplayed()= " + AllSelectInput.isDisplayed());
			System.out.println("AllSelectInput.isSelected()= " + AllSelectInput.isSelected());
			System.out.println();
			AllSelectInput.click();
			System.out.println("AllSelectInput.isEnabled()= " + AllSelectInput.isEnabled());
			System.out.println("AllSelectInput.isDisplayed()= " + AllSelectInput.isDisplayed());
			System.out.println("AllSelectInput.isSelected()= " + AllSelectInput.isSelected());

			WebElement ruleDeleteBtn = driver
					.findElement(By.xpath("//div[@class='table-footer']//span[contains(text(),'删除')]"));
			ruleDeleteBtn.click();
			try {
				Thread.sleep(10 * 1000);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
			WebElement dialogDeleteBackupEle = driver
					.findElement(By.xpath("//input[contains(@class,'el-switch__input')]/following-sibling::span"));
			dialogDeleteBackupEle.click();
			WebElement dialogConfirmBtn = driver.findElement(By.xpath("//span[contains(text(),'确 定')]"));
			dialogConfirmBtn.click();
		 }else {
			     System.out.println("复制规则列表为空，不需要删除");
			
		 }
}
	
	public void checkLog() throws InterruptedException {
		  //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); 
		  WebElement moreEle= driver.findElement(By.xpath("//div[contains(text(),'abc')]/../following-sibling::td[last()]//span[contains(text(),'恢复')] /../following-sibling::div//span[contains(text(),'更多')]"));
		  //JavascriptExecutor js=(JavascriptExecutor) driver;
		 // js.executeScript("arguments[0].click()", moreEle);
		  Thread.sleep(5*1000);
		  moreEle.click(); 
		  //driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS); 
		  //WebElement checkLogEle=driver.findElement(By.xpath("//ul[not(contains(@style,'display')) and (contains(@x-placement,'start')) ]//span[contains(text(),'查看孤儿文件列表')]"));
		  WebElement checkLogEle=driver.findElement(By.xpath("//span[contains(text(),'查看日志')]"));
		  Thread.sleep(5*1000);
	      checkLogEle.click();
		  // js.executeScript("arguments[0].click()", checkLogEle);
	     //Actions action = new Actions(driver);
	    // action.moveToElement(checkLogEle).click(checkLogEle).perform();
	      Thread.sleep(2*1000);
	      driver.findElement(By.xpath("//span[contains(text(),'返回')]")).click();
	     System.out.println("task is finished");
	     
	     
	    
	
	}
	public void checkLog2() throws InterruptedException {
		 WebElement moreEle= driver.findElement(By.xpath("//div[contains(text(),'abc')]/../following-sibling::td[last()]//span[contains(text(),'恢复')] /../following-sibling::div//span[contains(text(),'更多')]"));
		  Thread.sleep(5*1000);
		  moreEle.click(); 
		 
		 ////ul[contains(@x-placement,'bottom-start')]
		  WebElement we=locatorWebElementWithXpath("//ul[contains(@x-placement,'-start')]");
		  Thread.sleep(2*1000);
		  List<WebElement> lists =SeleniumUtil.findElements(we, By.tagName("li"));
		  System.out.println("lists = "+lists);
		  for (WebElement ele : lists) {
			if(ele.getText().contains("查看日志")) {
			    ele.click();
			}
		}
		  
		  Thread.sleep(2*1000);
	      driver.findElement(By.xpath("//span[contains(text(),'返回')]")).click();
	     System.out.println("task is finished");
		  
		  
		  
		
		
	}
	
		
	


}
