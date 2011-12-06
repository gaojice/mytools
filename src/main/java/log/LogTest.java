package log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogTest {
	public static void main(String[] a) {
		Logger logger = LoggerFactory.getLogger(LogTest.class);
		logger.debug("debug");
		logger.info("info");
		logger.warn("warn");
		logger.error("error");
	}
}
