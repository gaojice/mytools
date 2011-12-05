package com.gaojice.tools.jms.sender;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;

public class JmsSender {
	public static void main(String[] args) {
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext(new String[]{"applicationContext-jms.xml"});
		JmsTemplate jmsTemplate=(JmsTemplate) applicationContext.getBean("jmsTemplate");
		JmsTemplate jmsTemplateWithLowPriority=(JmsTemplate) applicationContext.getBean("jmsTemplateWithLowPriority");
		System.out.println(jmsTemplate);
		System.out.println(jmsTemplateWithLowPriority);
	}
}
