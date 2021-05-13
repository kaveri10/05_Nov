package com.spring.cg;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class AppPostProcessor implements BeanPostProcessor {

	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("\tpostProcessAfterInitialization: " + beanName);
		return bean;
	}

	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("\tpostProcessBeforeInitialization: " + beanName);
/*
		if(bean instanceof LoginBean) {
			bean.setUserName(decrypt(bean.getUserName()));
		}
*/		
		return bean;
	}

}
