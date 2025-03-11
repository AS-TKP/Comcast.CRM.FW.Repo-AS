package gitSampleClasses;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
WebDriver driver;
public HomePage(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
}
@FindBy(linkText = "Organizations")
private WebElement Organizationslink;
@FindBy(linkText = "Contacts")
private WebElement Contactslink;
@FindBy(linkText = "More")
private WebElement Morelink;
@FindBy(linkText = "Campaigns")
private WebElement Campaignslink;
@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
private WebElement adminImg;
@FindBy(linkText = "Sign Out")
private WebElement signoutlink;

public WebElement getOrganizationslink() {
	return Organizationslink;
}
public WebElement getContactslink() {
	return Contactslink;
}
public WebElement getMorelink() {
	return Morelink;
}
public WebElement getCampaignslink() {
	return Campaignslink;
}
public WebElement getAdminImg() {
	return adminImg;
}
public WebElement getSignoutlink() {
	return signoutlink;
}
@FindBy(linkText = "Products")
private WebElement Productslink;

public WebElement getProductslink() {
	return Productslink;
}
@FindBy(linkText = "Leads")
private WebElement Leadslink;

public WebElement getLeadslink() {
	return Leadslink;
}
//business lib to naviagte to  campaign page
public void naviagteToCampaignsPage() {
	Actions act = new Actions(driver);
	act.moveToElement(Morelink).click().perform();
	act.moveToElement(Campaignslink).click().perform();
	}
//business lib for logout
public void logout() {
	Actions act = new Actions(driver);
	act.moveToElement(adminImg).click().perform();
	act.moveToElement(signoutlink).click().perform();	
}
}
