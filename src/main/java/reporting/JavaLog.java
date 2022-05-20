package reporting;

import java.util.logging.Logger;
import org.testng.Reporter;

public class JavaLog {

	private static final Logger LOGGER = Logger.getLogger(JavaLog.class.getName());
	
	public static void log(String msg) {
		LOGGER.info(msg);
		Reporter.log(msg + "<br>");
	}
}
