package day12;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
public class HandlingAlert12
{
	 public static void main(String[] args) 
	 {
	  
	  FirefoxDriver driver = new FirefoxDriver();
	  driver.get("http://www.tsrtconline.in/oprs-web/");
	  
	  driver.manage().window().maximize();
	  
	  driver.findElement(By.id("searchBtn")).click();
	  
	  Alert alt= driver.switchTo().alert();
	  
	  System.out.println(alt.getText());
	  
	  Sleeper.sleepTightInSeconds(10);
	  
	  alt.accept();
	  
	  driver.findElement(By.id("fromPlaceName")).sendKeys("HYDERABAD");
	  
	  //alt.dismiss();
	  
	  //alt.sendKeys("Hello");

	  driver.close();
	 }

}
