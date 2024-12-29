package test;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethods;
import pages.BookHotelPage;
import pages.HomePage;
import pages.SearchHotelPage;

public class TC_005_BookHotelTest extends ProjectSpecificationMethods{
	@BeforeTest
	public void setup() throws IOException {
		readFromPropFile("SearchHotelTestData");
		sheetName="BookHotelTestData";
		testName="BookingHotelTest";
		testDescription="Testing booking Hotel functionality";
		testAuthor="Ezhil Parivallal";
		testCategory="Smoke Testing";
	}
	@Test(dataProvider = "excelRead")
	public void BookHotelTest(String firstNm,String lastNm,String address, String ccNum, String ccType,String ccExpMonth,String ccExpYear, String ccCVV, String testCase, String errorMessage) throws InterruptedException{
		// TODO Auto-generated method stub
    	HomePage obj = new HomePage(driver);
		obj.userName(prop.getProperty("userNm"))
		.password(prop.getProperty("password"))
		.loginClick(testCase,errorMessage);
		SearchHotelPage obj1 = new SearchHotelPage(driver);
		obj1.location(prop.getProperty("location"))
		.hotels(prop.getProperty("hotels"))
		.roomType(prop.getProperty("roomType"))
		.noOfRooms(prop.getProperty("noOfRooms"))
		.checkInDt(prop.getProperty("checkInDt"))
		.checkOutDt(prop.getProperty("checkOutDt"))
		.adultsPerRoom(prop.getProperty("adultsPerRoom"))
		.childrenPerRoom(prop.getProperty("childrenPerRoom"))
		.searchButton(testCase,errorMessage) 
		.selectRadioButton()
		.selectContinueButton();
		BookHotelPage obj2 = new BookHotelPage(driver);
		if(testCase.equals("positive")) {
		obj2.firstNm(firstNm)
		.lastNm(lastNm)
		.address(address)
		.ccNum(ccNum)
		.ccType(ccType)
		.ccExpMonth(ccExpMonth)
		.ccExpYear(ccExpYear)
		.ccCVV(ccCVV)
		.bookNow(testCase,errorMessage)
		.validateBookingConfirm(prop.getProperty("hotels"),prop.getProperty("location"),prop.getProperty("roomType"),prop.getProperty("checkInDt"),prop.getProperty("checkOutDt"),prop.getProperty("expNoOfRooms"),prop.getProperty("expNoOfAdults"),prop.getProperty("expNoOfChildren"),
				firstNm,lastNm,address);}
		else {
			obj2.firstNm(firstNm)
			.lastNm(lastNm)
			.address(address)
			.ccNum(ccNum)
			.ccType(ccType)
			.ccExpMonth(ccExpMonth)
			.ccExpYear(ccExpYear)
			.ccCVV(ccCVV)
			.bookNow(testCase,errorMessage);
			
		}
	}

}
