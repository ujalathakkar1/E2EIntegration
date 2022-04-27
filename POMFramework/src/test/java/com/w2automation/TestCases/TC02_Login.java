package com.w2automation.TestCases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.w2a.automation.DataGeneration.Datagen;
import com.w2automation.base.Base;
import com.w2automation.pages.LoginPage;


public class TC02_Login extends Base{
	@Test(priority = 2,dataProvider="dp",dataProviderClass=Datagen.class)
	public void doLogin(String email,String pass) throws IOException, InterruptedException
	{
		//System.out.println(email+"and"+pass);
		LoginPage l1=new LoginPage(driver);
		l1.enterusername(email);
		l1.enterpassword(pass);
		l1.dologin();
		l1.clickLogout();
	}
	
	

}
