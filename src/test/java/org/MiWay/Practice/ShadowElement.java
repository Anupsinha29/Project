package org.MiWay.Practice;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ShadowElement {
	@Test
	public void shadowElement() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("chrome://downloads/");
		JavascriptExecutor js =(JavascriptExecutor) driver;
		WebElement ele = (WebElement) js.executeScript("return document.querySelector(\"body > downloads-manager\").shadowRoot.querySelector(\"#toolbar\").shadowRoot.querySelector(\"#toolbar\").shadowRoot.querySelector(\"#search\").shadowRoot.querySelector(\"#searchInput\")");
		ele.click();
		
		
	}

}
