package br.com.example.application.config.rabbit;

import java.util.ArrayList;
import java.util.List;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.Binding.DestinationType;
import org.springframework.amqp.core.Declarable;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfiguration {

public final static String EXCHANGE_NAME = "hexagonal"; 
	
	public final static String QUEUE_PRODUCT_LISTENER = EXCHANGE_NAME+"."+"productListener";
	
	@Bean
	public List<Declarable> ds() {
		return queues(QUEUE_PRODUCT_LISTENER);
	}
	
	@Autowired
	private ConnectionFactory rabbitConnectionFactory;

	@Bean
	public AmqpAdmin amqpAdmin() {
		return new RabbitAdmin(rabbitConnectionFactory);
	}

	@Bean
	public FanoutExchange exchange() {
		return new FanoutExchange(EXCHANGE_NAME);
	}

	@Bean
	public RabbitTemplate rabbitTemplate() {
		RabbitTemplate r = new RabbitTemplate(rabbitConnectionFactory);
		r.setExchange(EXCHANGE_NAME);
		r.setChannelTransacted(false);
		r.setConnectionFactory(rabbitConnectionFactory);
		r.setMessageConverter(jsonMessageConverter());
		return r;
	}
	
	@Bean
	public MessageConverter jsonMessageConverter() {
		return new Jackson2JsonMessageConverter();
	}
	

	private List<Declarable> queues(String ... names){
		List<Declarable> result = new ArrayList<>();
		
		for (int i = 0; i < names.length; i++) {
			result.add(makeQueue(names[i]));
			result.add(makeBindingToQueue(names[i]));
		}
		return result;
	}
	
	
	private static Binding makeBindingToQueue(String queueName){
		return new Binding(queueName, DestinationType.QUEUE, EXCHANGE_NAME, "", null);
	}
	
	private static Queue makeQueue(String nome){
		return new Queue(nome);
	}

}
