package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class webutil {
	
	public WebDriver driver;
	
	public void launchBrowser(String browserName) {
		
			if(browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver =new ChromeDriver();

			}else if(browserName.equalsIgnoreCase("edge")) {
				WebDriverManager.edgedriver().setup();
				driver=new EdgeDriver();

			}else if(browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.chromedriver().setup();
			driver=new FirefoxDriver();

			}else if (browserName.equalsIgnoreCase("opera")) {
			WebDriverManager.operadriver().setup();
			driver = new OperaDriver();
			}
			else
			System.out.println("Please Enter Browser Name: Chrome or Firefox");

			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.get("https://opensource-demo.orangehrmlive.com/");
	}
	
	public void Screenshot(String X) {
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File src1=new File(".//Screenshot//"+X+".png");
		try {
		FileUtils.copyFile(src,src1);
		} 
		catch (IOException e) {
		e.printStackTrace();
		}
		}
		
	
	
	
	
	public void close(){
	driver.close();
			
	}
	}


