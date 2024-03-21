package org.example.exception;

// Lombok annotations to eliminate boilerplate code like constructors, getters, and setters
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * This class represents specific exceptions relating to health issues within the context
 * of the International Space Station's (ISS) software application. It extends the more general
 * {@code ISSException}, indicating that it is intended for use when health-related
 * conditions fail or when specific invalid states regarding health safety or
 * protocols are encountered in the application.
 * <p>
 * The usage of this exception allows for more granular error handling related to the health domain,
 * facilitating better diagnosis and response to issues that are specific to health concerns within the ISS application.
 * </p>
 */
public class HealthException extends ISSException {

    /**
     * Constructs a new {@code HealthException} with the specified detail message. The
     * detail message is saved for later retrieval by the {@link #getMessage()} method.
     *
     * @param description The detail message. The detail message is a {@code String}
     *                    that describes this particular exception and provides further context
     *                    on the nature of the health-related issue that has occurred.
     */
    public HealthException(String description) {
        super(description); // Call super class constructor with the description
    }
}