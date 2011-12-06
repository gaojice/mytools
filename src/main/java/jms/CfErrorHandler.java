package jms;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.ErrorHandler;

@Component
public class CfErrorHandler implements ErrorHandler {
	private final Log logger = LogFactory.getLog(this.getClass());

	public void handleError(Throwable t) {
		if (t instanceof CfException) {
			System.out.println("2");
			t.printStackTrace();
		} else {
			System.out.println("3");
			t.printStackTrace();
			logger.error("Unknown Exception occur:" + t.getMessage(), t);
		}

	}

}
