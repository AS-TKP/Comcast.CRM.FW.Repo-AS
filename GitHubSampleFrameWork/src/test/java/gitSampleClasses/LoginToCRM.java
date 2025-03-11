package gitSampleClasses;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginToCRM {

	public static void main(String[] args) {
		WebDriver driver = new  ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		String HomePageTitle = driver.getTitle();
		System.out.println(HomePageTitle);
		if(HomePageTitle.contains(HomePageTitle)) {
			System.out.println("HomePageTitle is : "+ HomePageTitle);
		}
		else {
			System.out.println("HomePageTitle tc failed");
		}
		driver.quit();
		
	}
}