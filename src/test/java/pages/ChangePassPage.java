package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import base.ProjectSpecificationMethods;

public class ChangePassPage extends ProjectSpecificationMethods{

	public ChangePassPage(WebDriver driver) {
		this.driver = driver;
	}
    public ChangePassPage currPass(String pass) {
    	driver.findElement(By.id("current_pass")).sendKeys(pass);
		return this;	
    }
    public ChangePassPage newPass(String newPass) {
    	driver.findElement(By.id("new_password")).sendKeys(newPass);
    	return this;
    }
    public ChangePassPage conPass(String conPass) {
    	driver.findElement(By.id("re_password")).sendKeys(conPass);
    	return this;
    }
    public ChangePassPage submitButton() {
    	driver.findElement(By.id("Submit")).click();
    	return this;
    }
    public ChangePassPage validateChangePass(String testCase,String errorMessage) {
    	if(testCase.equals("positive")) {
    	Assert.assertTrue(driver.findElement(By.xpath("//span[text()='Your Password is successfully updated!!!']"))!=null);
    	}
    	else
    	{
    		Assert.assertTrue(driver.findElement(By.xpath("//span[text()='"+errorMessage+"']"))!=null);	
    	}
		return this;
    }
}
