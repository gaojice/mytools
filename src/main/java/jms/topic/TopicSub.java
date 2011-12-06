package jms.topic;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class TopicSub implements MessageListener {

	public static void main(String[] a) throws JMSException {
		new ClassPathXmlApplicationContext(new String[] { "applicationContext-jms-topic-sub.xml" });
	}

	@Override
	public void onMessage(Message message) {
		try {
			System.out.println(((TextMessage) message).getText());
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
