package org.example.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Represents exceptions specific to the International Space Station (ISS) application.
 * This class extends the generic Exception class in Java to provide more detailed error
 * information pertaining to the ISS application scenarios.
 */
@Data // This annotation automatically generates getter, setter, equals, hashcode, and toString methods.
@AllArgsConstructor // This annotation generates a constructor with one argument for each field in the class.
public class ISSException extends Exception {
    // Description of the exception
    String description; // The detailed message of the exception.
}