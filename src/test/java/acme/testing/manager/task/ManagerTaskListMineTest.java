package acme.testing.manager.task;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.AcmePlannerTest;

public class ManagerTaskListMineTest  extends AcmePlannerTest {
	
	
	@ParameterizedTest
	@CsvFileSource(resources = "/listTask/positive.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positiveListTask(final int recordIndex, final String title, final String startMoment, 
		final String endMoment,final String workload,final String status, final String description, final String link) {
		
		super.navigateHome();
		super.signIn("manager", "manager");
		
		super.clickOnMenu("Manager", "List tasks");
		super.checkColumnHasValue(recordIndex, 0, title);
		super.checkColumnHasValue(recordIndex, 1, startMoment);
		super.checkColumnHasValue(recordIndex, 2, endMoment);
		super.checkColumnHasValue(recordIndex, 3, workload);

	/*	super.clickOnListingRecord(recordIndex);
		
        super.checkInputBoxHasValue("title", title);
        super.checkInputBoxHasValue("startMoment", startMoment);
        super.checkInputBoxHasValue("endMoment", endMoment);
        super.checkInputBoxHasValue("workload", workload);
        super.checkInputBoxHasValue("status", status);
        super.checkInputBoxHasValue("description", description);
        super.checkInputBoxHasValue("link", link);

		*/
		super.navigateHome();

	}
}