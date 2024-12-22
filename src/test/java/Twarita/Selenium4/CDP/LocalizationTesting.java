package Twarita.Selenium4.CDP;

import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.emulation.Emulation;

public class LocalizationTesting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeDriver driver = new ChromeDriver();
		DevTools devTool = driver.getDevTools();
		devTool.createSession();
		
		devTool.send(Emulation.setGeolocationOverride(Optional.of(18), Optional.of(98), Optional.of(1)));
		
		driver.get("https://www.google.com/");
		driver.findElement(By.name("q")).sendKeys("nearest airport", Keys.ENTER);
		System.out.println(driver.findElement(By.cssSelector(".rllt__details")).getText());
		driver.quit();
		
		

	}

}
