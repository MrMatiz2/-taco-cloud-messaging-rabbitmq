package com.example.tacocloudmessagingrabbitmq.services.receivers;

import com.example.tacoclouddomain.entities.TacoOrder;

public interface OrderReceiver {
    TacoOrder receiveOrder();
}
