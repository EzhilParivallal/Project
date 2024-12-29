package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import base.ProjectSpecificationMethods;

public class LogoutPage extends ProjectSpecificationMethods{

	public LogoutPage(WebDriver driver) {
		this.driver = driver;
	}
	public void validateLogout() {
		Assert.assertTrue(driver.findElement(By.xpath("//td[@class='reg_success']"))!=null);
	}

}
