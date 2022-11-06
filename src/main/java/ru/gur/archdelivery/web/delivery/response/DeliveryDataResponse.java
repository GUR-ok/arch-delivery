package ru.gur.archdelivery.web.delivery.response;

import lombok.Builder;
import lombok.Data;
import ru.gur.archdelivery.web.delivery.request.DeliveryTimeSlot;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Builder
public class DeliveryDataResponse {

    UUID id;

    UUID processId;

    UUID orderId;

    DeliveryTimeSlot deliveryTimeSlot;

    LocalDate deliveryDate;
}
