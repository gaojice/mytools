package jms;

import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.QueueBrowser;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.BrowserCallback;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

@Component
public class Sender {

	public static void main(String[] a) throws JMSException {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[] { "applicationContext-jms-sender.xml" });
		Sender sender = (Sender) applicationContext.getBean(Sender.class);
		//		System.out.println(sender.messageCountInMQ());
		sender.nativeSend("test");
		//		System.out.println(sender.messageCountInMQ());
	}

	@Autowired
	private JmsTemplate jmsTemplate;

	@Autowired
	private ConnectionFactory amqConnectionFactory;

	public void nativeSend(String message) {
		try {
			Session session = amqConnectionFactory.createConnection().createSession(true, Session.AUTO_ACKNOWLEDGE);
			session.createProducer(new ActiveMQQueue("com.chinacache.oss.jms.task")).send(session.createTextMessage("ttt"));
			session.commit();
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void send(final String taskId) {
		System.out.println(jmsTemplate.isSessionTransacted());
		System.out.println("begin");
		jmsTemplate.send(new MessageCreator() {
			public Message createMessage(Session session) throws JMSException {
				TextMessage createTextMessage = session.createTextMessage();
				createTextMessage.setText(taskId);
				return createTextMessage;
			}
		});
		System.out.println("sended.");
		System.out.println("end");
	}

	public int messageCountInMQ() {
		BrowserCallbackForMessageCount callback = new BrowserCallbackForMessageCount();
		jmsTemplate.browse(callback);
		return callback.getCount();
	}
}

class BrowserCallbackForMessageCount implements BrowserCallback<Integer> {
	private int count;

	public int getCount() {
		return count;
	}

	@Override
	public Integer doInJms(javax.jms.Session session, QueueBrowser browser) throws JMSException {
		while (browser.getEnumeration().hasMoreElements()) {
			count++;
			System.out.println(count);
		}
		return count;
	}

}
