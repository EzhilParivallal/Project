package test;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethods;
import pages.HomePage;
import pages.SearchHotelPage;

public class TC_004_SearchHotelTest extends ProjectSpecificationMethods {
	@BeforeTest
	public void setup() throws IOException {
		readFromPropFile("LoginTestData");
		sheetName="SearchHotelTestData";
		testName="SearchHotelTest";
		testDescription="Testing Search Hotel functionality";
		testAuthor="Ezhil Parivallal";
		testCategory="Smoke Testing";
	}
	@Test(dataProvider = "excelRead")
	public void SearchHotelTest(String location,String hotels,String roomType,String noOfRooms, String checkInDt, String checkOutDt, String adultsPerRoom, String childrenPerRoom,String testCase, String errorMessage) throws InterruptedException{
		// TODO Auto-generated method stub
    	HomePage obj = new HomePage(driver);
		obj.userName(prop.getProperty("userNm"))
		.password(prop.getProperty("password"))
		.loginClick(testCase,errorMessage);
		SearchHotelPage obj1 = new SearchHotelPage(driver);
		if(testCase.equals("positive")) {
		obj1.location(location)
		.hotels(hotels)
		.roomType(roomType)
		.noOfRooms(noOfRooms)
		.checkInDt(checkInDt)
		.checkOutDt(checkOutDt)
		.adultsPerRoom(adultsPerRoom)
		.childrenPerRoom(childrenPerRoom)
		.searchButton(testCase,errorMessage) 
		.validateSearchHotel(hotels,location, noOfRooms, checkInDt, checkOutDt, roomType);
		}
		else {
			obj1.location(location)
			.hotels(hotels)
			.roomType(roomType)
			.noOfRooms(noOfRooms)
			.checkInDt(checkInDt)
			.checkOutDt(checkOutDt)
			.adultsPerRoom(adultsPerRoom)
			.childrenPerRoom(childrenPerRoom)
			.searchButton(testCase,errorMessage); 
		}
	}

}
