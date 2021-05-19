package acme.testing.authenticated.task;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.AcmePlannerTest;

public class AuthenticatedTaskListTest extends AcmePlannerTest {

	// Lifecycle management ---------------------------------------------------
	
		// Test cases -------------------------------------------------------------

		//en este test probaremos el listado de Task, probaremos que se muestra en el orden correspondiente
		//se espera que sea correcto el orden de las Task
		//POSIBLE PROBLEMA: con el tiempo el contenido se puede ver cambiado dado que se muestran las Task del populate Sample actual
		@ParameterizedTest
		@CsvFileSource(resources = "/listTaskAuthenticated/positive.csv", encoding = "utf-8", numLinesToSkip = 1)
		@Order(10)
		public void positiveAuthenticatedListTask(final int recordIndex, final String title, final String startMoment, final String endMoment,final String description ,final String workload,final String status,final String link) {
			super.navigateHome();
			
			super.signIn("administrator", "administrator");
			
			super.clickOnMenu("Authenticated", "List Task");
			
			super.checkColumnHasValue(recordIndex, 0, title);
			super.checkColumnHasValue(recordIndex, 1, startMoment);
			super.checkColumnHasValue(recordIndex, 2, endMoment);
			super.checkColumnHasValue(recordIndex, 3, workload);

			super.clickOnListingRecord(recordIndex);
			
			super.checkInputBoxHasValue("title", title);
			super.checkInputBoxHasValue("startMoment", startMoment);
			super.checkInputBoxHasValue("endMoment", endMoment);
			super.checkInputBoxHasValue("description", description);
			super.checkInputBoxHasValue("workload", workload);
			super.checkInputBoxHasValue("status", status);
			super.checkInputBoxHasValue("link", link);

			super.signOut();
			
			}
		
			
			//en este test probaremos el listado de Task, probaremos que no se muestra debido a que no estamos con la sesión iniciada
			@Test
			public void negativeAuthenticatedListTask() {

				final String path="/authenticated/task/list";
				final String query=super.getContextQuery();
				
				super.navigate(path, query);
				
				super.checkErrorsExist();
				
		}

		// Ancillary methods ------------------------------------------------------

}
