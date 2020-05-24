package de.dwosch.energydrinkservice.mappers;

import de.dwosch.energydrinkservice.domain.EnergyDrink;
import de.dwosch.energydrinkservice.model.EnergyDrinkDto;
import de.dwosch.energydrinkservice.model.EnergyDrinkRepresentation;
import org.mapstruct.*;

import java.util.ArrayList;
import java.util.List;

/**
 * danielwosch created on 2020-05-23
 */
@Mapper
public interface IEnergyDrinkMapper {

    EnergyDrinkRepresentation entityToRepresentation(EnergyDrink energyDrink);

    List<EnergyDrinkRepresentation> entitiesToRepresentations(Iterable<EnergyDrink> energyDrinks);

    EnergyDrink dtoToEntity(EnergyDrinkDto energyDrinkDto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
    EnergyDrink updateEntityFromDto(EnergyDrinkDto energyDrinkDto, @MappingTarget EnergyDrink entity);

}
