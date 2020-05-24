package de.dwosch.energydrinkservice.controller;

import de.dwosch.energydrinkservice.model.EnergyDrinkDto;
import de.dwosch.energydrinkservice.model.EnergyDrinkRepresentation;
import de.dwosch.energydrinkservice.services.IEnergyDrinkService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * danielwosch created on 2020-05-23
 */
@RequiredArgsConstructor
@RequestMapping("/api/v1/energydrink")
@RestController
public class EnergyDrinkController {
    private final IEnergyDrinkService IEnergyDrinkService;

    @GetMapping("/all")
    public ResponseEntity<List<EnergyDrinkRepresentation>> getAll() {
        return new ResponseEntity<>(IEnergyDrinkService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnergyDrinkRepresentation> getBeerById(@PathVariable("id") final UUID energyDrinkId) {
        return new ResponseEntity<>(IEnergyDrinkService.getById(energyDrinkId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<EnergyDrinkRepresentation> createNewEnergyDrink(@RequestBody @Validated final EnergyDrinkDto energyDrinkDto) {
        return new ResponseEntity<>(IEnergyDrinkService.createNewEnergyDrink(energyDrinkDto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EnergyDrinkRepresentation> updateBeerById(@PathVariable("id") final UUID energyDrinkId, @RequestBody @Validated final EnergyDrinkDto energyDrinkDto) {
        return new ResponseEntity<>(IEnergyDrinkService.updateEnergyDrink(energyDrinkId, energyDrinkDto), HttpStatus.NO_CONTENT);
    }

}
