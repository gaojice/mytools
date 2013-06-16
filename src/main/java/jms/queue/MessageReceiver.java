package jms.queue;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class MessageReceiver {
	public void receive(String message) {
		System.out.println(message);
	}

	public static void main(String[] args) {
		new ClassPathXmlApplicationContext(new String[] { "applicationContext-jms-receiver.xml" });
	}
}
