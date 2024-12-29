package test;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethods;
import pages.HomePage;
import pages.RegisterPage;

public class TC_001_SignUpTest extends ProjectSpecificationMethods{
	@BeforeTest
	public void setup() throws IOException {
		sheetName ="SignUpTestData";
		testName="SignUpTest";
		testDescription="Testing Sign up functionality";
		testAuthor="Ezhil Parivallal";
		testCategory="Smoke Testing";
	}
	@Test(dataProvider = "excelRead")
	public void SignUpTest(String userNm, String password, String conPassword, String fullNm,String email,String termCond, String testCase, String errorMessage) throws InterruptedException{
		// TODO Auto-generated method stub
		
		HomePage obj = new HomePage(driver);
		obj.registerClick()
		.userName(userNm)
		.password(password)
		.conPass(conPassword)
		.fullName(fullNm)
		.email(email)
		.termsCond(termCond)
		.registerButton()
		.validateRegister(testCase,errorMessage);
	}


}
