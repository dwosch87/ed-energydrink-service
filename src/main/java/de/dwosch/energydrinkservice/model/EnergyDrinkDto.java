package de.dwosch.energydrinkservice.model;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * danielwosch created on 2020-05-24
 */
@Data
@Builder(toBuilder = true)
public class EnergyDrinkDto implements Serializable {

    @NotBlank(message = "Energydrink must have a fancy name")
    private String name;

    @Min(value = 1, message = "Energydrink without caffeine is not supported")
    private int caffeineContent;

    @PositiveOrZero(message = "Price must be 0 or greater")
    private BigDecimal price;

    @PositiveOrZero(message = "Minimum in stock must be 0 or greater")
    private int minimumInStock;

    @NotBlank(message = "Energydrink requires an unique ean")
    private String ean;
}
