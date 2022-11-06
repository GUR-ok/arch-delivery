package ru.gur.archdelivery.service.delivery.immutable;

import lombok.Builder;
import lombok.Value;
import ru.gur.archdelivery.web.delivery.request.DeliveryTimeSlot;

import java.time.LocalDate;
import java.util.UUID;

@Value
@Builder
public class ImmutableDeliveryCreationRequest {

    UUID processId;

    UUID orderId;

    DeliveryTimeSlot deliveryTimeSlot;

    LocalDate deliveryDate;
}
