package com.deliver.task1.validator.impl;

import com.deliver.task1.validator.InputNumberValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class InputNumberValidatorImpl implements InputNumberValidator {
    private static final Logger logger = LogManager.getLogger();
    private static final String ONLY_VALID_SYMBOLS_REGEX = "^[\\d\\s.,;+\\-]*$";

    @Override
    public boolean isValid(String line) {

        if (line == null) {
            logger.info("Input line is null");
            return false;
        }

        String strippedLine = line.strip();
        if (strippedLine.isBlank()) {
            return true;
        }

        boolean isValidResult = strippedLine.matches(ONLY_VALID_SYMBOLS_REGEX);

        if (isValidResult) {
            logger.info("Line is valid: {}", line);
        } else {
            logger.info("Line is not valid: {}", line);
        }

        return isValidResult;
    }
}
