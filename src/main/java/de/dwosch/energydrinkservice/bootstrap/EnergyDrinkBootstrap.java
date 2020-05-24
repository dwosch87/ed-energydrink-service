package de.dwosch.energydrinkservice.bootstrap;

import de.dwosch.energydrinkservice.domain.EnergyDrink;
import de.dwosch.energydrinkservice.repositories.IEnergyDrinkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

/**
 * danielwosch created on 2020-05-24
 */
@Component
@RequiredArgsConstructor
public class EnergyDrinkBootstrap implements CommandLineRunner {
    private final IEnergyDrinkRepository repository;

    @Override
    public void run(String... args) {
        bootstrapIfEmpty();
    }

    /**
     * Create basic energy drinks if no data exists
     */
    private void bootstrapIfEmpty() {
        if(repository.count() > 0)
            return;

        final EnergyDrink one = EnergyDrink.builder()
                .caffeineContent(10)
                .description("New killing citrus flavour")
                .ean("EAN_KILLER_CITRUS")
                .name("Killer Citrus")
                .minimumInStock(1)
                .price(BigDecimal.valueOf(1.99))
                .build();

        final EnergyDrink two = EnergyDrink.builder()
                .caffeineContent(10)
                .description("Flying high with this flavour")
                .ean("EAN_FLYING_HIGH")
                .name("Flying High")
                .minimumInStock(10)
                .price(BigDecimal.valueOf(2.99))
                .build();

        final EnergyDrink three = EnergyDrink.builder()
                .caffeineContent(10)
                .description("The leftovers")
                .ean("EAN_CHEMICAL_WASTE")
                .name("Chemical Waste")
                .minimumInStock(20)
                .price(BigDecimal.valueOf(0.50))
                .build();

        repository.saveAll(List.of(one, two, three));
    }
}
