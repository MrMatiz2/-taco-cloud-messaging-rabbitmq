package com.example.tacocloudmessagingrabbitmq.services.listeners;

import com.example.tacoclouddomain.entities.TacoOrder;
import com.example.tacoclouddomain.kitchen.KitchenOrder;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

//@Profile("rabbit-listener")
@Component
public class OrderListenerRabbit {

    private final KitchenOrder kitchenOrder;

    public OrderListenerRabbit(KitchenOrder kitchenOrder) {
        this.kitchenOrder = kitchenOrder;
    }

    @RabbitListener(queues = "tacocloud.queue")
    public void receiveOrder(TacoOrder order) {
        kitchenOrder.displayOrder(order);
    }

}
