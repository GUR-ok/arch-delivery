package ru.gur.archdelivery.conversion;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ru.gur.archdelivery.service.delivery.immutable.ImmutableDeliveryCreationRequest;
import ru.gur.archdelivery.web.delivery.request.DeliveryCreationRequest;

@Component
public class DeliveryCreationRequestToImmutableDeliveryCreationRequestConverter
        implements Converter<DeliveryCreationRequest, ImmutableDeliveryCreationRequest> {

    @Override
    public ImmutableDeliveryCreationRequest convert(final DeliveryCreationRequest source) {
        return ImmutableDeliveryCreationRequest.builder()
                .processId(source.getProcessId())
                .orderId(source.getOrderId())
                .deliveryTimeSlot(source.getDeliveryTimeSlot())
                .deliveryDate(source.getDeliveryDate())
                .build();
    }
}
