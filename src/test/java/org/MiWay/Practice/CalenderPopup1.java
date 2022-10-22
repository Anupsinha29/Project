package org.MiWay.Practice;

import java.time.Duration;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalenderPopup1 
{
	public static void main(String[] args) {
		 
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
	String requireddate ="29";
	String requiredmonth ="March";
	String requiredyear ="2025";
	int RequiredMonthInNum= DateTimeFormatter.ofPattern("MMMM").withLocale(Locale.ENGLISH).parse(requiredmonth).get(ChronoField.MONTH_OF_YEAR);
	int RequiredYearInNum =Integer.parseInt(requiredyear);
	
	
	driver.get("https://testleaf.herokuapp.com/pages/Calendar.html");
    driver.findElement(By.id("datepicker")).click();
    String actualmonthyear= driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText();
   //System.out.println(data);
    
    String[] str = actualmonthyear.split(" ");
    String actualmonth = str[0];
    String actualyear =str[1];
    
   int actualmonthInNum = DateTimeFormatter.ofPattern("MMMM").withLocale(Locale.ENGLISH).parse(actualmonth).get(ChronoField.MONTH_OF_YEAR);
   int actualyearInNum = Integer.parseInt(actualyear);
   
   while(RequiredMonthInNum>actualmonthInNum|| RequiredYearInNum >actualyearInNum) {
	   driver.findElement(By.xpath("//span[text()='Next']")).click();
	   actualmonthyear = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText();
	   str = actualmonthyear.split(" ");
	   actualmonth = str[0];
	   actualyear = str[1];
	   actualmonthInNum = DateTimeFormatter.ofPattern("MMMM").withLocale(Locale.ENGLISH).parse(actualmonth).get(ChronoField.MONTH_OF_YEAR);
	   actualyearInNum = Integer.parseInt(actualyear);
   }
	   
   }
    
    
    
   
   
}
