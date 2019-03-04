package com.qait.AdvanceCourse.AdvanceCourseMaven;

import org.testng.annotations.Test;



import org.testng.annotations.BeforeClass;

import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class NewTest {
  
	WebDriver driver;
	WelcomePage welcomepage;
	HoverMenu hovermenu;
	QueryGate querygate;
	
	@BeforeClass
	public void initial() {
		String exepath="/home/qainfotech/Downloads/chromedriver";
        System.setProperty("webdriver.chrome.driver",exepath);
		driver = new ChromeDriver();
		welcomepage= new WelcomePage(driver);
	}
	
	@Test(priority=1)
	public void welcomepage(){
		//driver=new ChromeDriver();
		welcomepage.launchApplication("http://10.0.1.86/tatoc");
		welcomepage.verifyHomePageLaunched();
	}
	
	@Test(priority=2)
	public void HoverMenu() {
		String url;
		url="http://10.0.1.86/tatoc/advanced/hover/menu";
		hovermenu=new HoverMenu(driver);
		hovermenu.verify(url);
	}
	
	@Test(priority=3)
	public void QueryGate()throws ClassNotFoundException, SQLException {
		
		querygate=new QueryGate(driver);
		querygate.verify();
	}
	
}
