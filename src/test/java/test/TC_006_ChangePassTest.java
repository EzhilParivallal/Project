package test;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethods;
import pages.HomePage;

public class TC_006_ChangePassTest extends ProjectSpecificationMethods{
	@BeforeTest
	public void setup() throws IOException {
		sheetName="ChangePassTestData";
		testName="ChangePassTest";
		testDescription="Testing Change Password functionality with positive case";
		testAuthor="Ezhil Parivallal";
		testCategory="Smoke Testing";
	}
	@Test(dataProvider = "excelRead")
	public void ChangePassTest(String loginID, String loginPass,String password, String newPass, String conPass,String testCase, String errorMessage) throws InterruptedException{
		// TODO Auto-generated method stub
		HomePage obj = new HomePage(driver);
		obj.userName(loginID)
		.password(loginPass)
		.loginClick(testCase,errorMessage)
		.changePassClick()
		.currPass(password)
		.newPass(newPass)
		.conPass(conPass)
		.submitButton()
		.validateChangePass(testCase, errorMessage);
		Thread.sleep(3000);
	}

}
