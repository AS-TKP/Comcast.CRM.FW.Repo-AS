package gitSampleClasses;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateContacts {

	public static void main(String[] args) throws Exception {
		FileInputStream fis = new FileInputStream("C:\\Users\\anjal\\Desktop\\commondata.properties");
		Properties Pobj = new Properties();
		Pobj.load(fis);
	String BROWSER = Pobj.getProperty("browser");
	String URL = Pobj.getProperty("url");
	String USERNAME = Pobj.getProperty("username");
	String PASSWORD = Pobj.getProperty("password");
	//generate random number
	Random rndm = new Random();
	int RndmInt = rndm.nextInt(1000);
	//fetch TSD from excel file
	FileInputStream fis1 = new FileInputStream("C:\\Users\\anjal\\Desktop\\orgdata.xlsx");
	Workbook wb = WorkbookFactory.create(fis1);
	Sheet sh = wb.getSheet("Org");
	Row rw = sh.getRow(1);
	String LastName = rw.getCell(7).toString() + RndmInt;
	wb.close();
	//launch browser
	WebDriver driver = null;
	if(BROWSER.equals("chrome")) {
		driver = new ChromeDriver();}
	else if(BROWSER.equals("firefox")) {
		driver = new FirefoxDriver();}
	else if(BROWSER.equals("edge")) {
		driver = new EdgeDriver();}
	else {
		driver = new ChromeDriver();}
	
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.manage().window().maximize();
	driver.get(URL);
	driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	driver.findElement(By.id("submitButton")).click();
	driver.findElement(By.linkText("Contacts")).click();
	driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
	driver.findElement(By.name("lastname")).sendKeys(LastName);
	driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
	
	//verify the Last name
	String HeaderInfo = driver.findElement(By.className("dvHeaderText")).getText();
	if(HeaderInfo.contains(LastName)) {
		System.out.println(LastName+" is created==>Pass");}
	else {
		System.out.println(LastName+" is not created==>Fail");}
	//logout
	Actions act = new Actions(driver);
	WebElement Admin = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	act.moveToElement(Admin).click().perform();
	driver.findElement(By.linkText("Sign Out")).click();
	driver.quit();
	}

}
