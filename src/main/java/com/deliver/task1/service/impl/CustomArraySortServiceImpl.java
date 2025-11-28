package com.deliver.task1.service.impl;

import com.deliver.task1.entity.CustomArray;
import com.deliver.task1.service.CustomArraySortService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CustomArraySortServiceImpl implements CustomArraySortService {

    private final Logger logger = LogManager.getLogger();

    @Override
    public CustomArray bubbleSort(CustomArray customArray) {
        logger.debug("Initiating Bubble Sort on array");
        int[] array = customArray.getArray();
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i; j++) {
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
    public CustomArray quickSort(CustomArray customArray) {
        logger.debug("Initiating Quick Sort on array");
        quickSort(customArray.getArray(), 0, customArray.getArray().length - 1);
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
