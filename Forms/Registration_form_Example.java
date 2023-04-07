package com.demoqaForms.Forms;

import org.junit.AfterClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Registration_form_Example {

	WebDriver driver;
	
	@BeforeClass
	public void initializeMethod() {
	driver = new FirefoxDriver();
	driver.manage().window().maximize();
	driver.get("https://demoqa.com/");
	}
	
	@Test(groups="smoke", priority=1)
	public void clickForm() {
		try {
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div/div/div/div/div/div[2]/div/div[2]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='element-group'][2]/div")).click();
		Thread.sleep(1000);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	
	@Test(groups="regression",priority=2)
	public void registrationForm() {
		try {
			//firstName
			driver.findElement(By.id("firstName")).sendKeys("sachin");
			Thread.sleep(2000);
			
			//lastName
			driver.findElement(By.id("lastName")).sendKeys("mahir");
			Thread.sleep(2000);
			
			//emailAddress
			driver.findElement(By.id("userEmail")).sendKeys("sachin@gmail.com");
			Thread.sleep(2000);
			
			//gender
			driver.findElement(By.xpath("//label[@class='custom-control-label']")).click();
			Thread.sleep(2000);
			
			//mobileNumber
			driver.findElement(By.id("userNumber")).sendKeys("8764537282");
			Thread.sleep(2000);
			
			//dateOfBirth
			driver.findElement(By.id("dateOfBirthInput")).click();
			Thread.sleep(2000);
			WebElement monthDropDown = driver.findElement(By.xpath("//select[@class='react-datepicker__month-select']"));
			Select month = new Select(monthDropDown);
			month.selectByIndex(3);
			Thread.sleep(1000);
			WebElement yearDropDown = driver.findElement(By.xpath("//select[@class='react-datepicker__year-select']"));
			Select year = new Select(yearDropDown);
			year.selectByValue("1985");
			Thread.sleep(1000);
			driver.findElement(By.xpath("//div[@class='react-datepicker__week']/div[3]")).click();
			Thread.sleep(1000);
			
			//subject
			WebElement subject = driver.findElement(By.id("subjectsContainer"));
			Actions a = new Actions(driver);
			a.click().perform();
			a.pause(3);
			a.sendKeys(subject, "math").perform();
			a.pause(3);
			a.sendKeys(Keys.ENTER).perform();
			Thread.sleep(1000);
			
			//hobby
			driver.findElement(By.xpath("//label[@for='hobbies-checkbox-2']")).click();
			Thread.sleep(2000);
			
			//scrollDown
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("window.scrollBy(0,250)", "");
			
			//image
			WebElement image = driver.findElement(By.xpath("//input[@id='uploadPicture']"));
			image.sendKeys("C:\\Users\\sasir\\OneDrive\\Desktop\\Sasi\\image\\nature1.jpg");
			Thread.sleep(2000);
			
			//currentAddress
			WebElement curentaddress = driver.findElement(By.id("currentAddress"));
			curentaddress.sendKeys("156mainstreet");
			Thread.sleep(2000);
			
			//scrollDown
			JavascriptExecutor js1 = (JavascriptExecutor)driver;
			js1.executeScript("window.scrollBy(0,250)", "");
			
			//State
			WebElement stateDropDown = driver.findElement(By.xpath("//div[@class=' css-yk16xz-control']"));
			Actions action1 = new Actions(driver);
			action1.moveToElement(stateDropDown).perform();
			action1.click().perform();
			action1.sendKeys(Keys.ARROW_DOWN).perform();
			action1.sendKeys(Keys.ENTER).perform();
			Thread.sleep(2000);
			
			//city
			WebElement cityDropDown = driver.findElement(By.xpath("//div[@id='city']"));
	        Actions action = new Actions(driver);
			action.moveToElement(cityDropDown).perform();
			action.click().perform();
			action.sendKeys(Keys.ARROW_DOWN).perform();
			action.sendKeys(Keys.ENTER).perform();
			Thread.sleep(2000);
			
			//scrollUp
			JavascriptExecutor js2 = (JavascriptExecutor)driver;
			js2.executeScript("window.scrollBy(0,-250)", "");
			
			Thread.sleep(8000);
			
			//submit
			WebElement submit = driver.findElement(By.xpath("//button[@id='submit']"));
			JavascriptExecutor ex = (JavascriptExecutor)driver;
			ex.executeScript("arguments[0].click();", submit);
			
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
	}
		


	@AfterClass
	public void closingAplication() {
		driver.quit();
	}
}


