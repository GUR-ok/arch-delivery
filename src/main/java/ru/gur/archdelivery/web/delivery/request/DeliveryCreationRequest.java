package ru.gur.archdelivery.web.delivery.request;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Builder
public class DeliveryCreationRequest {

    private UUID processId;

    private UUID orderId;

    private DeliveryTimeSlot deliveryTimeSlot;

    private LocalDate deliveryDate;
}
