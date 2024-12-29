package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import base.ProjectSpecificationMethods;

public class HomePage extends ProjectSpecificationMethods{
	public HomePage(WebDriver driver) {
		this.driver=driver;
		//PageFactory.initElements(driver, this);
	}
	public RegisterPage registerClick() {
		driver.findElement(By.xpath("//a[text()='New User Register Here']")).click();
		return new RegisterPage(driver);
	}
	public HomePage userName(String userNm) {
		if(userNm.isBlank()) {}
		else {
		driver.findElement(By.id("username")).sendKeys(userNm);
		}
		return this;
	}
	public HomePage password(String pass) {
		if(pass.isBlank()) {}
		else {
		driver.findElement(By.id("password")).sendKeys(pass);
		}
		return this;
	}
	public SearchHotelPage loginClick(String testCase,String errorMessage) {
		driver.findElement(By.id("login")).click();
		if(testCase.equals("negative_login")) {
			if(errorMessage.contains("Enter")) {
			Assert.assertTrue(driver.findElement(By.xpath("//span[text()='"+errorMessage+"']")).isDisplayed());
		}
		else {
			Assert.assertTrue(driver.findElement(By.xpath("//b[text()='"+errorMessage+"']")).isDisplayed());
		}
		}
		return new SearchHotelPage(driver);
	}
	public void validateLogin1(String testCase,String errorMessage) {
		
	}
	
}
