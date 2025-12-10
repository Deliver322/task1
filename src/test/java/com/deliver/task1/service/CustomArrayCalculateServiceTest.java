package com.deliver.task1.service;

import com.deliver.task1.entity.CustomArray;
import com.deliver.task1.exeption.CustomException;
import com.deliver.task1.service.impl.CustomArrayCalculateServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomArrayCalculateServiceTest {
    private CustomArray customArray;
    private CustomArrayCalculateService customArrayCalculateService;
    private static final int VALID_ID = 1;
    private static final int[] INITIAL_ARRAY = {12, 22, -11, 44, 5, 56, 77, 98, 29};

    @BeforeEach
    public void setUp() throws CustomException {
        customArray = new CustomArray(VALID_ID, INITIAL_ARRAY);
        customArrayCalculateService = new CustomArrayCalculateServiceImpl();
    }

    @Test
    public void testFindMin() throws CustomException {
        int expectedResult = -11;

        int actualResult = customArrayCalculateService.findMin(customArray);

        assertEquals(expectedResult, actualResult, "Min should be -11");
    }

    @Test
    public void testFindMax() throws CustomException {
        int expectedResult = 98;

        int actualResult = customArrayCalculateService.findMax(customArray);

        assertEquals(expectedResult, actualResult, "Max should be 98");
    }

    @Test
    public void testFindSum() throws CustomException {
        int expectedResult = 332;

        int actualResult = customArrayCalculateService.sum(customArray);

        assertEquals(expectedResult, actualResult, "Sum should be 332");
    }
}
