package Twarita.Selenium4.CDP;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v131.fetch.Fetch;
import org.openqa.selenium.devtools.v131.fetch.model.RequestPattern;
import org.openqa.selenium.devtools.v131.network.model.ErrorReason;

public class FailingRequest {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		ChromeDriver driver = new ChromeDriver();
		
		DevTools devTools = driver.getDevTools();
		devTools.createSession();
		
		Optional <List<RequestPattern>> requestPattern = Optional.of(Arrays.asList(new RequestPattern(Optional.of("*=shetty"), 
										Optional.empty(),
										Optional.empty())));
		devTools.send(Fetch.enable(requestPattern, Optional.empty()));
		

		devTools.addListener(Fetch.requestPaused(), request -> {
				devTools.send(Fetch.failRequest(request.getRequestId(), ErrorReason.FAILED));
			}
		);
		
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");

		driver.findElement(By.cssSelector("button[routerlink='/library']")).click();

		Thread.sleep(2000);
		driver.quit();

	}

}
