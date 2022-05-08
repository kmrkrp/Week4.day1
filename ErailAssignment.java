package week4.day1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ErailAssignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://erail.in/");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("txtStationFrom")).clear();	
		driver.findElement(By.id("txtStationFrom")).sendKeys("MDU",Keys.TAB);
		driver.findElement(By.id("txtStationTo")).clear();
		driver.findElement(By.id("txtStationTo")).sendKeys("TP",Keys.TAB);		
		driver.findElement(By.xpath("//label[@for = 'chkSelectDateOnly']")).click();
		WebElement webelement = driver.findElement(By.xpath("//div[@id = 'divTrainsListHeader']/table"));
		List<WebElement> trainRow = webelement.findElements(By.tagName("//tr"));
		System.out.println("Table Row Count:"+trainRow.size());
		List<WebElement> trainCol = webelement.findElements(By.tagName("//td"));
		System.out.println("Table Column Count:"+trainCol.size());
		
		

	}

}
