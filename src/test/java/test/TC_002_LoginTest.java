package test;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethods;
import pages.HomePage;

public class TC_002_LoginTest extends ProjectSpecificationMethods{
	@BeforeTest
	public void setup() throws IOException {
		sheetName="LoginTestData";
		testName="LoginTest";
		testDescription="Testing Log in functionality";
		testAuthor="Ezhil Parivallal";
		testCategory="Smoke Testing";
	}
	@Test(dataProvider = "excelRead")
	public void LoginTest(String userNm, String password,String testCase,String errorMessage) throws InterruptedException{
		// TODO Auto-generated method stub
		
		HomePage obj = new HomePage(driver);
		if(testCase.equals("positive")) {
		obj.userName(userNm)
		.password(password)
		.loginClick(testCase,errorMessage)
		.validateLogin(userNm,testCase,errorMessage);
		}
		else {
			obj.userName(userNm)
			.password(password)
			.loginClick(testCase,errorMessage);
		}
		
	}
}
