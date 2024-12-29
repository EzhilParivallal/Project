package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import base.ProjectSpecificationMethods;

public class BookConfirmPage extends ProjectSpecificationMethods {

	public BookConfirmPage(WebDriver driver) {
		this.driver=driver;
	}
	public SearchHotelPage searchHotelButton() {
		driver.findElement(By.id("search_hotel")).click();
		return new SearchHotelPage(driver);
	}
	public BookedItineraryPage myItineraryButton() {
		driver.findElement(By.id("my_itinerary")).click();
		return new BookedItineraryPage(driver);
	}
	public LogoutPage logoutButton() {
		driver.findElement(By.id("logout")).click();
		return new LogoutPage(driver);
	}
	public void validateBookingConfirm(String expHotel, String expLocation, String expRoomType, String expArrivalDate, String expDepartureDate, String expTotalRooms, 
			String expAdultsPerRoom, String expChildrenPerRoom, String firstNm, String lastNm, String address) {
		String Hotel=driver.findElement(By.id("hotel_name")).getAttribute("value");
		String Location=driver.findElement(By.id("location")).getAttribute("value");
		String RoomType=driver.findElement(By.id("room_type")).getAttribute("value");
		String ArrivalDate=driver.findElement(By.id("arrival_date")).getAttribute("value");
		String DepartureDate=driver.findElement(By.id("departure_text")).getAttribute("value");
		String TotalRooms=driver.findElement(By.id("total_rooms")).getAttribute("value");
		String AdultsPerRoom=driver.findElement(By.id("adults_room")).getAttribute("value");
		String ChildrenPerRoom=driver.findElement(By.id("children_room")).getAttribute("value");
		String FirstName=driver.findElement(By.id("first_name")).getAttribute("value");
		String LastName=driver.findElement(By.id("last_name")).getAttribute("value");
		String Address=driver.findElement(By.id("address")).getAttribute("value");
		String PricePerNight=driver.findElement(By.id("price_night")).getAttribute("value");
		String TotalPrice=driver.findElement(By.id("total_price")).getAttribute("value");
		String GST=driver.findElement(By.id("gst")).getAttribute("value");
		String FinalBilledPrice=driver.findElement(By.id("final_price")).getAttribute("value");
		Assert.assertEquals(expHotel,Hotel);
		Assert.assertEquals(expLocation,Location);
		Assert.assertEquals(expRoomType,RoomType);
		Assert.assertEquals(expArrivalDate,ArrivalDate);
		Assert.assertEquals(expTotalRooms,TotalRooms);
		Assert.assertEquals(expDepartureDate,DepartureDate);
		Assert.assertEquals(expAdultsPerRoom,AdultsPerRoom);
		Assert.assertEquals(expChildrenPerRoom,ChildrenPerRoom);
		Assert.assertEquals(firstNm,FirstName);
		Assert.assertEquals(lastNm,LastName);
		Assert.assertEquals(address,Address);
		
	}

}
