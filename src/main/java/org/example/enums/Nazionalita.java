package org.example.enums;

/**
 * Defines various space agencies' nationalities.
 * <p>
 * This enumeration represents the nationality categories for space agencies across the world.
 * It is used to categorize the primary nationality of the space agencies, which includes but is not limited to:
 * <ul>
 * <li>NASA (United States)</li>
 * <li>RKA (Russia)</li>
 * <li>ESA (European Space Agency) and its related agencies</li>
 * <li>JAXA (Japan)</li>
 * <li>CSA-ASC (Canada)</li>
 * </ul>
 * Additional nationalities can be added to represent other countries' space agencies or organizations.
 * </p>
 */
public enum Nazionalita {
    // Enums represent the nationalities.
    americana, // Represents American nationality, e.g., NASA
    russa,     // Represents Russian nationality, e.g., RKA
    italiana,  // Represents Italian nationality, implicitly part of ESA
    francese,  // Represents French nationality, implicitly part of ESA
    spagnola,  // Represents Spanish nationality, implicitly part of ESA
    tedesca,   // Represents German nationality, implicitly part of ESA
    inglese,   // Represents English (British) nationality, implicitly part of ESA
    giapponese,// Represents Japanese nationality, e.g., JAXA
    canadese   // Represents Canadian nationality, e.g., CSA-ASC
}