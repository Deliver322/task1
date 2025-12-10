package com.deliver.task2.service.impl;

import com.deliver.task2.entity.CustomArray;
import com.deliver.task2.exeption.CustomException;
import com.deliver.task2.service.CustomArrayCalculateService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CustomArrayCalculateServiceImpl implements CustomArrayCalculateService {

    private static final Logger logger = LogManager.getLogger();

    @Override
    public int findMax(CustomArray customArray) throws CustomException {
        if (customArray == null || customArray.getArray() == null) {
            throw new CustomException("empty array");
        }
        logger.debug("Finding max in customArray");
        int max = customArray.getArray()[0];
        logger.trace("Initial max value is {}", max);
        for (int i = 1; i < customArray.getArray().length; i++) {
            int value = customArray.getArray()[i];
            logger.trace("Comparing max {} with value {}", max, value);
            if (value > max) {
                max = value;
                logger.trace("New max value is {}", max);
            }
        }
        return max;
    }

    @Override
    public int findMin(CustomArray customArray) throws CustomException {
        logger.debug("Finding min in customArray");
        if (customArray == null || customArray.getArray() == null) {
            throw new CustomException("empty array");
        }
        int min = customArray.getArray()[0];
        logger.trace("Initial min value is {}", min);
        for (int i = 1; i < customArray.getArray().length; i++) {
            int value = customArray.getArray()[i];
            logger.trace("Comparing min {} with value {}", min, value);
            if (value < min) {
                min = value;
                logger.trace("New min value is {}", min);
            }
        }
        return min;
    }

    @Override
    public int sum(CustomArray customArray) throws CustomException {
        logger.debug("Finding sum of elements in array");
        if (customArray == null || customArray.getArray() == null) {
            throw new CustomException("empty array");
        }
        int sum = 0;
        for (int i = 0; i < customArray.getArray().length; i++) {
            int value = customArray.getArray()[i];
            sum += value;
            logger.trace("Current sum: {} Adding {} at index {}", sum, value, i);
        }
        logger.trace("Sum is completed: {}", sum);
        return sum;
    }
}
