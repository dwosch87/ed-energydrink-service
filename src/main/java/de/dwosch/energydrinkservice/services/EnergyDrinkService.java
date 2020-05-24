package de.dwosch.energydrinkservice.services;

import de.dwosch.energydrinkservice.domain.EnergyDrink;
import de.dwosch.energydrinkservice.exceptions.AlreadyExistsException;
import de.dwosch.energydrinkservice.exceptions.NotFoundException;
import de.dwosch.energydrinkservice.mappers.IEnergyDrinkMapper;
import de.dwosch.energydrinkservice.model.EnergyDrinkDto;
import de.dwosch.energydrinkservice.model.EnergyDrinkRepresentation;
import de.dwosch.energydrinkservice.repositories.IEnergyDrinkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * danielwosch created on 2020-05-23
 */
@RequiredArgsConstructor
@Service
public class EnergyDrinkService implements IEnergyDrinkService {
    private final IEnergyDrinkRepository repository;
    private final IEnergyDrinkMapper mapper;
    private final IEnergyDrinkValidationService validationService;

    @Override
    public EnergyDrinkRepresentation getById(UUID energyDrinkId) {
        return mapper.entityToRepresentation(repository.findById(energyDrinkId).orElseThrow(NotFoundException::new));
    }

    @Override
    public EnergyDrinkRepresentation createNewEnergyDrink(final EnergyDrinkDto energyDrinkDto) {
        if(!validationService.isValid(energyDrinkDto))
            throw new AlreadyExistsException("Energy drink with provided data already exists.");

        return mapper.entityToRepresentation(repository.save(mapper.dtoToEntity(energyDrinkDto)));
    }

    @Override
    public EnergyDrinkRepresentation updateEnergyDrink(final UUID energyDrinkId, final EnergyDrinkDto energyDrinkDto) {
        final EnergyDrink entityToUpdate = repository.findById(energyDrinkId).orElseThrow(NotFoundException::new);
        return mapper.entityToRepresentation(repository.save( mapper.updateEntityFromDto(energyDrinkDto, entityToUpdate)));
    }

    @Override
    public List<EnergyDrinkRepresentation> getAll() {
        return mapper.entitiesToRepresentations(repository.findAll());
    }
}
