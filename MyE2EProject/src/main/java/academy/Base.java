package academy;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.core.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {
public WebDriver driver;
Properties prop;
	public WebDriver initializeDriver() throws IOException {
		prop = new Properties();
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\Rushank\\selenium\\MyE2EProject\\src\\main\\java\\academy\\data.properties");
		prop.load(fis);
		String browserName =  System.getProperty("browser");
				//prop.getProperty("browser");
		if (browserName.equalsIgnoreCase("chrome")) {
			ChromeOptions options =new ChromeOptions();
			options.addArguments("headless");
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Rushank\\selenium_jars\\chromedriver.exe");
		driver= new ChromeDriver(options);
		} else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\Rushank\\selenium_jars\\geckodriver.exe");
			driver= new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("IE")) {

			System.setProperty("webdriver.edge.driver", "C:\\Users\\Rushank\\selenium_jars\\msedgedriver.exe");
			driver= new EdgeDriver();
			
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return driver;
	}
	public String getScreenShotPath(String testcaseName, WebDriver driver) throws IOException
	{
		TakesScreenshot ts =(TakesScreenshot)driver;
		File source =ts.getScreenshotAs(OutputType.FILE);
		String destinationFile=System.getProperty("user.dir")+"\\reports\\"+ testcaseName;
		org.apache.commons.io.FileUtils.copyFile(source, new File(destinationFile));
		return destinationFile;
	}
}
