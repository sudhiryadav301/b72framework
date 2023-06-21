package generic;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {

	public int count = 0;

	public boolean retry(ITestResult result) {
		BaseTest basetest = (BaseTest) result.getInstance();

		String methodname = result.getName();
		basetest.extentTest.info("we are inside retry method is: ");

		basetest.extentTest.info("this failed method is: " + methodname);

		if (count <= 1) {

			basetest.extentTest.skip("skipping the test and running it");
			//BaseTest.report.removeTest(methodname);
			count++;
			return true;// true rerun again
		}

		else {
			basetest.extentTest.warning("already reexecuted,hence stopping it");
			return false; // false dont rerun
		}

	}

}
