package utility;

import java.lang.reflect.Method;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class BaseClass {
	
	protected webutil ut = new webutil();
	
	private ExtentHtmlReporter htmlReporter;
	private ExtentReports extent;
	private ExtentTest test;


	@BeforeTest
	public void SetRepoert() {
	 htmlReporter = new ExtentHtmlReporter("ExtentReporet// Testcasereport.html"); 
	extent=new ExtentReports();
	extent.attachReporter(htmlReporter);
	extent.setSystemInfo("HostName", "CBSL");
	extent.setSystemInfo("Enviroment", "Local");
	extent.setSystemInfo("Os", "Windos 10");
	extent.setSystemInfo("User Name", "Sandip");



	htmlReporter.config().setDocumentTitle("Automation Report");
	htmlReporter.config().setReportName("Functional Report");
	htmlReporter.config().setTheme(Theme.STANDARD);
	}
	
	@Parameters ("browser")
	@BeforeMethod
	public void launchBrowser(Method methodname,String browser) {
	ut.launchBrowser(browser);
	test=extent.createTest(methodname.getName());
	}
	
	
	@AfterMethod
	public void Getresult(ITestResult result) {
	if(result.getStatus()== ITestResult.FAILURE) {
	test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+"Testcase fail",ExtentColor.RED));
	test.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable()+"Testcase fail",ExtentColor.RED));
	ut.Screenshot(result.getName());
	}
	
	else if(result.getStatus() == ITestResult.SKIP){
	//logger.log(Status.SKIP, "Test Case Skipped is "+result.getName());
	test.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " - Test Case Skipped", ExtentColor.ORANGE));
	}
	
	else if(result.getStatus() == ITestResult.SUCCESS)
	{

	test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" Test Case PASSED", ExtentColor.GREEN));
	}
	ut.close();


	}
	@AfterTest
	public void endreport() {
	extent.flush();
	}


	
	
	

}
