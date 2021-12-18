package com.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base_Class {
	public static WebDriver driver;
	
	/*
	 * To initiate the webdriver
	 */
	public static void getDriver() {
		 WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
	}
	
	public static void getUrl(String url) {
		driver.get(url);
	}
	
	public static void getTitle() {
		String title = driver.getTitle();
		System.out.println(title);
	}
	
	public static void getCurrentUrl() {
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
	}
	
	public static void closeBrowser() {
		driver.close();
	}
	
	public static void quitBrowser() {
		driver.quit();
	}
	
	public static void InsertType(WebElement ele,String value) {
		ele.sendKeys(value);
	}
	
	public static void Click(WebElement ele) {
		ele.click();
	}
	
	public static String getData(int row,int cell) throws IOException{
		//File Loc
		File loc=new File("C:\\Users\\apras\\eclipse-workspace\\Maven\\Input\\Data.xlsx");
		//FileInputSteam
		FileInputStream fo=new FileInputStream(loc);
		//Workbook
		Workbook w=new XSSFWorkbook(fo);
		//Sheet
		Sheet s=w.getSheet("Sheet1");
		//Row
		Row r=s.getRow(row);
		Cell c= r.getCell(cell);
		String value=null;
		int cellType=c.getCellType();
		System.out.println(cellType);
		//celltype-1-->String,0-Number or Date
		
		if(cellType == 1) {
			value=c.getStringCellValue();
			System.out.println(value);
		}else if(cellType==0) {
			if(DateUtil.isCellDateFormatted(c)) {
				Date dateCellValue = c.getDateCellValue();
				SimpleDateFormat sim = new SimpleDateFormat("dd-MM-yyyy");
				value=sim.format(dateCellValue);
				System.out.println(value);
			}else {
				double numericCellValue = c.getNumericCellValue();
				//Typecasting
				long l = (long) numericCellValue;
				value = String.valueOf(l);
				System.out.println(value);
			}
		}
		return value;
	}
	

}
