package com.w2automation.TestCases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.w2a.automation.DataGeneration.Datagen;
import com.w2automation.base.Base;
import com.w2automation.pages.RegistrationPage;


public class TC01_Registration extends Base{
	
	
	
	@Test(priority = 1,dataProvider="dp",dataProviderClass=Datagen.class)
	public void doRegistration(String email,String fname,String lname,String pass,String address,String city,String state,String postcode,String phone) throws IOException, InterruptedException
	{
		System.out.println("email is:"+ email +fname+lname+pass+address+city+state+postcode+phone);
		RegistrationPage r1=new RegistrationPage(driver);
		r1.clickSignIn();
		System.out.println("hi1");
		r1.enteremail(email);
		r1.SubmitBtn();
		Thread.sleep(5000);
		r1.enterfname(fname);
		r1.enterlname(lname);
		r1.enterPassword(pass);
		r1.enterAddress(address);
		r1.enterCity(city);
		Thread.sleep(4000);
		r1.SelectState(state);
		r1.enterpostcode(postcode);
		r1.enterPhone(phone);
		r1.SubmitAccount();
		Thread.sleep(4000);
		r1.clickLogout();
		Thread.sleep(4000);
		
		
		
	}

}
