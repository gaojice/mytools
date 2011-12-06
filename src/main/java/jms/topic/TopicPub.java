package jms.topic;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class TopicPub {

	public static void main(String[] a) throws JMSException, InterruptedException {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[] { "applicationContext-jms-topic-sender.xml" });
		TopicPub sender = (TopicPub) applicationContext.getBean(TopicPub.class);
			sender.send("123456789" );
	}

	@Autowired
	private JmsTemplate jmsTemplate;

	@Transactional
	public void send(final String taskId) {
		jmsTemplate.send(new MessageCreator() {
			public Message createMessage(Session session) throws JMSException {
				TextMessage createTextMessage = session.createTextMessage();
				createTextMessage.setStringProperty("deviceName", "CNC-JN-L-57O");
				createTextMessage.setText(taskId);
				return createTextMessage;
			}
		});
	}
}
