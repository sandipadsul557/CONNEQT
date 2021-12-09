package testrun;


import org.testng.Assert;
import org.testng.annotations.Test;

import pageobject.EmpInfo;
import pageobject.loginPage;
import utility.BaseClass;
import utility.webutil;

public class logiPageTest extends BaseClass {
	
	@Test (priority = 1)
	public void username() {
		
		loginPage lp = new loginPage(ut);
		lp.username();
		lp.passward();
		lp.button();
	}
	
	@Test (priority = 2)	
	public void pimpage() {
		username();
		EmpInfo em=new EmpInfo(ut);
		em.clickonpim();
		em.employeename();
		em.employeeid();
		//em.employeesupervisor();
		em.searchbutton();
		
	}
		
	
}
