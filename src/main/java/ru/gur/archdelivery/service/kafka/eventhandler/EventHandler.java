package ru.gur.archdelivery.service.kafka.eventhandler;

import ru.gur.archdelivery.service.kafka.EventSource;

public interface EventHandler<T extends EventSource> {

    boolean canHandle(EventSource eventSource);

    String handleEvent(T eventSource);
}
