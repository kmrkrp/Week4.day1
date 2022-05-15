package week4.assignments;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonAssignment {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		//search for specific mobile
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("oneplus 9 pro",Keys.ENTER);
		//Fetching price of all the products available
		List<WebElement> lis = driver.findElements(By.xpath("//span[@class = 'a-price-whole']"));
		String firstProductPrice = lis.get(0).getText().toString();
		//Integer result = Integer.valueOf(firstProductPrice);
		//int prdprice = Integer.parseInt(firstProductPrice);
		//System.out.println("INT prdprice: "+result);
		//System.out.println("The price of the first product: "+"Rs."+firstProductPrice);
				
		 String rating = driver.findElement(By.xpath("//span[@class = 'a-size-base s-underline-text']")).getText().toString();
		 System.out.println("Number of customer ratings for the first displayed product: "+rating);
		 
		 driver.findElement(By.xpath("//span[@class = 'a-size-medium a-color-base a-text-normal']")).click();
		 Set<String> windowHandle = driver.getWindowHandles();
		 List<String> windowHandleList = new ArrayList<String>(windowHandle);
		 String firdtWindow1 = windowHandleList.get(1); 
		 driver.switchTo().window(firdtWindow1);
		 File img = driver.findElement(By.xpath("//img[@id = 'landingImage']")).getScreenshotAs(OutputType.FILE);
		 File targetImage = new File("./Snaps/Image001");
		 try {
			FileUtils.copyFile(img, targetImage);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		driver.findElement(By.id("add-to-cart-button")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
		String firstVal = firstProductPrice.replaceAll("[^0-9]","");
		System.out.println("The price of the first product: "+firstVal);					
		String cartvalue = driver.findElement(By.xpath("//span//b[contains(text(),'Cart subtotal')]//following::span//span")).getText();
		System.out.println("The Final price of the first product: "+cartvalue);
		
		String finalVal = cartvalue.replaceAll("[^0-9]","");
		System.out.println("finalVal  "+finalVal);
		String remlat2digit  = finalVal.substring(0, finalVal.length()-2);
		System.out.println("finalVal  "+remlat2digit);
		if(firstVal.equals(remlat2digit))
			System.out.println("The Price displayed in Home Page & Add to Cart page is matching");

	}
}
