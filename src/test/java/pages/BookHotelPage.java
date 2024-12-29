package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import base.ProjectSpecificationMethods;

public class BookHotelPage extends ProjectSpecificationMethods {

	public BookHotelPage(WebDriver driver) {
		this.driver=driver;
	}
	public BookHotelPage validateSelectPage() {
		Assert.assertNotNull(driver.findElement(By.className("login_title")));
		return this;
	}
	public BookHotelPage firstNm(String firstNm) {
		driver.findElement(By.id("first_name")).sendKeys(firstNm);
		return this;
	}
	public BookHotelPage lastNm(String lastNm) {
		driver.findElement(By.id("last_name")).sendKeys(lastNm);
		return this;
	}
	public BookHotelPage address(String address) {
		driver.findElement(By.id("address")).sendKeys(address);
		return this;
	}
	public BookHotelPage ccNum(String ccNum) {
		driver.findElement(By.id("cc_num")).sendKeys(ccNum);
		return this;
	}
	public BookHotelPage ccType(String ccType) {
    	WebElement dropdown = driver.findElement(By.xpath("//select[@id='cc_type']/option[contains(text(), '" + ccType + "')]"));
        dropdown.click();
		return this;
    }
	public BookHotelPage ccExpMonth(String ccExpMonth) {
    	WebElement dropdown = driver.findElement(By.xpath("//select[@id='cc_exp_month']/option[contains(text(), '" + ccExpMonth + "')]"));
        dropdown.click();
		return this;
    }
	public BookHotelPage ccExpYear(String ccExpYear) {
    	WebElement dropdown = driver.findElement(By.xpath("//select[@id='cc_exp_year']/option[contains(text(), '" + ccExpYear + "')]"));
        dropdown.click();
		return this;
    }
	public BookHotelPage ccCVV(String ccCVV) {
    	driver.findElement(By.id("cc_cvv")).sendKeys(ccCVV);
		return this;
    }
	public BookConfirmPage bookNow(String testCase,String errorMessage) throws InterruptedException {
    	driver.findElement(By.id("book_now")).click();
    	Thread.sleep(3000);
    	if(testCase.equals("negative_book")) {
    		Assert.assertTrue(driver.findElement(By.xpath("//label[text()='"+errorMessage+"']"))!=null);
        	
    	}
		return new BookConfirmPage(driver);
    }
}
