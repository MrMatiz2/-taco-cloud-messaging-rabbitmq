package com.example.tacocloudmessagingrabbitmq.services.listeners;

import com.example.tacoclouddomain.entities.TacoOrder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class KitchenOrderRabbit {

    public void displayOrder(TacoOrder order) {
        log.info("RECEIVED ORDER:  " + order);
    }

}
