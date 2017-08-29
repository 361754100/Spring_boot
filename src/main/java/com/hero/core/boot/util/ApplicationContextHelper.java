package com.hero.core.boot.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Spring Bean 工厂
 */
@Component
public class ApplicationContextHelper implements ApplicationContextAware{

    private static ApplicationContext applicationContext;

    private final static Logger logger = LoggerFactory.getLogger(ApplicationContextHelper.class);

    @SuppressWarnings("static-access")
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public static <T> T getBean(Class<T> clz) {
        return applicationContext.getBean(clz);
    }

    @SuppressWarnings("unchecked")
    public static <T> T getBean(String id) {
        return (T) applicationContext.getBean(id);
    }

}
