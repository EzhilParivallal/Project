package pages;

import java.time.LocalDate;
import java.time.Period;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import base.ProjectSpecificationMethods;

public class SelectHotelPage extends ProjectSpecificationMethods {

	public SelectHotelPage(WebDriver driver) {
		this.driver = driver;
	}
	public SelectHotelPage selectRadioButton() {
		driver.findElement(By.id("radiobutton_0")).click();
		return this;
	}
	public BookHotelPage selectContinueButton() {
		driver.findElement(By.id("continue")).click();
		return new BookHotelPage(driver);
	}
	public void validateSearchHotel(String hotels,String location,String noOfRooms, String checkInDt,String checkOutDt,String roomType) throws InterruptedException {
		String[] actNoOfRooms=noOfRooms.split("-");
		String expNoOfRooms = actNoOfRooms[0]+"Rooms";
		String[] checkIn=checkInDt.split("/");
		String[] checkOut=checkOutDt.split("/");
		LocalDate date1 = LocalDate.of(Integer.valueOf(checkIn[2]), Integer.valueOf(checkIn[1]), Integer.valueOf(checkIn[0]));
        LocalDate date2 = LocalDate.of(Integer.valueOf(checkOut[2]), Integer.valueOf(checkOut[1]), Integer.valueOf(checkOut[0]));
        Period period = Period.between(date1, date2);
        int days = period.getDays();
		String expNoOfDays=days+" Days";
		String[] expHotels={"Hotel Cornice","Hotel Creek","Hotel Hervey","Hotel Sunshine"};
		String[] expRoomType= {"Standard","Double","Deluxe","Super Deluxe"};
		String expectedRoomType = null;
		if((roomType.isBlank())&&(hotels.isBlank())) {
			expectedRoomType="Standard";
		}
		else if(roomType.isBlank()) {
			expectedRoomType="Standard";
		}
		String[] actuHotel,actuLocation,actuNoOfRooms,actuCheckInDt,actuCheckOutDt,actuNoOfDays,actuRoomType,actuPricePerNight,actuTotalPrice;
		actuHotel=new String[4];
		actuLocation=new String[4];
		actuNoOfRooms=new String[4];
		actuCheckInDt = new String[4];
		actuCheckOutDt = new String[4];
		actuNoOfDays = new String[4];
		actuRoomType = new String[4];
		actuPricePerNight= new String[4];
		actuTotalPrice= new String[4];
		//if(hotels.isBlank()) {
			//expHotels= {"Hotel Cornice","Hotel Creek","Hotel Hervey","Hotel Sunshine"};
			//String actHotels="Hotel Cornice";
		//}
		if((roomType.isBlank())&&(hotels.isBlank())) {
			 for(int i=0;i<4;i++) {
			    	//String id="hotel_name_"+(i+1);
					actuHotel[i]=driver.findElement(By.id("hotel_name_"+(i+1))).getAttribute("value");
					actuLocation[i] = driver.findElement(By.id("location_"+(i+1))).getAttribute("value");
					actuNoOfRooms[i]=driver.findElement(By.id("rooms_"+(i+1))).getAttribute("value");
					actuCheckInDt[i]=driver.findElement(By.id("arr_date_"+(i+1))).getAttribute("value");
					actuCheckOutDt[i]=driver.findElement(By.id("dep_date_"+(i+1))).getAttribute("value");
					actuNoOfDays[i]=driver.findElement(By.id("no_days_"+(i+1))).getAttribute("value");
					actuRoomType[i]=driver.findElement(By.id("room_type_"+(i+1))).getAttribute("value");
					actuPricePerNight[i]=driver.findElement(By.id("price_night_"+(i+1))).getAttribute("value");
					actuTotalPrice[i]=driver.findElement(By.id("total_price_"+(i+1))).getAttribute("value");
				
			    }
			    for(int i=0;i<4;i++) {
			    	Assert.assertEquals(actuHotel[i], expHotels[i]);
					Assert.assertEquals(actuLocation[i], location);
					Assert.assertEquals(actuNoOfRooms[i], expNoOfRooms);
					Assert.assertEquals(actuCheckInDt[i],checkInDt);
					Assert.assertEquals(actuCheckOutDt[i], checkOutDt);
					Assert.assertEquals(actuNoOfDays[i], expNoOfDays);
					Assert.assertEquals(actuRoomType[i],expectedRoomType);
					Assert.assertNotNull(actuPricePerNight[i]);
					Assert.assertNotNull(actuTotalPrice[i]);
			    }
			   
			}
		else if(hotels.isBlank()) {
			 for(int i=0;i<4;i++) {
			    	//String id="hotel_name_"+(i+1);
					actuHotel[i]=driver.findElement(By.id("hotel_name_"+(i+1))).getAttribute("value");
					actuLocation[i] = driver.findElement(By.id("location_"+(i+1))).getAttribute("value");
					actuNoOfRooms[i]=driver.findElement(By.id("rooms_"+(i+1))).getAttribute("value");
					actuCheckInDt[i]=driver.findElement(By.id("arr_date_"+(i+1))).getAttribute("value");
					actuCheckOutDt[i]=driver.findElement(By.id("dep_date_"+(i+1))).getAttribute("value");
					actuNoOfDays[i]=driver.findElement(By.id("no_days_"+(i+1))).getAttribute("value");
					actuRoomType[i]=driver.findElement(By.id("room_type_"+(i+1))).getAttribute("value");
					actuPricePerNight[i]=driver.findElement(By.id("price_night_"+(i+1))).getAttribute("value");
					actuTotalPrice[i]=driver.findElement(By.id("total_price_"+(i+1))).getAttribute("value");
				
			    }
			    for(int i=0;i<4;i++) {
			    	Assert.assertEquals(actuHotel[i], expHotels[i]);
					Assert.assertEquals(actuLocation[i], location);
					Assert.assertEquals(actuNoOfRooms[i], expNoOfRooms);
					Assert.assertEquals(actuCheckInDt[i],checkInDt);
					Assert.assertEquals(actuCheckOutDt[i], checkOutDt);
					Assert.assertEquals(actuNoOfDays[i], expNoOfDays);
					Assert.assertEquals(actuRoomType[i],expectedRoomType);
					Assert.assertNotNull(actuPricePerNight[i]);
					Assert.assertNotNull(actuTotalPrice[i]);
			    }
		    }
		else if(roomType.isBlank()) {
			
		    for(int i=0;i<4;i++) {
		    	//String id="hotel_name_"+(i+1);
				actuHotel[i]=driver.findElement(By.id("hotel_name_"+(i+1))).getAttribute("value");
				actuLocation[i] = driver.findElement(By.id("location_"+(i+1))).getAttribute("value");
				actuNoOfRooms[i]=driver.findElement(By.id("rooms_"+(i+1))).getAttribute("value");
				actuCheckInDt[i]=driver.findElement(By.id("arr_date_"+(i+1))).getAttribute("value");
				actuCheckOutDt[i]=driver.findElement(By.id("dep_date_"+(i+1))).getAttribute("value");
				actuNoOfDays[i]=driver.findElement(By.id("no_days_"+(i+1))).getAttribute("value");
				actuRoomType[i]=driver.findElement(By.id("room_type_"+(i+1))).getAttribute("value");
				actuPricePerNight[i]=driver.findElement(By.id("price_night_"+(i+1))).getAttribute("value");
				actuTotalPrice[i]=driver.findElement(By.id("total_price_"+(i+1))).getAttribute("value");
			
		    }
		    for(int i=0;i<4;i++) {
		    	Assert.assertEquals(actuHotel[i], hotels);
				Assert.assertEquals(actuLocation[i], location);
				Assert.assertEquals(actuNoOfRooms[i], expNoOfRooms);
				Assert.assertEquals(actuCheckInDt[i],checkInDt);
				Assert.assertEquals(actuCheckOutDt[i], checkOutDt);
				Assert.assertEquals(actuNoOfDays[i], expNoOfDays);
				Assert.assertEquals(actuRoomType[i],expRoomType[i]);
				Assert.assertNotNull(actuPricePerNight[i]);
				Assert.assertNotNull(actuTotalPrice[i]);
		    }
		
		}
		else {
		String actualHotel = driver.findElement(By.id("hotel_name_0")).getAttribute("value");
		String actualLocation = driver.findElement(By.id("location_0")).getAttribute("value");
		String actualNoOfRooms=driver.findElement(By.id("rooms_0")).getAttribute("value");
		String actualCheckInDt=driver.findElement(By.id("arr_date_0")).getAttribute("value");
		String actualCheckOutDt=driver.findElement(By.id("dep_date_0")).getAttribute("value");
		String actualNoOfDays=driver.findElement(By.id("no_days_0")).getAttribute("value");
		String actualRoomType=driver.findElement(By.id("room_type_0")).getAttribute("value");
		String pricePerNight=driver.findElement(By.id("price_night_0")).getAttribute("value");
		String totalPrice=driver.findElement(By.id("total_price_0")).getAttribute("value");
		Assert.assertEquals(actualHotel, hotels);
		Assert.assertEquals(actualLocation, location);
		Assert.assertEquals(actualNoOfRooms, expNoOfRooms);
		Assert.assertEquals(actualCheckInDt,checkInDt);
		Assert.assertEquals(actualCheckOutDt, checkOutDt);
		Assert.assertEquals(actualNoOfDays, expNoOfDays);
		Assert.assertEquals(actualRoomType,roomType);
		Assert.assertNotNull(pricePerNight);
		Assert.assertNotNull(totalPrice);
		Thread.sleep(3000);
		}
		
		//System.out.println(expNoOfRooms+" "+expNoOfDays);
		
	}

}
