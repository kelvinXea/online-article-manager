package com.onlinearticle.service.onlinearticlemanager.infrastructure.rabbitmq.configuration;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.boot.autoconfigure.amqp.SimpleRabbitListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.onlinearticle.service.onlinearticlemanager.infrastructure.rabbitmq.MessageConsumerService;

@Configuration
public class EventConsumerConfiguration {
	
    @Bean
    public Queue queue() {
        return new Queue("onlineArticleQueue");
    }

    @Bean
    public DirectExchange exchange() {
        return new DirectExchange("onlinearticle.rpc");
    }
    
    @Bean
    public MessageConverter jsonMessageConverter(){
        return new Jackson2JsonMessageConverter();
    }
    
    @Bean
    public SimpleRabbitListenerContainerFactory jsonFactory(ConnectionFactory connectionFactory,
            SimpleRabbitListenerContainerFactoryConfigurer configurer) {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        configurer.configure(factory, connectionFactory);
        factory.setMessageConverter(jsonMessageConverter());
        return factory;
    }

    @Bean
    public Binding binding(DirectExchange exchange, 
        Queue queue) {
        return BindingBuilder.bind(queue)
            .to(exchange)
            .with("onlinearticle.request.ids");
    }
    
    @Bean
    public MessageConsumerService eventReceiver() {
    	return new MessageConsumerService();
    }


}
