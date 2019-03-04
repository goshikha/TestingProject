package com.qait.AdvanceCourse.AdvanceCourseMaven;

import org.testng.annotations.Test;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;




public class WelcomePage{
	
	WebDriver driver;
	
	public WelcomePage(WebDriver driver) {
		this.driver=driver;
	}		
	public void launchApplication(String string) {
	driver.get(string);
	System.out.println("User launched URL: "+string);
			
  }
    public void verifyHomePageLaunched() {
		
		Assert.assertEquals(driver.findElement(By.linkText("Advanced Course")).isDisplayed(), true);
        driver.findElement(By.linkText("Advanced Course")).click();
		System.out.println("User is on homepage");
	}
}
