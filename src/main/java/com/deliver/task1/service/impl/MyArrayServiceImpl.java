package com.deliver.task1.service.impl;

import com.deliver.task1.entity.MyArray;
import com.deliver.task1.service.MyArrayService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class MyArrayServiceImpl implements MyArrayService {
    private final Logger logger = LogManager.getLogger(MyArrayServiceImpl.class);

    @Override
    public int findMax(MyArray myArray) {
        logger.debug("Finding max in myArray");
        int max = myArray.getArray()[0];
        logger.trace("Initial max value is {}", max);
        for (int i = 1; i < myArray.getArray().length; i++) {
            int value = myArray.getArray()[i];
            logger.trace("Comparing max {} with value {}", max, value);
            if (value > max) {
                max = value;
                logger.trace("New max value is {}", max);
            }
        }
        return max;
    }

    @Override
    public int findMin(MyArray myArray) {
        logger.debug("Finding min in myArray");
        int min = myArray.getArray()[0];
        logger.trace("Initial min value is {}", min);
        for (int i = 1; i < myArray.getArray().length; i++) {
            int value = myArray.getArray()[i];
            logger.trace("Comparing min {} with value {}", min, value);
            if (value < min) {
                min = value;
                logger.trace("New min value is {}", min);
            }
        }
        return min;
    }

    @Override
    public int sum(MyArray myArray) {
        logger.debug("Finding sum of elements in array");
        int sum = 0;
        for (int i = 0; i < myArray.getArray().length; i++) {
            int value = myArray.getArray()[i];
            sum += value;
            logger.trace("Current sum: {} Adding {} at index {}", sum, value, i);
        }
        logger.trace("Sum is completed: {}", sum);
        return sum;
    }

    @Override
    public MyArray bubbleSort(MyArray myArray) {
        logger.debug("Initiating Bubble Sort on array");
        int[] array = myArray.getArray();
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
        myArray.setArray(array);
        logger.info("Bubble Sort completed");
        return myArray;
    }

    @Override
    public MyArray quickSort(MyArray myArray) {
        logger.debug("Initiating Quick Sort on array");
        quickSort(myArray.getArray(), 0, myArray.getArray().length - 1);
        logger.info("Quick Sort completed");
        return myArray;
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
