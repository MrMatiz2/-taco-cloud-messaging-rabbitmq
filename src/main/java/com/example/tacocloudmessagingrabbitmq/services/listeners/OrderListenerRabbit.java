package com.example.tacocloudmessagingrabbitmq.services.listeners;

import com.example.tacoclouddomain.entities.TacoOrder;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

//@Profile("rabbit-listener")
@Component
public class OrderListenerRabbit {

    private final KitchenOrderRabbit kitchenOrderRabbit;

    public OrderListenerRabbit(KitchenOrderRabbit kitchenOrderRabbit) {
        this.kitchenOrderRabbit = kitchenOrderRabbit;
    }

    @RabbitListener(queues = "tacocloud.queue")
    public void receiveOrder(TacoOrder order) {
        kitchenOrderRabbit.displayOrder(order);
    }

}
