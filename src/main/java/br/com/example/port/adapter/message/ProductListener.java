package br.com.example.port.adapter.message;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import br.com.example.application.RabbitConfiguration;
import br.com.example.domain.DomainEvent;

@Component
@RabbitListener(id = "productListener", queues = RabbitConfiguration.QUEUE_PRODUCT_LISTENER)
public class ProductListener {

	@RabbitHandler
	public <T extends DomainEvent> void eventHandle(T event) {
		System.out.println("Evento recebido... processando...:" + event.toString());
	}
}
