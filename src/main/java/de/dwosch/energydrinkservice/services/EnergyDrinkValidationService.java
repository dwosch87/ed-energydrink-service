package de.dwosch.energydrinkservice.services;

import de.dwosch.energydrinkservice.model.EnergyDrinkDto;
import de.dwosch.energydrinkservice.repositories.IEnergyDrinkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * danielwosch created on 2020-05-24
 */
@Service
@RequiredArgsConstructor
public class EnergyDrinkValidationService implements IEnergyDrinkValidationService {
    private final IEnergyDrinkRepository repository;

    public boolean isValid(final EnergyDrinkDto energyDrinkDto) {
        return !repository.existsByEanOrName(energyDrinkDto.getEan(), energyDrinkDto.getName());
    }

}
