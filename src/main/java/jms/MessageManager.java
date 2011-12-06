package jms;

import javax.jms.Message;
import javax.jms.MessageListener;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class MessageManager implements MessageListener {

	public void onMessage(Message message) {
		try {
			throw new RuntimeException("test");
		} catch (RuntimeException e) {
			System.out.println("catched");
			throw e;
		} catch (Exception e) {
			System.out.println("1");
			e.printStackTrace();
			throw new CfException(123L, e, "");
		}

	}

	public static void main(String[] a) {
		new ClassPathXmlApplicationContext(new String[] { "applicationContext-jms.xml" });
	}

}
