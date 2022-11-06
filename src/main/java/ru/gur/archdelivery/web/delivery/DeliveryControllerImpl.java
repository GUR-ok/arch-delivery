package ru.gur.archdelivery.web.delivery;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.ConversionService;
import org.springframework.web.bind.annotation.*;
import ru.gur.archdelivery.service.delivery.DeliveryService;
import ru.gur.archdelivery.service.delivery.immutable.ImmutableDeliveryCreationRequest;
import ru.gur.archdelivery.web.delivery.request.DeliveryCreationRequest;
import ru.gur.archdelivery.web.delivery.response.DeliveryDataResponse;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/delivery")
public class DeliveryControllerImpl implements DeliveryController {

    private final DeliveryService deliveryService;
    private final ConversionService conversionService;

    @Override
    @PostMapping
    public UUID create(@Valid @NotNull @RequestBody final DeliveryCreationRequest createOrderRequest) {
        return deliveryService.createDelivery(conversionService.convert(createOrderRequest,
                ImmutableDeliveryCreationRequest.class));
    }

    @Override
    @GetMapping
    public DeliveryDataResponse getDelivery(@RequestParam(name = "orderId") final UUID orderId) {
        return conversionService.convert(deliveryService.getDeliveryData(orderId), DeliveryDataResponse.class);
    }
}
