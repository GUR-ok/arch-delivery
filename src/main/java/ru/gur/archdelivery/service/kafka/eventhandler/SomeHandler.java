package ru.gur.archdelivery.service.kafka.eventhandler;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import ru.gur.archdelivery.service.kafka.Event;
import ru.gur.archdelivery.service.kafka.EventSource;
import ru.gur.archdelivery.service.kafka.SomeEventData;
import ru.gur.archdelivery.service.service.DeliveryService;

@Slf4j
@Component
@RequiredArgsConstructor
public class SomeHandler implements EventHandler<SomeEventData> {

    private final DeliveryService storeService;

    @Override
    public boolean canHandle(final EventSource eventSource) {
        Assert.notNull(eventSource, "EventSource must not be null");

        return Event.SOME.equals(eventSource.getEvent());
    }

    @Override
    public String handleEvent(final SomeEventData eventSource) {
        Assert.notNull(eventSource, "EventSource must not be null");

        log.info("Event handled: {}", eventSource);

        return eventSource.getEvent().name();
    }
}
