package com.nk.pma.pma.logging;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingClass {
    
private final Logger log = LoggerFactory.getLogger(this.getClass());
    

    @Pointcut("within(com.nk.pma.pma.controllers..*)")
    public void definepackage_pointcuts(){


    }

    @After("definepackage_pointcuts()")
    public void log(){
        log.debug("----->>>> ========================================= <<<<-----");
       

    }
}

