package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import base.ProjectSpecificationMethods;

public class RegisterPage extends ProjectSpecificationMethods{

	public RegisterPage(WebDriver driver) {
		this.driver = driver;
	}
	public RegisterPage userName(String userNm) {
		if (userNm.isBlank()) {}
		else {
		driver.findElement(By.id("username")).sendKeys(userNm);
		}
		return this;
		
	}
	public RegisterPage password(String pass) {
		if(pass.isBlank()) {}
		else {
		driver.findElement(By.id("password")).sendKeys(pass);
		}
		return this;
	}
	public RegisterPage conPass(String pass) {
		if(pass.isBlank()) {}
		else {
		driver.findElement(By.id("re_password")).sendKeys(pass);
		}
		return this;
	}
	public RegisterPage fullName(String fullName) {
		if(fullName.isBlank()) {}
		else {
		driver.findElement(By.id("full_name")).sendKeys(fullName);
		}
		return this;
	}
	public RegisterPage email(String email) throws InterruptedException {
		if(email.isBlank()) {}
		else {
		driver.findElement(By.id("email_add")).sendKeys(email);
		}
		Thread.sleep(10000);
		return this;
	}
//	public RegisterPage captchaText(String captcha) {
//		driver.findElement(By.id("captcha-form")).sendKeys(captcha);
//		return this;
//	}
	public RegisterPage termsCond(String termCond) {
		if (termCond.equals("Yes")) {
		driver.findElement(By.id("tnc_box")).click();
		}
		return this;
	}
	public RegisterPage registerButton() throws InterruptedException {
		driver.findElement(By.xpath("//input[@id='Submit']")).click();
		Thread.sleep(3000);
		return new RegisterPage(driver);
	}
	public RegisterPage resetButton() throws InterruptedException {
		driver.findElement(By.xpath("//input[@id='Reset']")).click();
		Thread.sleep(3000);
		return new RegisterPage(driver);
	}
	public RegisterPage validateRegister(String testCase, String errorMessage) {
		if(testCase.equals("positive")) {
		Assert.assertTrue(driver.findElement(By.xpath("//td[@class='reg_success']"))!=null);
		}
		else if(testCase.equals("negative")) {
			Assert.assertTrue(driver.findElement(By.xpath("//label[text()='"+errorMessage+"']"))!=null);
		}
		return this;
		
	}
	
}
