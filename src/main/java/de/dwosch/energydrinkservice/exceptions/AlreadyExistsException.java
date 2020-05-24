package de.dwosch.energydrinkservice.exceptions;

/**
 * danielwosch created on 2020-05-24
 */
public class AlreadyExistsException extends RuntimeException  {
    private AlreadyExistsException() {
        super();
    }

    public AlreadyExistsException(final String message) {
        super(message);
    }
}
