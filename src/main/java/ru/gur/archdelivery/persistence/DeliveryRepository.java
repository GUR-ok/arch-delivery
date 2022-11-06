package ru.gur.archdelivery.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gur.archdelivery.entity.Delivery;
import ru.gur.archdelivery.web.delivery.request.DeliveryTimeSlot;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface DeliveryRepository extends JpaRepository<Delivery, UUID> {

    Optional<Delivery> findByOrderId(UUID orderId);

    void deleteByOrderId(UUID orderId);

    List<Delivery> findByDeliveryDateAndDeliveryTimeSlot(LocalDate deliveryDate, DeliveryTimeSlot deliveryTimeSlot);
}