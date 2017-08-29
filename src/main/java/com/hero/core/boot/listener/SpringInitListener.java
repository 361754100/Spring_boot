package com.hero.core.boot.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class SpringInitListener implements ApplicationListener<ContextRefreshedEvent> {

    private final static Logger logger = LoggerFactory.getLogger(SpringInitListener.class);

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if(event.getApplicationContext().getParent() == null){
            logger.info("==============SpringInitListener.start()===============");
            logger.debug("==============SpringInitListener.debug()===============");
            logger.error("==============SpringInitListener.error()===============");
        }
    }
}
