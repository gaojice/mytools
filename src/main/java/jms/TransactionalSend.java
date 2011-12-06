package jms;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.connection.JmsTransactionManager;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

@Component
public class TransactionalSend {

	public static void main(String[] a) throws JMSException {
		final ApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[] { "applicationContext-jms-transactional-sender.xml" });
		final TransactionTemplate transactionTemplate = new TransactionTemplate(applicationContext.getBean(JmsTransactionManager.class));
		transactionTemplate.execute(new TransactionCallbackWithoutResult() {

			protected void doInTransactionWithoutResult(TransactionStatus status) {
				TransactionalSend sender = (TransactionalSend) applicationContext.getBean(TransactionalSend.class);
				sender.send("123456789");
				sender.send("1");
			}
		});

	}

	@Autowired
	private JmsTemplate jmsTemplate;

	@Transactional
	public void send(final String taskId) {
		if (taskId.equals("1")) {
			throw new RuntimeException();
		}
		System.out.println("1" + jmsTemplate.isSessionTransacted());

		jmsTemplate.send(new MessageCreator() {
			public Message createMessage(Session session) throws JMSException {
				System.out.println("2" + session.getTransacted());
				TextMessage createTextMessage = session.createTextMessage();
				createTextMessage.setText(taskId);
				System.out.println("sended.");
				return createTextMessage;
			}
		});
	}
}
