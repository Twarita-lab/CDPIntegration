package Twarita.Selenium4.CDP;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v129.network.model.ConnectionType;
import org.openqa.selenium.devtools.v130.network.Network;

public class NetworkSpeedEmulation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ChromeDriver driver = new ChromeDriver();
		DevTools devTools = driver.getDevTools();
		devTools.createSession();
		
		devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
		
		Map<String, Object> networkConditions = new HashMap<>();
		networkConditions.put("offline", true);
		networkConditions.put("latency", 20);
		networkConditions.put("downloadThroughput", 4000);
		networkConditions.put("uploadThroughput", 4000);
		networkConditions.put("connectionType", ConnectionType.CELLULAR4G);
		networkConditions.put("packetLoss", Optional.empty());
		networkConditions.put("packetQueueLength", Optional.empty());
		networkConditions.put("packetReordering", Optional.empty());
		
		
		//driver.executeCdpCommand("Network.emulateNetworkConditions", networkConditions);
		
		devTools.send(Network.emulateNetworkConditions(true, 230, 40567, 20866, Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty()));
		
		devTools.addListener(Network.loadingFailed(), loadingFailed ->{
			System.out.println(loadingFailed.getErrorText());
			System.out.println(loadingFailed.getBlockedReason());
			System.out.println(loadingFailed.getCanceled());
			System.out.println(loadingFailed.getRequestId());
			System.out.println(loadingFailed.getTimestamp());
		});
		
		driver.get("https://www.google.com");
		
		driver.quit();
		

	}

}
