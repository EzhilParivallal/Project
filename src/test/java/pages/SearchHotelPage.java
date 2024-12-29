package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import base.ProjectSpecificationMethods;

public class SearchHotelPage extends ProjectSpecificationMethods {

	public SearchHotelPage(WebDriver driver) {
		this.driver=driver;
	}
	public void validateLogin(String userNm, String testCase, String errorMessage) {
		String actual = driver.findElement(By.id("username_show")).getAttribute("value");
		String expected = "Hello "+userNm+"!";
		if(testCase.equals("positive")) {
		Assert.assertEquals(actual,expected);
		}
		
	}
	public LogoutPage logoutClick() {
		driver.findElement(By.xpath("//a[text()='Logout']")).click();
		return new LogoutPage(driver);
	}
	public ChangePassPage changePassClick() {
		driver.findElement(By.xpath("//a[text()='Change Password']")).click();
		return new ChangePassPage(driver);
	}

    public SearchHotelPage location(String location) {
    	if(location.isBlank()) {}
    	else {
    	WebElement dropdown = driver.findElement(By.xpath("//select[@class='search_combobox']/option[contains(text(), '" + location + "')]"));
        dropdown.click();
    	}
		return this;
    }
    public SearchHotelPage hotels(String hotels) {
    	if(hotels.isBlank()) {}
    	else {
    	WebElement dropdown = driver.findElement(By.xpath("//select[@class='search_combobox']/option[contains(text(), '" + hotels + "')]"));
        dropdown.click();
    	}
		return this;
    }
    public SearchHotelPage roomType(String roomType) {
    	if(roomType.isBlank()) {}
    	else {
    	WebElement dropdown = driver.findElement(By.xpath("//select[@class='search_combobox']/option[contains(text(), '" + roomType + "')]"));
        dropdown.click();
    	}
		return this;
    }
    public SearchHotelPage noOfRooms(String noOfRooms) {
    	if(noOfRooms.isBlank()) {
    		WebElement dropdown = driver.findElement(By.xpath("//select[@class='search_combobox']/option[contains(text(), '- Select Number of Rooms -')]"));
            dropdown.click();
    	}
    	else {
    	WebElement dropdown = driver.findElement(By.xpath("//select[@class='search_combobox']/option[contains(text(), '" + noOfRooms + "')]"));
        dropdown.click();
    	}
		return this;
    }
    public SearchHotelPage checkInDt(String checkInDt) {
    	WebElement checkIn = driver.findElement(By.id("datepick_in"));
    	checkIn.clear();
    	if(checkInDt.isBlank()) {}
    	else {
    	checkIn.sendKeys(checkInDt);
    	}
		return this;
    }
    public SearchHotelPage checkOutDt(String checkOutDt) {
    	WebElement checkOut = driver.findElement(By.id("datepick_out"));
    	checkOut.clear();
    	if(checkOutDt.isBlank()) {}
    	else {
    	checkOut.sendKeys(checkOutDt);
    	}
		return this;
    }
    public SearchHotelPage adultsPerRoom(String adultsPerRoom) {
    	if(adultsPerRoom.isBlank()) {
    		WebElement dropdown = driver.findElement(By.xpath("//select[@id='adult_room']/option[contains(text(), '- Select Adults per Room -')]"));
            dropdown.click();
    	}
    	else {
    	WebElement dropdown = driver.findElement(By.xpath("//select[@id='adult_room']/option[contains(text(), '" + adultsPerRoom + "')]"));
        dropdown.click();
    	}
		return this;
    }
    public SearchHotelPage childrenPerRoom(String childrenPerRoom) throws InterruptedException {
    	if(childrenPerRoom.isBlank()) {}
    	else {
    	WebElement dropdown = driver.findElement(By.xpath("//select[@id='child_room']/option[contains(text(), '" + childrenPerRoom + "')]"));
        dropdown.click();
    	}
        Thread.sleep(2000);
		return this;
    }
    public SelectHotelPage searchButton(String testCase, String errorMessage) throws InterruptedException {
    	driver.findElement(By.id("Submit")).click();
    	Thread.sleep(3000);
    	if(testCase.equals("negative")) {
    		Assert.assertTrue(driver.findElement(By.xpath("//span[text()='"+errorMessage+"']"))!=null);
    	}
    	return new SelectHotelPage(driver);
    }
}
