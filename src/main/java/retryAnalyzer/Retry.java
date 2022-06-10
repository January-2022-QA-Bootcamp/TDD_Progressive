package retryAnalyzer;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer{

	private int maxRetry = 3;
	private int count = 0;
	
	@Override
	public boolean retry(ITestResult result) {
		if(!result.isSuccess()) {
			if(count < maxRetry) {
				count++;
				result.setStatus(ITestResult.FAILURE);
				return true;
			}else {
				result.setStatus(ITestResult.FAILURE);
			}
		}else {
			result.setStatus(ITestResult.SUCCESS);
		}
		return false;
	}

}
