package automation;



	import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.Cookie;

	
	public class TATOC {
	    public static void main(String[] args) {
	        String exepath="/home/qainfotech/Downloads/chromedriver";
	        System.setProperty("webdriver.chrome.driver",exepath);
	        WebDriver driver = new ChromeDriver();
            driver.get("http://10.0.1.86/tatoc");
            WebElement basic = driver.findElement(By.linkText("Basic Course"));
            basic.click();
            WebElement box = driver.findElement(By.className("greenbox"));
            box.click();
            WebElement result=null;
	        //driver.get("http://www.google.com");
            WebElement fr = driver.findElement(By.id("main"));
             driver.switchTo().frame(fr);
	         String color1=driver.findElement(By.id("answer")).getAttribute("class");
	         System.out.println(color1);
	         WebElement fr1 = driver.findElement(By.id("child"));
             driver.switchTo().frame(fr1);
	         String color2=driver.findElement(By.id("answer")).getAttribute("class");
	         driver.switchTo().defaultContent();
	         while(color1.equals(color2)!=true) {
	        	 driver.switchTo().frame(fr);
	        	 driver.findElement(By.linkText("Repaint Box 2")).click(); 
	        	  
	        	 driver.switchTo().frame(fr1);
	        	 color2=driver.findElement(By.id("answer")).getAttribute("class");	
	        	 driver.switchTo().defaultContent();
	         }
	         driver.switchTo().defaultContent();
	         driver.switchTo().frame(fr);
	         driver.findElement(By.linkText("Proceed")).click(); 
	         WebElement drop = driver.findElement(By.id("dropbox"));
	         WebElement drag = driver.findElement(By.id("dragbox"));
	         Actions act=new Actions(driver);
	         act.dragAndDrop(drag, drop).build().perform();
	         driver.findElement(By.linkText("Proceed")).click(); 
	         
	          driver.findElement(By.partialLinkText("Launch")).click();
	          ArrayList windowsList=new ArrayList(driver.getWindowHandles());
	          String windows1= ((String)windowsList.get(1));
	          //System.out.println(windows1);
	          driver.switchTo().window(windows1);
	          driver.findElement(By.id("name")).sendKeys("Shikha");
	          driver.findElement(By.id("submit")).click();
	          String windows2=(String)(windowsList.get(0));
	          driver.switchTo().window(windows2);
	          driver.findElement(By.linkText("Proceed")).click(); 
	          
	          driver.findElement(By.linkText("Generate Token")).click(); 
	          String Token = driver.findElement(By.id("token")).getText();
	          System.out.println(Token);
	          String substring1=Token.substring(7);
	          Cookie name = new Cookie("Token", substring1);
	  		  driver.manage().addCookie(name);
	  		  
	  		driver.findElement(By.linkText("Proceed")).click(); 
	          
	        //driver.quit();
	    }
	}
	

