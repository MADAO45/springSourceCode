package org.springframework.own.initbean;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.own.bean.InitBean1;


public class BeanLifeCycle {

	protected final Log logger = LogFactory.getLog(getClass());

	@Test
	public void BeanFactoryInit() {
		//XmlBeanFactory 过期无法使用

		ClassPathResource resource = new ClassPathResource("BeanLifeCycle.xml");
		DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions(resource);
		//	beanName 无名称时，默认赋值InitBean1#0,取自beanDefinitionNames对象
		InitBean1 initBean1 = factory.getBean("org.springframework.own.bean.InitBean1#0", InitBean1.class);
		logger.info(initBean1);


	}

	@Test
	public void ApplicationContextInit() {
		ApplicationContext applicationContext =
				new ClassPathXmlApplicationContext("postProcessor.xml");

	}
}

