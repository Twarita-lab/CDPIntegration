package Twarita.Selenium4.OtherNetworkConcepts;

import java.net.URI;
import java.util.function.Predicate;

import org.openqa.selenium.HasAuthentication;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicAuthentication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver  = new ChromeDriver();
		Predicate<URI> uriPredicate = URI->URI.getHost().contains("httpbin.org");
		
		((HasAuthentication)driver).register(uriPredicate, UsernameAndPassword.of("foo","bar"));
		
		driver.get("https://httpbin.org/basic-auth/foo/bar");
		driver.get("https://httpbin.org/post");
		
		driver.quit();
		

	}

}
