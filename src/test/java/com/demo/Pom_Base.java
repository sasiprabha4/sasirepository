package com.demo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utils.Base_Class;

public class Pom_Base extends Base_Class{
	public Pom_Base() {
		
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id = "email")
	private WebElement user;
	
	@FindBy(id="pass")
	private WebElement pass;
	
	@FindBy(name="login")
	private WebElement login;
	
	public WebElement getUser() {
		return user;
	}
	
	public WebElement getPass() {
		return pass;
	}
	
	public WebElement getLogin() {
		return login;
	}

}
