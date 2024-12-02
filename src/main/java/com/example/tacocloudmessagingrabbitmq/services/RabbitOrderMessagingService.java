package com.example.tacocloudmessagingrabbitmq.services;

import com.example.tacoclouddomain.entities.TacoOrder;
import com.example.tacocloudmessagingjms.services.OrderMessagingService;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.stereotype.Service;

@Service
public class RabbitOrderMessagingService implements OrderMessagingService {

    private final RabbitTemplate rabbitTemplate;

    public RabbitOrderMessagingService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public void sendOrder(TacoOrder order) {
        MessageConverter converter  = rabbitTemplate.getMessageConverter();
        MessageProperties props = new MessageProperties();
        props.setHeader("X_ORDER_SOURCE", "WEB");
        Message message = converter.toMessage(order, props);
        rabbitTemplate.send("tacocloud.queue", message);
    }
}
