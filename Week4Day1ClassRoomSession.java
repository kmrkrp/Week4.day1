package week4.day1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Week4Day1ClassRoomSession {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
	    // Maximize the window
	    driver.manage().window().maximize();
	    driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
	    driver.findElement(By.id("password")).sendKeys("crmsfa");
	    driver.findElement(By.className("decorativeSubmit")).click();	   
	    driver.findElement(By.linkText("CRM/SFA")).click();	 
	    driver.findElement(By.xpath("//a[contains(text(),'Leads')]")).click();	   
	    driver.findElement(By.xpath("//a[contains(text(),'Create Lead')]")).click();	    
	    System.out.println("clicking Create Lead");
	    driver.findElement(By.id("createLeadForm_dataSourceId")).sendKeys("Direct Mail");
	    WebElement market = driver.findElement(By.id("createLeadForm_marketingCampaignId"));
	    Select dropDown1 = new Select(market);
	    dropDown1.selectByValue("9002");
	    WebElement currency = driver.findElement(By.id("createLeadForm_currencyUomId"));
	    Select dropDown2 = new Select(currency);
	    dropDown2.selectByVisibleText("AWG - Aruban Guilder");
	    WebElement industry = driver.findElement(By.id("createLeadForm_industryEnumId"));
	    Select dropDown3 = new Select(industry);
	    List<WebElement> ind = dropDown3.getOptions();
	    for (WebElement indget:ind)
	    {
	    	System.out.println("List of industries in dropdown: "+indget.getText());
	    }
	    WebElement ownerShip = driver.findElement(By.id("createLeadForm_ownershipEnumId"));
	    Select dropDown4 = new Select(ownerShip);
	    List<WebElement> owner = dropDown4.getOptions();
	    int len = owner.size();
	    dropDown4.selectByIndex(len-1);
	    
	    
	    
		
	}

}
