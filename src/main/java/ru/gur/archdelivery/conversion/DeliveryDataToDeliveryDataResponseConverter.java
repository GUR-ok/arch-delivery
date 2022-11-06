package ru.gur.archdelivery.conversion;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ru.gur.archdelivery.service.delivery.data.DeliveryData;
import ru.gur.archdelivery.web.delivery.response.DeliveryDataResponse;

@Component
public class DeliveryDataToDeliveryDataResponseConverter
        implements Converter<DeliveryData, DeliveryDataResponse> {

    @Override
    public DeliveryDataResponse convert(final DeliveryData source) {
        return DeliveryDataResponse.builder()
                .id(source.getId())
                .processId(source.getProcessId())
                .orderId(source.getOrderId())
                .deliveryTimeSlot(source.getDeliveryTimeSlot())
                .deliveryDate(source.getDeliveryDate())
                .build();
    }
}
