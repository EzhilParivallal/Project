package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.ProjectSpecificationMethods;

public class BookedItineraryPage extends ProjectSpecificationMethods {

	public BookedItineraryPage(WebDriver driver) {
		this.driver=driver;
	}
	public BookedItineraryPage searchItinerary(String orderID){
		driver.findElement(By.id("order_id_text")).sendKeys(orderID);
		driver.findElement(By.id("search_hotel_id")).click();
		return this;	
	}
	

}
