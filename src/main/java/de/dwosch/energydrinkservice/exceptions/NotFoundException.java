package de.dwosch.energydrinkservice.exceptions;

/**
 * danielwosch created on 2020-05-23
 */
public class NotFoundException extends RuntimeException {
    public NotFoundException() {
        super("The requested entity was not found.");
    }
}
