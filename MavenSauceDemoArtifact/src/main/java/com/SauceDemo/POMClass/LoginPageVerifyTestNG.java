package com.SauceDemo.POMClass;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageVerifyTestNG 
{
private WebDriver driver;
	
	@FindBy(xpath="//input[@id='user-name']")
	
	private WebElement UserName;
	
	@FindBy(xpath="//input[@id='password']")
	
	private WebElement Password;
	
	@FindBy(xpath="//input[@type='submit']")
	
	private WebElement SubmitButton;
	
	@FindBy(xpath="(//div[@class='inventory_item_name'])[2]")
	
	private WebElement element1;
	
	@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-bike-light']")
	
	private WebElement addCart;
	
	@FindBy(xpath="//button[@id='react-burger-menu-btn']")
	
	private WebElement menu;
	
    @FindBy(xpath="//a[@id='logout_sidebar_link']")
    
    private WebElement logOut;
    

	public LoginPageVerifyTestNG(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	public void SendUserName()
	{
		UserName.sendKeys("standard_user");
		System.out.println("Username Entered");
	}
	public void SendPassword() throws InterruptedException
	{
		Password.sendKeys("secret_sauce");
		System.out.println("Password Entered");
		Thread.sleep(5000);
		
	}
	public void SubmitButton() throws InterruptedException
	{
		SubmitButton.click();
		System.out.println("Entered");
		Thread.sleep(5000);
		
	}
	
	public void SelectElement()
	{
		element1.click();
		System.out.println("Element Entered");
	}
	public void addCart()
	{
		addCart.click();
		System.out.println("Cart Added");
	}
	public void menu() throws InterruptedException
	{
		menu.click();
		System.out.println("Burger");
		Thread.sleep(3000);
	}
	public void LogOut()
	{
		logOut.click();
		System.out.println("Logged Out");
	}
	
}
