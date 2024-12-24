 package Twarita.Selenium4.CDP;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.emulation.Emulation;
import org.openqa.selenium.edge.EdgeDriver;

public class setScreenResolution {

    public static void main(String[] args) {
    	EdgeDriver driverE = new EdgeDriver();
    	DevTools devToolsE = driverE.getDevTools();
    	devToolsE.createSession();
    	devToolsE.send(Emulation.setDeviceMetricsOverride(600, 1000, 100, true, Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty()));
    	driverE.get("https://rahulshettyacademy.com/angularAppdemo/");
    	System.out.println(driverE.findElement(By.className("navbar-toggler-icon")).isDisplayed());
    	
    	
    	driverE.quit();
    	
    	
    	ChromeDriver driverC = new ChromeDriver();
    	DevTools devToolsC = driverC.getDevTools();
    	devToolsC.createSession();
    	Map<String, Object> emulatorDetailsHashMap = new HashMap<String, Object>();
    	emulatorDetailsHashMap.put("width", 600);
    	emulatorDetailsHashMap.put("height", 1000);
    	emulatorDetailsHashMap.put("deviceScaleFactor", 100);
    	emulatorDetailsHashMap.put("mobile", true);
		driverC.executeCdpCommand("Emulation.setDeviceMetricsOverride", emulatorDetailsHashMap );
		driverC.get("https://rahulshettyacademy.com/angularAppdemo/");
    	System.out.println(driverC.findElement(By.className("navbar-toggler-icon")).isDisplayed());
    	
		
    	driverC.quit();
    	
    }
}
