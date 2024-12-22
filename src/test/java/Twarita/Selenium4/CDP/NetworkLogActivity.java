package Twarita.Selenium4.CDP;

import java.util.Optional;

import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v131.network.Network;
import org.openqa.selenium.devtools.v131.network.model.Response;
import org.openqa.selenium.edge.EdgeDriver;

public class NetworkLogActivity {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EdgeDriver driverE = new EdgeDriver();
    	DevTools devToolsE = driverE.getDevTools();
    	devToolsE.createSession();
    	
    	devToolsE.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
    	
    	//Same as reponse below, request and other evnets also can be listened. Vheck their documentation for details
    	devToolsE.addListener(Network.responseReceived(), response ->
    	{
    		Response res = response.getResponse();
    		if(res.getStatus().toString().startsWith("4")||res.getStatus().toString().startsWith("5"))
    			System.out.println(res.getUrl()+" is failing with status "+res.getStatus());
    		else System.out.println(res.getUrl()+" is passed with status "+res.getStatus());
    	});
    	
    	driverE.get("https://www.google.com");
    	
    	driverE.quit();
	}

}
