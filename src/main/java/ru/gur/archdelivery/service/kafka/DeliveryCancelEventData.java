package ru.gur.archdelivery.service.kafka;

import lombok.Builder;
import lombok.Value;

import java.util.UUID;

@Value
@Builder
public class DeliveryCancelEventData implements KafkaEvent {

    UUID deliveryId;

    @Override
    public Event getEvent() {
        return Event.DELIVERY_CANCEL;
    }
}
