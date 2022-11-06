package ru.gur.archdelivery.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import ru.gur.archdelivery.web.delivery.request.DeliveryTimeSlot;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "deliveries")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Delivery {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(columnDefinition = "uuid", name = "id", updatable = false, nullable = false)
    private UUID id;

    @Column(columnDefinition = "uuid", name = "process_id", updatable = false, nullable = false)
    private UUID processId;

    @Column(columnDefinition = "uuid", name = "order_id", updatable = false, nullable = false)
    private UUID orderId;

    @Column(name = "delivery_time_slot", nullable = false)
    @Enumerated(EnumType.STRING)
    private DeliveryTimeSlot deliveryTimeSlot;

    @Column(name = "delivery_date", nullable = false)
    private LocalDate deliveryDate;
}
