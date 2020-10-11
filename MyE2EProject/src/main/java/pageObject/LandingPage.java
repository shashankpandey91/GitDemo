package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LandingPage {
public WebDriver driver;
By signin=By.cssSelector("a[href*='sign_in']");
By title=By.cssSelector(".text-center>h2");
By navBar=By.cssSelector("nav[class*='navbar-collapse']");

public LandingPage(WebDriver driver) {
	this.driver=driver;
}

public WebElement getLogin()
{
	WebDriverWait wait =new WebDriverWait(driver, 30);
	WebElement el=wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[href*='sign_in']")));
	return el;
}

public WebElement getTitle() {
	return driver.findElement(title);
}
public WebElement getNavBar() {
	return driver.findElement(navBar);
}

}
