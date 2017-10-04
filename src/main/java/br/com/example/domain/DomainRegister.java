package br.com.example.domain;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class DomainRegister implements ApplicationContextAware {

    private static ApplicationContext applicationContext;
    private static DomainEventPublisher domainEventPublisher;

    public static DomainEventPublisher domainEventPublisher() {
        if (domainEventPublisher == null) {

            if (applicationContext == null)
                throw new RuntimeException("ApplicationContext não foi definido.");

            domainEventPublisher =
                    (DomainEventPublisher) applicationContext.getBean(DomainEventPublisher.class);
        }
        return domainEventPublisher;
    }

    @Override
    public synchronized void setApplicationContext(ApplicationContext applicationContext)
            throws BeansException {
        DomainRegister.applicationContext = applicationContext;
    }

    public static void defineApplicationContext(ApplicationContext applicationContext)
            throws BeansException {
        DomainRegister.applicationContext = applicationContext;
    }

    public synchronized static void setDomainEventPublisher(DomainEventPublisher publisher) {
        domainEventPublisher = publisher;
    }

}
