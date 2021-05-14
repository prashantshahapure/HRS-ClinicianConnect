package com.hrs.genericpage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;

public class MasterPage {

	public static WebDriver driver;
	public Properties config;
	public Properties loc;
	
	
	public Logger logger;
	
		
	// Constructor 
	public MasterPage() throws Exception
	{
		// configuration properties file Configuration

		FileInputStream fin = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\com\\hrs\\repository\\Configuration.properties");
		config = new Properties();
		config.load(fin);
		
		//Configuration properties file Locators 
		FileInputStream fs = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\com\\hrs\\repository\\locators.properties");
		loc = new Properties();
		loc.load(fs);
		
		
		// For loggin purpose
		logger = Logger.getLogger("Log4j");
		PropertyConfigurator.configure(System.getProperty("user.dir") + "\\Log4j.properties");
		
		
		
		if(config.getProperty("browser").equalsIgnoreCase("chrome"))
		{
			
			//DesiredCapabilities cap = DesiredCapabilities.chrome();
			//cap.setBrowserName("chrome");
			//cap.setPlatform(Platform.WINDOWS);
			
			//RemoteWebDriver driver = new RemoteWebDriver(cap);
								
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\main\\java\\com\\hrs\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(config.getProperty("browser").equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\src\\main\\java\\com\\hrs\\drivers\\geckodriver.exe");
		}
		else
		{
			System.out.println("Open IE browser");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get("https://cc.healthrecoverysolutions.com/login");
		
		
	}
	
	public void click(String xpathkey)
	{
		//driver.findElement(By.xpath(loc.getProperty(xpathkey))).clear();
		driver.findElement(By.xpath(loc.getProperty(xpathkey))).click();
		
	}
	
	public void sendData(String xpathkey, String data)
	{
		//driver.findElement(By.xpath(loc.getProperty(xpathkey))).clear();
		driver.findElement(By.xpath(loc.getProperty(xpathkey))).sendKeys(data);
		
	}
	
	public String getText(String xpathkey)
	{
		return driver.findElement(By.xpath(loc.getProperty(xpathkey))).getText();
	}
	
	
	//Screenshotcapture
	
	public void captureScreenShotCapture(ITestResult result) throws IOException
	{
		
		if(ITestResult.FAILURE ==result.getStatus())
		{
			
			TakesScreenshot ts = (TakesScreenshot)driver;
			File src = ts.getScreenshotAs(OutputType.FILE);
			
			FileUtils.copyFile(src, new File(System.getProperty("user.dir") + "\\Screenshots\\"+ result.getName()+ ".png"));
			System.out.println(result.getName() +"method() Screenshot captured");
		}
	}
	
	
}
