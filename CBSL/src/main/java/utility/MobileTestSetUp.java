package utility;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class MobileTestSetUp {
	
	@Test
	public void setup() throws MalformedURLException {
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME," Android");
		dc.setCapability(MobileCapabilityType.PLATFORM_VERSION,"10.0");
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "Android");
		dc.setCapability(MobileCapabilityType.APP, "C:\\Users\\290108\\eclipse-workspace\\CBSL\\Apk\\Calculator.apk");
		
		URL url= new URL("http://localhost:4723/wd/hub");
		AndroidDriver driver =new AndroidDriver(url, dc);
		
		
	}
	

}
