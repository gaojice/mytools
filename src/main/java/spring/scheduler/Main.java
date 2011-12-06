package spring.scheduler;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] a) {

		new ClassPathXmlApplicationContext(new String[] { "applicationContext-scheduler.xml" });
	}
}
