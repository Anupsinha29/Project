package org.MiWay.Practice;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class brokenlinks {
	@Test
	public void brokenlinks() throws IOException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		List<WebElement> linklist =driver.findElements(By.xpath("//a"));
		List<String> brokenLinks= new ArrayList<>();
		
		for(WebElement link:linklist) {
			String url = link.getAttribute("href");
			URL u = new URL(url);
			URLConnection urlConnection = u.openConnection();
			HttpURLConnection httpUrlConnection = (HttpURLConnection)urlConnection;
			int statusCode =httpUrlConnection.getResponseCode();
			String responseMessage =httpUrlConnection.getResponseMessage();
			if(statusCode!=200) {
				brokenLinks.add(url +"----------"+statusCode +"----"+responseMessage);
			}
		}
		System.out.println(brokenLinks);
		System.out.println("TestCase Executed");
			}
		
	}


