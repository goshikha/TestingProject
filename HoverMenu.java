package com.qait.AdvanceCourse.AdvanceCourseMaven;

import org.apache.bcel.generic.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import junit.framework.Assert;

public class HoverMenu {

	WebDriver driver;
	Select select;
	
	public HoverMenu(WebDriver driver) {
        this.driver=driver;		

	}

	public void verify(String url) {
		driver.get(url);
		Actions action=new Actions(driver);
		WebElement hover=driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/span[1]"));
		action.moveToElement(hover).moveToElement(driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/span[5]"))).click().build().perform();
		//Assert.assertEquals(url,driver.getCurrentUrl());
		
	}

	

}
