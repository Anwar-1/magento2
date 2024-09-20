package magentoProject2;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class myTest {

	WebDriver driver = new ChromeDriver();
	Random rand = new Random();
	@BeforeTest
	public void my_setup() {
		driver.get("https://magento.softwaretestingboard.com/");
		driver.manage().window().maximize();
	}
	

	
	@Test(priority = 1)
	public void log_in() {
		WebElement link = 	driver.findElement(By.linkText("Sign In"));
		link.click();
		
		 WebElement email = driver.findElement(By.id("email"));
		 email.sendKeys("anwaralthwaib71@gmail.com");
		 
		   WebElement password = driver.findElement(By.id("pass"));
		     password.sendKeys("sosos1234as#");
		 
		     WebElement button = driver.findElement(By.id("send2"));
		     button.click();
	}
	
	@Test(priority = 2)
	public void add_to_cart() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement gear = wait.until(ExpectedConditions.elementToBeClickable(By.id("ui-id-6")));
		gear.click();

	    WebElement bags = driver.findElement(By.cssSelector("div[class='block filter'] li:nth-child(1) a:nth-child(1)"));
	   bags.click();
	   
	   
	   List<WebElement> items = driver.findElements(By.cssSelector(".item.product.product-item a.product-item-link"));
	   
	   for(int i =0;i<items.size();i = i+2) {
		   String itemLink = items.get(i).getAttribute("href");
		   
		   driver.navigate().to(itemLink);
	        
	        Thread.sleep(2000);  
	        
		WebElement   button = driver.findElement(By.id("product-addtocart-button"));
		button.click();
		
		 driver.navigate().back();
	        Thread.sleep(2000);

	      
	        items = driver.findElements(By.cssSelector(".item.product.product-item a.product-item-link"));
	   }
	}
	
	@Test(priority = 3)
	public void totalnumber() {
		 List<WebElement> items = driver.findElements(By.cssSelector(".item.product.product-item a.product-item-link"));
		double excepted = 6;
		
		double actual = items.size();
		double actualNumber = actual/2;
		
		 Assert.assertEquals(actualNumber, excepted);
		
		
		
	}
}
