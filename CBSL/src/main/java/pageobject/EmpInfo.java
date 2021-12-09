package pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.webutil;

public class EmpInfo {
	
	public void pimpage() {

		//a[@id='menu_pim_viewPimModule']
		}
		@FindBy(xpath="//a[@id='menu_pim_viewPimModule']") WebElement pimclick;
		@FindBy(id="empsearch_employee_name_empName") WebElement empname;
		@FindBy(id="empsearch_id") WebElement empid;
		@FindBy(id="empsearch_supervisor_name") WebElement supervisor;
		@FindBy(id="searchBtn") WebElement btn;
		public EmpInfo (webutil util){
		PageFactory.initElements(util.driver,this);
		}


		public void clickonpim() {
		pimclick.click();
		}
		public void employeename() {
		empname.sendKeys("Odis");
		}
		public void employeeid() {
		empid.sendKeys("0002");
		}
		public void employeesupervisor() {
		supervisor.sendKeys();
		}
		public void searchbutton() {
		btn.click();
		}



}
