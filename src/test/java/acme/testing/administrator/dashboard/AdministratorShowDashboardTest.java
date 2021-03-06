package acme.testing.administrator.dashboard;

import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import acme.testing.AcmeWorkPlansTest;

public class AdministratorShowDashboardTest extends AcmeWorkPlansTest{

	
	
	@ParameterizedTest
	@CsvFileSource(resources = "/administrator/dashboard/positive.csv", encoding="utf-8", numLinesToSkip=1)
	@Order(12)
	public void dashboardPositive(final String recordIndex, final String number) {
		
		super.signIn("administrator", "administrator");
		
		super.clickOnMenu("Administrator", "Dashboard");
		
		By locatorTask;
		String stringTask;
		List<WebElement> elementTask;
		locatorTask = By.xpath("//td");
		elementTask = super.locateMany(locatorTask);
		stringTask = elementTask.get(Integer.parseInt(recordIndex)-1).getText();
		
		assert stringTask.equals(number.toString());
		super.signOut();
	}
	
	@Test
	@Order(13)
	public void dashboardNegative() {
		
		super.signIn("manager", "manager");
		
		super.navigate("/administrator/dashboard", "show");
		
		super.checkPanicExists();
		
		super.signOut();
	}
	
	
}
