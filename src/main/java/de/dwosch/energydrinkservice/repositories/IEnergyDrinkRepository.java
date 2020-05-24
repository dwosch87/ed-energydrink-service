package de.dwosch.energydrinkservice.repositories;

import de.dwosch.energydrinkservice.domain.EnergyDrink;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * danielwosch created on 2020-05-23
 */
@Repository
public interface IEnergyDrinkRepository extends PagingAndSortingRepository<EnergyDrink, UUID> {
    boolean existsByEanAndName(final String ean, final String name);
}
