package week4.assignments;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
	    driver.findElement(By.id("password")).sendKeys("crmsfa");
	    driver.findElement(By.className("decorativeSubmit")).click();
	    driver.findElement(By.linkText("CRM/SFA")).click();
	    driver.findElement(By.linkText("Contacts")).click();
	    driver.findElement(By.xpath("//a[text() = 'Merge Contacts']")).click();
	    driver.findElement(By.xpath("//a/img[@src = '/images/fieldlookup.gif']")).click();
	    String currurl = driver.getCurrentUrl();
	    System.out.println("currurl"+currurl);
	    Set<String> windowHandles = driver.getWindowHandles();
	    List<String> listWindowHandles = new ArrayList<String>(windowHandles);
	    String firdtWindow = listWindowHandles.get(0);
	    System.out.println("first window:"+firdtWindow);
	    String newWindow = listWindowHandles.get(1);
	    System.out.println("newWindow:"+newWindow);
	    driver.switchTo().window(newWindow);
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    String newtitle = driver.getTitle();
	    System.out.println("New title: "+newtitle);
	    WebElement webelement = driver.findElement(By.xpath("//table"));
	    List<WebElement> cols = webelement.findElements(By.xpath("//table[@class ='x-grid3-row-table']/tbody/tr/td"));
	    //System.out.println("column: "+cols.size());
	    
	    for (int i = 0;i<1;i++)
	    {
	    String colval = cols.get(i).getText().toString();
		   //System.out.println("colval: "+colval);	
		   driver.findElement(By.linkText(colval)).click();
	    }	 	   
	    		String oldWindow = listWindowHandles.get(0);
	    		String contactWindow = listWindowHandles.get(1);	
	    		driver.switchTo().window(oldWindow);
	            //String title = driver.getTitle();
	            //System.out.println("title: "+title);
	          driver.getWindowHandle();
	          System.out.println("---"+driver.getWindowHandle());
	            driver.findElement(By.id("ComboBox_partyIdTo")).sendKeys(Keys.TAB,Keys.ENTER);
	            
	            //---------------------------------------
	            Set<String> windowHandles1 = driver.getWindowHandles();
	    	    List<String> listWindowHandles1 = new ArrayList<String>(windowHandles1);
	    	    String firdtWindow1 = listWindowHandles1.get(1); 
	    	    String homeWindow = listWindowHandles1.get(0); 
	    	    driver.switchTo().window(firdtWindow1);
	            driver.manage().window().maximize();
	            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	            WebElement webelement1 = driver.findElement(By.xpath("//table"));
	    	    //List<WebElement> rows11 = webelement1.findElements(By.tagName("//a"));	    	    
	    	    List<WebElement> cols1 = webelement1.findElements(By.xpath("//td[contains(@class,'x-grid3-cell-first')]"));

	    	    System.out.println("to_column: "+cols1.size());	 
	    	    for (int i=1;i<2;i++)
	    	    {	    	    
	    	    	String colval1 = cols1.get(i).getText().toString();	    	       	    	       
	    		   System.out.println("colval1: "+i+"---"+colval1);	
	    		   System.out.println("******");
	    		   driver.findElement(By.linkText(colval1)).click();	 
	    	       
	    	    }	    
	    		driver.switchTo().window(homeWindow);
	            String title1 = driver.getTitle();
	            System.out.println("title1: "+title1);
	            driver.findElement(By.linkText("Merge")).click();
	            Alert alrt = driver.switchTo().alert();
	            alrt.accept();
	            
    	        
	        }
	    
	}


