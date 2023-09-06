package org.example.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * eccezioni proprie dell'applicativo della base spaziale internazionale
 */
@AllArgsConstructor
@Data
public class ISSException extends Exception {
    String description;
}
