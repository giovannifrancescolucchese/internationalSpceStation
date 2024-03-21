package org.example.model;

// Lombok's @Data is a convenient shorthand that bundles the features of @ToString, @EqualsAndHashCode, @Getter, @Setter, and @RequiredArgsConstructor!
// It generates all the boilerplate that is normally associated with simple POJOs (Plain Old Java Objects) such as getters, setters, equals, hash, and toString methods.
import lombok.Data;

// Lombok's @AllArgsConstructor generates a constructor with 1 parameter for each field in your class.
// Fields marked with @NonNull will be included in the constructor and will throw a NullPointerException if a null value is passed to them through the constructor.
import lombok.AllArgsConstructor;

// Importing a custom enum to specify the communication type (example values might be EMAIL, SMS, PUSH_NOTIFICATION, etc.).
import org.example.enums.ComunicationType;

/**
 * Represents a communication message with a specified type.
 * This class serves as a simple data container model for transferring communication details
 * such as the text of the message and its type (e.g., email, SMS).
 *
 * The class is designed to be a simple, lightweight data object that employs Lombok annotations
 * to reduce boilerplate code commonly associated with POJOs.
 */
@Data
@AllArgsConstructor
public class Comunication {
    // Text content of the communication
    String testo;  // 'testo' is Italian for 'text', representing the message content of the communication.

    // Type of communication (e.g., EMAIL, SMS, etc.), defined by the ComunicationType enum
    ComunicationType comunicationType; // This specifies the medium or method of the communication.
}