package cn.lanyou.login;

import cn.lanyou.common.i2upLogin;

public class compareRuleTest extends i2upLogin{

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".\\common\\chromedriver.exe"); 
		i2upLogin i2upLogin =new i2upLogin();
		i2upLogin.login("admin", "Info1234");
		i2upLogin.enterCompareRuleManagement();
		i2upLogin.deleteAllCompareRules();
		//i2upLogin.deleteAllCompareRuleOneByOne();
		

	}

}
