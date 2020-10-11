package academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.LandingPage;
import pageObject.LoginPage;

public class ValidateTitle extends Base {
	public WebDriver driver;
	public static Logger log=LogManager.getLogger(Base.class.getName());
	@Test
	public void basePageNavigation() throws IOException, InterruptedException {
		driver = initializeDriver();
		log.info("Driver is initialize");
		driver.get("http://qaclickacademy.com");
		log.info("Navigated to HomePage");
		LandingPage l=new LandingPage(driver);
		Assert.assertEquals(l.getTitle().getText(), "fEATURED COURSES");
		

	}
	@AfterTest
	public void teardown()
	{
		driver.close();
	}
	
}
