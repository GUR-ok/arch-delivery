package ru.gur.archdelivery.service.delivery;

import ru.gur.archdelivery.service.delivery.data.DeliveryData;
import ru.gur.archdelivery.service.delivery.immutable.ImmutableDeliveryCreationRequest;

import java.util.UUID;

public interface DeliveryService {

    UUID createDelivery(ImmutableDeliveryCreationRequest immutableDeliveryCreationRequest);

    DeliveryData getDeliveryData(UUID orderId);

    void cancelDelivery(UUID deliveryId);
}
