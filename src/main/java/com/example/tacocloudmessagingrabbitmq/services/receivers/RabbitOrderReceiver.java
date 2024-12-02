package com.example.tacocloudmessagingrabbitmq.services.receivers;

import com.example.tacoclouddomain.entities.TacoOrder;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class RabbitOrderReceiver implements OrderReceiver {

    private final RabbitTemplate rabbitTemplate;

    public RabbitOrderReceiver(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public TacoOrder receiveOrder() {
        return (TacoOrder) rabbitTemplate.receiveAndConvert("tacocloud.queue");
    }

}
