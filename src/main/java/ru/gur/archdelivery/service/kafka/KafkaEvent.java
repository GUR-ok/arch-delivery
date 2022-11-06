package ru.gur.archdelivery.service.kafka;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        property = "event"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = DeliveryCancelEventData.class, name = "DELIVERY_CANCEL")
})
public interface KafkaEvent extends EventSource{
}