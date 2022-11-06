package ru.gur.archdelivery.web.delivery;

import ru.gur.archdelivery.web.delivery.request.DeliveryCreationRequest;
import ru.gur.archdelivery.web.delivery.response.DeliveryDataResponse;

import java.util.UUID;

public interface DeliveryController {

    UUID create(DeliveryCreationRequest createOrderRequest);

    DeliveryDataResponse getDelivery(UUID orderId);
}
