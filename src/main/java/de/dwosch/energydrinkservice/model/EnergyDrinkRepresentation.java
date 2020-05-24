package de.dwosch.energydrinkservice.model;

import lombok.Builder;
import lombok.Value;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

/**
 * danielwosch created on 2020-05-24
 *
 * Class is used to be returned to caller.
 * Using representation classes to separate incoming and outgoing object's even if the
 * may appear equal.
 */

@Value
@Builder(toBuilder = true)
public class EnergyDrinkRepresentation implements Serializable {
    UUID id;
    long version;
    OffsetDateTime createdAt;
    OffsetDateTime updatedAt;
    String name;
    String description;
    int caffeineContent;
    String ean;
    BigDecimal price;
    int minimumInStock;
}
