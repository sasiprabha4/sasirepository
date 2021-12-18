package com.demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Day1 {

	public static void main(String[] args) throws IOException {
		File loc=new File("C:\\Users\\apras\\eclipse-workspace\\Maven\\Input\\Data.xlsx");
		FileInputStream fo=new FileInputStream(loc);
		Workbook w=new XSSFWorkbook(fo);
		Sheet s=w.getSheet("Sheet1");
		int physicalNumberOfRows=s.getPhysicalNumberOfRows();
		System.out.println(physicalNumberOfRows);
		

	}

}
