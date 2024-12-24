package Twarita.Selenium4.OtherNetworkConcepts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LogEntry;

public class JSLog {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.cssSelector("a[routerlink='/products']")).click();
		driver.findElement(By.cssSelector("button[class='btn btn-primary']")).click();
		driver.findElement(By.xpath("//button[text()='Check Availability']")).click();
		

		LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
		List<LogEntry> logs =  logEntries.getAll();
		for(LogEntry l : logs) {
			System.out.println(l.getMessage());
			System.out.println(" with timestamp "+l.getTimestamp());
			System.out.println(" with level "+l.getLevel());
			System.out.println(" output of get String "+l.toString());
			
		};
		
		driver.quit();
		
	}

}
