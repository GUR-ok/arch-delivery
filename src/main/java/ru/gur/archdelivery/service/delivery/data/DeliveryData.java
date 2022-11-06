package ru.gur.archdelivery.service.delivery.data;

import lombok.Builder;
import lombok.Value;
import ru.gur.archdelivery.web.delivery.request.DeliveryTimeSlot;

import java.time.LocalDate;
import java.util.UUID;

@Value
@Builder
public class DeliveryData {

    UUID id;

    UUID processId;

    UUID orderId;

    DeliveryTimeSlot deliveryTimeSlot;

    LocalDate deliveryDate;
}
