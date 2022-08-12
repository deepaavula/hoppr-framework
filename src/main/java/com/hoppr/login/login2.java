package com.hoppr.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class login2 {



	public static void main(String[] args) {
		//System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://122.169.108.53:83/login\n"
				+ "");
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("deepa.avula@flexydial.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("258347469963");
		driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();
		
		
		}
}



