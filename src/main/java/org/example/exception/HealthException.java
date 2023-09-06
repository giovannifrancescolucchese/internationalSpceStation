package org.example.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * eccezioni proprie dell'applicativo della base spaziale internazionale
 */

public class HealthException extends ISSException {

    public HealthException(String description) {
        super(description);
    }
}
