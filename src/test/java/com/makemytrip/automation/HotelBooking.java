package com.makemytrip.automation;

import java.net.URL;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;



public class HotelBooking {
	

    static AppiumDriver driver;
//	private static AndroidDriver driver;
	
	@Test(priority = 0)
	
	public  void firstTimeopenMakeMyApplication() throws Exception {
		
		
		System.out.println("started ");
		
		
		 DesiredCapabilities capabilities = new DesiredCapabilities();
	        capabilities.setCapability("platformName", "Android");
	        capabilities.setCapability("platformVersion", "14.0");
	        capabilities.setCapability("deviceName", "Pixel 7 API 34");
	        capabilities.setCapability("appPackage", "com.makemytrip");
	        capabilities.setCapability("appActivity", "com.mmt.travel.app.home.ui.SplashActivity");
	        capabilities.setCapability("noReset", "true");
	        capabilities.setCapability("automationName", "UIautomator2");
	        System.out.println("passed");
	        
	        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), capabilities);
	       
	      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        
	        System.out.println("passed1");
	        
					
		
	}
 
	
	@Test(priority = 1)
	public  void clickOnHotelIcons() throws Exception {
		List<WebElement> list = driver.findElements(By.id("com.makemytrip:id/tvTitle"));
		 System.out.println("passed2");
		List<WebElement> listHotel = driver.findElements(By.id("com.makemytrip:id/ivIcon"));
		
		for (int i = 0; i < list.size(); i++) {
			WebElement element = list.get(i);
			String getText = element.getText();
			if (getText.equals("Hotels")) {
				listHotel.get(i).click();
				Thread.sleep(5000);
				break;
			}
		}
		
		System.out.println("passed2");
	}
 
	
	@Test(priority = 2)
	public  void selectCity() throws Exception {
		WebElement searchCity = driver.findElement(By.id("com.makemytrip:id/icon"));
		searchCity.click();
		//driver.hideKeyboard();
		Thread.sleep(5000);
		WebElement city = driver.findElement(By.className("android.widget.EditText"));
		city.sendKeys("Ayodhya");
		Thread.sleep(5000);
		WebElement selectCityFromList = driver.findElement(By.xpath("//android.widget.TextView[@text='Ayodhya']"));
		selectCityFromList.click();
		Thread.sleep(5000);
 
		// checkIn
 
	}
 
	
	@Test(priority = 3)
	public  void checkInOut() throws Exception {

		WebElement checkInTimeIs = driver.findElement(By.id("com.makemytrip:id/tvCheckInDate"));
		String getCheckInTime = checkInTimeIs.getText().trim();
		System.out.println("Check In Time : " + getCheckInTime);
		WebElement checkOutTimeIs = driver.findElement(By.id("com.makemytrip:id/tvCheckOutDate"));
		String getCheckOutTime = checkOutTimeIs.getText().trim();
		System.out.println("Check out time is : " + getCheckOutTime);
	}
 
	
	@Test(priority = 4)
	public  void done() {
		
		try {
			WebElement eDone = driver.findElement(By.id("com.makemytrip:id/btnDone"));
			eDone.click();
			Thread.sleep(5000);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
 
	@Test(priority = 5)
	public  void searchHotels() {
		try {
			WebElement search = driver.findElement(By.id("com.makemytrip:id/search"));
			search.click();
			Thread.sleep(10000);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
 
	@Test(priority = 6)
	public  void applyStarRating() throws InterruptedException {
		
			driver.findElements(By.xpath("//android.widget.TextView[@text='Star Rating']")).get(0).click();
			Thread.sleep(5000);
			driver.findElements(By.id("com.makemytrip:id/filter_container")).get(1).click();
			Thread.sleep(5000);
			driver.findElements(By.id("com.makemytrip:id/tvHotelName")).get(0).click();
			Thread.sleep(10000);
		System.out.println("Successfull apply Star Rating");
		
	}
 
	
	@Test(priority = 7)
	public  void reviewSection() throws Exception {
		WebElement selectHotel = driver
				.findElement(By.xpath("//android.widget.TextView[@text='Park Inn By Radisson Ayodhya']"));
		System.out.println("Hotel Name: " + selectHotel.getText().trim());
		Thread.sleep(8000);
		driver.findElements(By.id("com.makemytrip:id/tvHotelName")).get(0).click();
		Thread.sleep(8000);
		WebElement ratingInfo = driver.findElement(By.id("com.makemytrip:id/rating_info_icon"));
		ratingInfo.click();
		Thread.sleep(10000);
		WebElement getReviewTitle = driver
				.findElement(By.xpath("//android.widget.TextView[@text='96% guests rated this property 4 and above']"));
		String reviewTitle = getReviewTitle.getText().trim();
		System.out.println("Review : " + reviewTitle);
	}
	
	

}
