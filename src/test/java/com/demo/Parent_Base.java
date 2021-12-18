package com.demo;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.utils.Base_Class;

public class Parent_Base extends Base_Class{
	public static void main(String[] args) throws IOException{
		
		getDriver();
		getUrl("https://www.facebook.com/");
		getTitle();
		getCurrentUrl();
		
		
		WebElement txtusername = driver.findElement(By.id("email"));
		InsertType(txtusername,getData(0,1));
		
		WebElement txtpass = driver.findElement(By.id("pass"));
		InsertType(txtpass,getData(0,2));
		
		WebElement btnlogin = driver.findElement(By.name("login"));
	    Click(btnlogin);
		
		closeBrowser();
	}

}
