package com.SauceDemo.UtilClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.SauceDemo.TestClass.BaseClass;

public class BasicAdditionalMethods extends BaseClass implements ITestListener
{
	WebDriver driver;
	public void scroll()
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("scrollBy(0,400)");
		System.out.println("Scrolled");
	}
	
	public void ScreenShot(String filename) throws IOException
	{
		TakesScreenshot ss= (TakesScreenshot)driver;
		File source=ss.getScreenshotAs(OutputType.FILE);
		Date d=new Date();
		SimpleDateFormat Datef=new SimpleDateFormat("DDMMYYYY_HHMMSS");
		String timestamp=Datef.format(d);
		File destination=new File("C:\\Users\\TheOne\\Desktop\\Velocity\\Selenium\\Screenshots\\Maven"+filename+timestamp+".jpg");
		FileHandler.copy(source, destination);
	}
	public void onTestStart(ITestResult Result)
	{
		System.out.println("Test Started Listener");
	}
	public void onTestFailure(ITestResult Result)
	{
		BasicAdditionalMethods basicAdditionalMethods = new BasicAdditionalMethods();
		try {
			basicAdditionalMethods.ScreenShot("Failed"+"timestamp");
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	public void onTestSkipped()
	{
		BasicAdditionalMethods basicAdditionalMethods = new BasicAdditionalMethods();
		try {
			basicAdditionalMethods.ScreenShot("Failed"+"timestamp");
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	public void onTestSuccess() throws IOException
	{
		BasicAdditionalMethods basicAdditionalMethods = new BasicAdditionalMethods();
		basicAdditionalMethods.ExcelSheet();
		System.out.println("Test is success Listeners");
	}

	public void ExcelSheet() throws IOException
	{
		String path="C:\\Users\\TheOne\\Desktop\\Velocity\\Selenium\\Excel Workbook\\Selenium_Practice.xlsx";
		FileInputStream file=new FileInputStream(path);
		XSSFWorkbook workbook=new XSSFWorkbook(path);
		XSSFSheet sheet=workbook.getSheet("velocity");
		XSSFRow row1=sheet.getRow(0);
		XSSFCell cell1=row1.getCell(0);
		String username=cell1.getStringCellValue();
		XSSFRow row11=sheet.getRow(1);
		XSSFCell cell2=row11.getCell(1);
		String Password=cell2.getStringCellValue();
		XSSFRow row3=sheet.getRow(0);
		XSSFCell cell3=row3.getCell(0);
		String fName=cell3.getStringCellValue();
				
		
	}
}

