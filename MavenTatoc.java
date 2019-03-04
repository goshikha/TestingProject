package com.qait.testing.Maven_Tatoc;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class MavenTatoc{
	
	WebDriver driver;
	public MavenTatoc() {
		
		String exepath = "/home/qainfotech/Downloads/chromedriver";
		System.setProperty("webdriver.chrome.driver",exepath);
		driver = new ChromeDriver();
		driver.get("http://10.0.1.86/tatoc/");
	}
	
	@Test
	public void basicCourse() {
		
		Assert.assertEquals(driver.findElement(By.linkText("Basic Course")).isDisplayed(), true);
        driver.findElement(By.linkText("Basic Course")).click();
        Assert.assertEquals("Grid Gate - Basic Course - T.A.T.O.C", driver.getTitle());		
		
	}
	
	@Test(dependsOnMethods = {"basicCourse"})
	public void greenBox() {
		
		Assert.assertEquals(driver.findElement(By.className("greenbox")).isDisplayed(), true);
        this.driver.findElement(By.className("greenbox")).click();
        Assert.assertEquals("Frame Dungeon - Basic Course - T.A.T.O.C", driver.getTitle());		
		
	}
	
	@Test(dependsOnMethods = {"greenBox"})
	public void frameDungeon() {
		
		driver.switchTo().frame(0);	
		Assert.assertEquals(driver.findElement(By.id("answer")).isDisplayed(), true);
		String box1Color=driver.findElement(By.id("answer")).getAttribute("class");
		
		Boolean condition=true;		
		while(condition) {
			Assert.assertEquals(driver.findElement(By.linkText("Repaint Box 2")).isDisplayed(), true);
	  		driver.findElement(By.linkText("Repaint Box 2")).click(); 
			driver.switchTo().frame("child");
			Assert.assertEquals(driver.findElement(By.id("answer")).isDisplayed(), true);
			String box2Color=driver.findElement(By.id("answer")).getAttribute("class");
			driver.switchTo().parentFrame();
			
			if(box1Color.equals(box2Color)) {
				Assert.assertEquals(driver.findElement(By.linkText("Proceed")).isDisplayed(), true);
				driver.findElement(By.linkText("Proceed")).click();
				condition=false;
			}}
	         driver.switchTo().defaultContent();			
	         Assert.assertEquals("Drag - Basic Course - T.A.T.O.C", driver.getTitle());
	}
	
	@Test(dependsOnMethods = {"frameDungeon"})
	public void dragDop() {
		
		Assert.assertEquals(driver.findElement(By.id("dropbox")).isDisplayed(), true);	
		WebElement drop = driver.findElement(By.id("dropbox"));
		Assert.assertEquals(driver.findElement(By.id("dragbox")).isDisplayed(), true);
        WebElement drag = driver.findElement(By.id("dragbox"));
        Actions act=new Actions(driver);
        act.dragAndDrop(drag, drop).build().perform();
        driver.findElement(By.linkText("Proceed")).click();
        Assert.assertEquals("Windows - Basic Course - T.A.T.O.C", driver.getTitle());		
		
	}
	
	@Test(dependsOnMethods = {"dragDop"})
	public void popUpWindows() {
		
		Assert.assertEquals(driver.findElement(By.linkText("Launch Popup Window")).isDisplayed(), true);
        driver.findElement(By.linkText("Launch Popup Window")).click();
        List windowsList=new ArrayList(driver.getWindowHandles());
        String windows1= ((String)windowsList.get(1));
        driver.switchTo().window(windows1);
        driver.findElement(By.id("name")).sendKeys("Barkha");
		Assert.assertEquals(driver.findElement(By.id("submit")).isDisplayed(), true);
        driver.findElement(By.id("submit")).click();
        String windows2=(String)(windowsList.get(0));
        driver.switchTo().window(windows2);
		Assert.assertEquals(driver.findElement(By.linkText("Proceed")).isDisplayed(), true);
        driver.findElement(By.linkText("Proceed")).click(); 
        Assert.assertEquals("Cookie Handling - Basic Course - T.A.T.O.C", driver.getTitle());	
	
	}
	
	@Test(dependsOnMethods = {"popUpWindows"})
	public void cookieHandling() {

		Assert.assertEquals(driver.findElement(By.linkText("Generate Token")).isDisplayed(), true);
		driver.findElement(By.linkText("Generate Token")).click(); 
		Assert.assertEquals(driver.findElement(By.id("token")).isDisplayed(), true);	
		String Token = driver.findElement(By.id("token")).getText();
        String substring1=Token.substring(7);
        Cookie name = new Cookie("Token", substring1);
  		driver.manage().addCookie(name);
		Assert.assertEquals(driver.findElement(By.linkText("Proceed")).isDisplayed(), true);
  		driver.findElement(By.linkText("Proceed")).click();
	
	}
	}