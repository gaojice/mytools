package jms;

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

@Component
public class BatchSender {

	public static void main(String[] a) throws JMSException {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[] { "applicationContext-jms-sender.xml" });
		BatchSender sender = (BatchSender) applicationContext.getBean(BatchSender.class);
		sender.send("2");
		sender.send("64");
		sender.send("65");
		sender.send("66");
		sender.send("67");
		sender.send("68");
		sender.send("69");
		sender.send("70");
		sender.send("71");
		sender.send("72");
		sender.send("73");
		sender.send("74");
		sender.send("75");
		sender.send("76");
		sender.send("77");
		sender.send("78");
		sender.send("79");
		sender.send("80");
		sender.send("81");
		sender.send("82");
		sender.send("83");
		sender.send("84");
		sender.send("85");
		sender.send("86");
		sender.send("87");
		sender.send("88");
		sender.send("89");
		sender.send("90");
		sender.send("91");
		sender.send("92");
		sender.send("93");
		sender.send("94");
		sender.send("95");
		sender.send("96");
		sender.send("97");
		sender.send("98");
		sender.send("99");
		sender.send("100");
		sender.send("101");
		sender.send("102");
		sender.send("103");
		sender.send("104");
		sender.send("105");
		sender.send("106");
		sender.send("107");
		sender.send("108");
		sender.send("109");
		sender.send("110");
		sender.send("111");
		sender.send("112");
		sender.send("113");
		sender.send("114");
		sender.send("115");
		sender.send("116");
		sender.send("117");
		sender.send("118");
		sender.send("119");

	}

	@Autowired
	private JmsTemplate jmsTemplate;

	public void send(final String taskId) {
		System.out.println("begin");
		jmsTemplate.send(new MessageCreator() {
			public Message createMessage(Session session) throws JMSException {
				TextMessage createTextMessage = session.createTextMessage();
				createTextMessage.setText(taskId);
				return createTextMessage;
			}
		});
		System.out.println("sended.");
	}

}