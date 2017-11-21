package com.DataDrivenTesting;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
public class NewToursUserRegistrationFromExcelHomework {
	 FirefoxDriver driver;
	 
	 @BeforeTest
	 public void setUp()
	 {
	  driver = new FirefoxDriver();
	  driver.get("http://newtours.demoaut.com");
	  
	  driver.manage().window().maximize();
	 }
	 @Test(priority=1)
	 public void Register()
	 {
	  driver.findElement(By.linkText("REGISTER")).click();
	 }
	 @Test(priority=2)
	 public void UserCreation() throws IOException
	 {
		 FileInputStream file = new FileInputStream("C:\\Users\\Avalon\\Desktop\\AnuTestData.xlsx");
		  XSSFWorkbook wb = new XSSFWorkbook(file);
		  XSSFSheet ws = wb.getSheet("Sheet2");
		  int RowCount=ws.getLastRowNum();
		  
		  for(int i=0;i<=RowCount;i++) // Rows
		  {
		   Row r = ws.getRow(i);
		   
		   // getLastCellNum() -- will identify the Cell with test data
		   int CellCount= r.getLastCellNum();
		   
		   for(int j=0;j<CellCount;j++) // Cell
		   {
		    Cell c=r.getCell(j);
		    String TestData= c.getStringCellValue();
		    System.out.print(TestData+"  ");
		// driver.findElementByName("firstName").sendKeys("Anu");
		// driver.findElement(By.name("lastName")).sendKeys("Meenu");
	//	  driver.findElement(By.name("phone")).sendKeys("7777777");
		//  driver.findElement(By.id("userName")).sendKeys("anumeenu@gmail.com");
		 // driver.findElement(By.name("address1")).sendKeys("HiTechCity");
	//	  driver.findElement(By.name("city")).sendKeys("Hyderbad");
		//  driver.findElement(By.name("state")).sendKeys("Telangana");
		//  driver.findElement(By.name("postalCode")).sendKeys("50001");
		//  driver.findElement(By.name("country")).sendKeys("INDIA");
		  //driver.findElement(By.id("email")).sendKeys("MeenuAnu");
		  //driver.findElement(By.name("password")).sendKeys("abc123");
		  //driver.findElement(By.name("confirmPassword")).sendKeys("abc123");
		  
		  Sleeper.sleepTightInSeconds(10);
		  
		  driver.findElement(By.name("register")).click();
		  
		  String ExpectedUsername = "MeenuAnu";
		  
		  String ActualText= driver.findElement(By.xpath("html/body/div[1]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/p[3]/a/font/b")).getText();
		  
		  System.out.println(ExpectedUsername);
		  System.out.println(ActualText);
		  
		  if(ActualText.contains(ExpectedUsername))
		  {
		   System.out.println("User Registered Successfuly -- PASS");
		  }
		  else
		  {
		   System.out.println("User Not Registered Successfuly - FAIL");
		  }
		   
		   }
		  }}
		 
		 @AfterTest
		 public void tearDown()
		 {
		  driver.close();
		 }
		 
	 }

