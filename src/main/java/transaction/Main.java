package transaction;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		ServiceB serviceB = (ServiceB) ctx.getBean("serviceB");
		serviceB.methodB();
	}
}
