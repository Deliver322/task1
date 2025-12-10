package com.deliver.task1.service;

import com.deliver.task1.entity.CustomArray;
import com.deliver.task1.exeption.CustomException;
import com.deliver.task1.service.impl.CustomArraySortServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class CustomArraySortServiceTest {
    private CustomArray customArray;
    private CustomArraySortService customArraySortService;
    private static final int VALID_ID = 1;
    private static final int[] EXPECTED_SORTED_ARRAY = {-11, 5, 12, 22, 29, 44, 56, 77, 98};

    @BeforeEach
    public void setUp() throws CustomException {
        int[] initialArray = {12, 22, -11, 44, 5, 56, 77, 98, 29};
        customArray = new CustomArray(VALID_ID, initialArray);
        customArraySortService = new CustomArraySortServiceImpl();
    }

    @Test
    public void testBubbleSort() throws CustomException {
        customArraySortService.bubbleSort(customArray);
        int[] actualArray = customArray.getArray();

        assertArrayEquals(EXPECTED_SORTED_ARRAY, actualArray, "Array should be:" + Arrays.toString(EXPECTED_SORTED_ARRAY));
    }

    @Test
    public void testQuickSort() throws CustomException {
        customArraySortService.quickSort(customArray);
        int[] actualArray = customArray.getArray();

        assertArrayEquals(EXPECTED_SORTED_ARRAY, actualArray, "Array should be:" + Arrays.toString(EXPECTED_SORTED_ARRAY));
    }
}
