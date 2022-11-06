package ru.gur.archdelivery.service.delivery;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import ru.gur.archdelivery.entity.Delivery;
import ru.gur.archdelivery.persistence.DeliveryRepository;
import ru.gur.archdelivery.service.delivery.data.DeliveryData;
import ru.gur.archdelivery.service.delivery.immutable.ImmutableDeliveryCreationRequest;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DeliveryServiceImpl implements DeliveryService {

    private final DeliveryRepository deliveryRepository;

    @Override
    @Transactional
    public UUID createDelivery(final ImmutableDeliveryCreationRequest immutableDeliveryCreationRequest) {
        Assert.notNull(immutableDeliveryCreationRequest, "immutableDeliveryCreationRequest must not be null");

        List<Delivery> deliveries = deliveryRepository.findByDeliveryDateAndDeliveryTimeSlot(immutableDeliveryCreationRequest.getDeliveryDate(),
                immutableDeliveryCreationRequest.getDeliveryTimeSlot());

        final Delivery delivery = deliveryRepository.findByOrderId(immutableDeliveryCreationRequest.getOrderId())
                .orElse(new Delivery());

        deliveries.remove(delivery);
        if (!deliveries.isEmpty()) {
            throw new RuntimeException("Слот доставки занят");
        }

        delivery.setOrderId(immutableDeliveryCreationRequest.getOrderId());
        delivery.setProcessId(immutableDeliveryCreationRequest.getProcessId());
        delivery.setDeliveryDate(immutableDeliveryCreationRequest.getDeliveryDate());
        delivery.setDeliveryTimeSlot(immutableDeliveryCreationRequest.getDeliveryTimeSlot());

        return deliveryRepository.save(delivery).getId();
    }

    @Override
    public DeliveryData getDeliveryData(final UUID orderId) {
        Assert.notNull(orderId, "orderId must not be null");

        return deliveryRepository.findByOrderId(orderId)
                .map(dd -> DeliveryData.builder()
                        .id(dd.getId())
                        .orderId(dd.getOrderId())
                        .processId(dd.getProcessId())
                        .deliveryDate(dd.getDeliveryDate())
                        .deliveryTimeSlot(dd.getDeliveryTimeSlot())
                        .build())
                .orElseThrow(() -> new RuntimeException("delivery not found"));
    }

    @Override
    @Transactional
    public void cancelDelivery(final UUID deliveryId) {
        Assert.notNull(deliveryId, "deliveryId must not be null");

        deliveryRepository.deleteById(deliveryId);
    }
}
