package ru.gur.archdelivery.service.delivery;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import ru.gur.archdelivery.service.delivery.data.DeliveryData;
import ru.gur.archdelivery.service.delivery.immutable.ImmutableDeliveryCreationRequest;

import java.util.UUID;

@Service
public class DeliveryServiceImpl implements DeliveryService {

    @Override
    public UUID createDelivery(final ImmutableDeliveryCreationRequest immutableDeliveryCreationRequest) {
        Assert.notNull(immutableDeliveryCreationRequest, "immutableDeliveryCreationRequest must not be null");

        return null;
    }

    @Override
    public DeliveryData getDeliveryData(final UUID orderId) {
        Assert.notNull(orderId, "orderId must not be null");

        return null;
    }

    @Override
    public void cancelDelivery(UUID orderId) {

    }
}
