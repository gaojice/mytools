package jms.queue;

import java.util.Enumeration;

import javax.jms.JMSException;
import javax.jms.QueueBrowser;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.BrowserCallback;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class MessageCountInQueue {
	public static void main(String[] a) throws JMSException {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[] { "applicationContext-jms-sender.xml" });
		MessageCountInQueue sender = applicationContext.getBean(MessageCountInQueue.class);
		sender.query();
	}

	@Autowired
	private JmsTemplate jmsTemplate;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Transactional
	public void query() {
		System.out.println(jmsTemplate.isSessionTransacted());
		jmsTemplate.browse(new BrowserCallback() {

			@Override
			public Object doInJms(Session session, QueueBrowser browser) throws JMSException {
				Enumeration enumeration = browser.getEnumeration();
				while (enumeration.hasMoreElements()) {
					System.out.println(enumeration.nextElement());
				}
				return null;
			}

		});
	}
}
