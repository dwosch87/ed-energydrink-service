package de.dwosch.energydrinkservice.services;

import de.dwosch.energydrinkservice.model.EnergyDrinkDto;
import de.dwosch.energydrinkservice.model.EnergyDrinkRepresentation;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * danielwosch created on 2020-05-23
 */
public interface IEnergyDrinkService {
    EnergyDrinkRepresentation getById(UUID energyDrinkId);

    EnergyDrinkRepresentation createNewEnergyDrink(EnergyDrinkDto energyDrinkDto);

    EnergyDrinkRepresentation updateEnergyDrink(UUID energyDrinkId, EnergyDrinkDto energyDrinkDto);

    List<EnergyDrinkRepresentation> getAll();
}
