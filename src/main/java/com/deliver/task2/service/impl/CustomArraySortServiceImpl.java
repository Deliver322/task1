package com.deliver.task2.service.impl;

import com.deliver.task2.entity.CustomArray;
import com.deliver.task2.exeption.CustomException;
import com.deliver.task2.service.CustomArraySortService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CustomArraySortServiceImpl implements CustomArraySortService {

    private final Logger logger = LogManager.getLogger();

    @Override
    public CustomArray bubbleSort(CustomArray customArray) throws CustomException {
        logger.debug("Initiating Bubble Sort on array");
        if (customArray == null || customArray.getArray() == null) {
            throw new CustomException("empty array");
        }
        int[] array = customArray.getArray();
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                logger.trace("Comparing old Value {} with new value {}", array[j], array[j + 1]);
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    logger.trace("Swapped {} and {}", array[j], array[j + 1]);
                }
            }
        }
        customArray.setArray(array);
        logger.info("Bubble Sort completed");
        return customArray;
    }

    @Override
    public CustomArray quickSort(CustomArray customArray) throws CustomException {
        logger.debug("Initiating Quick Sort on array");
        if (customArray == null || customArray.getArray() == null) {
            throw new CustomException("empty array");
        }
        int[] array = customArray.getArray();
        quickSort(array, 0, array.length - 1);
        customArray.setArray(array);
        logger.info("Quick Sort completed");
        return customArray;
    }

    private void quickSort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }

        int pivotIndex = partition(array, left, right);

        quickSort(array, left, pivotIndex - 1);
        quickSort(array, pivotIndex + 1, right);
    }

    private int partition(int[] array, int left, int right) {
        int pivot = array[right];
        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (array[j] <= pivot) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i + 1, right);
        logger.trace("Partition completed");
        return i + 1;
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
        logger.trace("Swapped {} and {}", array[i], array[j]);
    }
}
