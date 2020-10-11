package academy;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.LandingPage;
import pageObject.LoginPage;

public class HomePage extends Base {
	public WebDriver driver;
	@Test(dataProvider = "getData")
	public void basePageNavigation(String userName, String password, String text) throws IOException, InterruptedException {
		driver = initializeDriver();
		driver.get("http://qaclickacademy.com");
		LandingPage l=new LandingPage(driver);
		
		l.getLogin().click();
		//Thread.sleep(2000);
		LoginPage lp=new LoginPage(driver);
		lp.getEmail().sendKeys(userName);
		lp.getPassword().sendKeys(password);
		lp.getLogin().click();

	}
	@DataProvider
	public Object[][] getData()
	{
		Object data[][] =new Object[2][3];
		data[0][0]="abc@gmail.com";
		data[0][1]="abc123";
		data[0][2]="restricted user";
		data[1][0]="xyz@gmail.com";
		data[1][1]="xyz123";
		data[1][2]="restricted user";
		return data;
		
	}
	@AfterTest
	public void teardown()
	{
		driver.close();
	}
}
