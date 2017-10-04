package br.com.example.domain;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.example.application.RabbitConfiguration;

@Service
public class DomainEventPublisher {

	@Autowired
    private RabbitTemplate rabbitTemplate;
   
    public <T extends DomainEvent> void publish(T domainEvent){
		this.rabbitTemplate.convertAndSend(RabbitConfiguration.EXCHANGE_NAME, "", domainEvent);
	}
	
	public static <T extends DomainEvent> void publishDomainEvent(T domainEvent){
		DomainRegister.domainEventPublisher().publish(domainEvent);
	}

}