package com.deliver.task1.validator.impl;

import com.deliver.task1.entity.CustomArray;
import com.deliver.task1.validator.CustomArrayValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CustomArrayValidatorImpl implements CustomArrayValidator {

    private static final Logger logger = LogManager.getLogger();

    @Override
    public boolean isValidCustomArray(CustomArray customArray) {
        logger.debug("Started Validating custom array");
        if (customArray == null) {
            logger.debug("Custom array is null");
            return false;
        }
        if (customArray.getArray().length == 0) {
            logger.debug("Custom array is empty");
            return false;
        }
        logger.debug("Success on validation a custom array length");
        return true;
    }

    @Override
    public boolean isValidArray(int[] array) {
        logger.debug("Started validating an array");
        if (array == null) {
            logger.debug("Array is null");
            return false;
        }
        if (array.length == 0) {
            logger.debug("Array is empty");
            return false;
        }
        logger.debug("Success on validation an array");
        return true;
    }

    @Override
    public boolean isValidSize(int size) {
        logger.debug("Started validating of array size");
        if (size < 0) {
            logger.debug("The size is negative {}", size);
            return false;
        }
        logger.debug("Success on validation of array size");
        return true;
    }
}
