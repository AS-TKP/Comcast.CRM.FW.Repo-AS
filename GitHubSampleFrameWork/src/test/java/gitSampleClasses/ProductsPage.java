package gitSampleClasses;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ProductsPage {

	public static void main(String[] args) {
		WebDriver driver = new  ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Products")).click();
		String ProductsPage = driver.getTitle();
		System.out.println(ProductsPage);

		//add a new product
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		driver.findElement(By.name("productname")).sendKeys("popx");
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		//search product using product no.
		driver.findElement(By.name("search_text")).sendKeys("PRO1");
		driver.findElement(By.name("submit")).click();
		
	}

}
