package com.deliver.task2.validator;

import com.deliver.task2.validator.impl.InputNumberValidatorImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class InputNumberValidatorTest {

    private InputNumberValidator validator;

    @BeforeEach
    void setUp() {
        validator = new InputNumberValidatorImpl();
    }

    @Test
    void testValidWithNumerics() {
        String validLine = "1 2, -3.5; 44";

        boolean isValid = validator.isValid(validLine);

        assertTrue(isValid, "Validator should return true for valid numeric string");
    }

    @Test
    void testValidWithLetters() {
        String invalidLine = "1 2 3z 4";

        boolean isValid = validator.isValid(invalidLine);

        assertFalse(isValid, "Validator should return false if string contains letters");
    }

    @Test
    void testInvalidWithSymbols() {
        String invalidLine = "1 @ 2";

        boolean isValid = validator.isValid(invalidLine);

        assertFalse(isValid, "Validator should return false for special symbols like '@'");
    }

    @Test
    void testInvalidWithBlanks() {
        String blankLine = "   ";

        boolean isValid = validator.isValid(blankLine);

        assertTrue(isValid, "Validator should return true for blank lines");
    }

    @Test
    void testInvalidWithNull() {
        String invalidLine = null;

        boolean result = validator.isValid(invalidLine);

        assertFalse(result, "Validator should return false if input string is null");
    }
}
