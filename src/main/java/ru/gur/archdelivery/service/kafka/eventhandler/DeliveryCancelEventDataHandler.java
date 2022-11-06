package ru.gur.archdelivery.service.kafka.eventhandler;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import ru.gur.archdelivery.service.delivery.DeliveryService;
import ru.gur.archdelivery.service.kafka.DeliveryCancelEventData;
import ru.gur.archdelivery.service.kafka.Event;
import ru.gur.archdelivery.service.kafka.EventSource;

@Slf4j
@Component
@RequiredArgsConstructor
public class DeliveryCancelEventDataHandler implements EventHandler<DeliveryCancelEventData> {

    private final DeliveryService deliveryService;

    @Override
    public boolean canHandle(final EventSource eventSource) {
        Assert.notNull(eventSource, "EventSource must not be null");

        return Event.DELIVERY_CANCEL.equals(eventSource.getEvent());
    }

    @Override
    public String handleEvent(final DeliveryCancelEventData eventSource) {
        Assert.notNull(eventSource, "EventSource must not be null");

        deliveryService.cancelDelivery(eventSource.getOrderId());

        log.info("Event handled: {}", eventSource);

        return eventSource.getEvent().name();
    }
}
