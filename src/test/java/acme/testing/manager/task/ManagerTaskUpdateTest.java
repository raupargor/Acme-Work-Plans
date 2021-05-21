package acme.testing.manager.task;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.AcmePlannerTest;

public class ManagerTaskUpdateTest   extends AcmePlannerTest  {

	
	@ParameterizedTest
	@CsvFileSource(resources = "/updateTaskManager/positive.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positiveUpdate(final int recordIndex, final String title, final String startMoment, 
		final String endMoment,final String workload,final String status, final String description, final String link) {
		
		super.signIn("manager", "manager");
		
		super.clickOnMenu("Manager", "List tasks");
		super.clickOnListingRecord(recordIndex);
		super.fillInputBoxIn("title", title);
		super.fillInputBoxIn("startMoment", startMoment);
		super.fillInputBoxIn("endMoment", endMoment);
		super.fillInputBoxIn("workload", workload);
		super.fillInputBoxIn("status", status);
		super.fillInputBoxIn("description", description);
		super.fillInputBoxIn("link", link);
		
		super.clickOnSubmitButton("Update Task");

	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "/updateTaskManager/negative.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void negativeUpdate(final int recordIndex, final String title, final String startMoment, 
		final String endMoment,final String workload,final String status, final String description, final String link) {
		
		super.signIn("manager", "manager");
		
		super.clickOnMenu("Manager", "List tasks");
		super.clickOnListingRecord(recordIndex);
		super.fillInputBoxIn("title", title);
		super.fillInputBoxIn("startMoment", startMoment);
		super.fillInputBoxIn("endMoment", endMoment);
		super.fillInputBoxIn("workload", workload);
		super.fillInputBoxIn("status", status);
		super.fillInputBoxIn("description", description);
		super.fillInputBoxIn("link", link);
		
		super.clickOnSubmitButton("Update Task");
		super.checkErrorsExist();	


	}

}
