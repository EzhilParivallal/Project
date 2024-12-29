package test;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethods;
import pages.HomePage;

public class TC_003_LogoutTest extends ProjectSpecificationMethods {
	@BeforeTest
	public void setup() throws IOException {
		readFromPropFile("LoginTestData");
		testName="LogoutTest";
		testDescription="Testing Logout functionality";
		testAuthor="Ezhil Parivallal";
		testCategory="Smoke Testing";
	}
	@Test
	public void ValidLogoutTest() throws InterruptedException{
		// TODO Auto-generated method stub
		String testCase = "positive";
		String errorMessage = null;
		HomePage obj = new HomePage(driver);
		obj.userName(prop.getProperty("userNm"))
		.password(prop.getProperty("password"))
		.loginClick(testCase,errorMessage)
		.logoutClick()
		.validateLogout();
	}

}
