package de.dwosch.energydrinkservice.services;

import de.dwosch.energydrinkservice.model.EnergyDrinkDto;

/**
 * danielwosch created on 2020-05-24
 */
public interface IEnergyDrinkValidationService {
    boolean isValid(final EnergyDrinkDto energyDrinkDto);
}
