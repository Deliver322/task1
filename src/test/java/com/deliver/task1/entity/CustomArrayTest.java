package com.deliver.task1.entity;


import com.deliver.task1.exeption.CustomException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CustomArrayTest {

    private static final int VALID_ID = 1;
    private static final int[] INITIAL_ARRAY = {1, 2, 3, 4, 5};
    private CustomArray customArray;

    @BeforeEach
    public void setUp() throws CustomException {
        customArray = new CustomArray(VALID_ID, INITIAL_ARRAY);
    }

    @Test
    void testGetValue() throws CustomException {
        int index = 0;
        int expectedValue = 1;

        int actualValue = customArray.getValue(index);

        assertEquals(expectedValue, actualValue, "Value should be 1");
    }

    @Test
    void testSetValue() throws CustomException {
        int index = 0;
        int expectedValue = 33;

        customArray.setValue(index, expectedValue);

        assertEquals(expectedValue, customArray.getValue(index), "Value should be 33");
    }

    @Test
    void testGetArray() throws CustomException {
        int[] expected = INITIAL_ARRAY;

        int[] actual = customArray.getArray();

        assertArrayEquals(expected, actual, "Arrays should be equal");

        actual[0] = 404;
        assertNotEquals(404, customArray.getArray()[0], "Array copy should not match original array");
    }

    @Test
    void testSetArray() throws CustomException {
        int[] newArray = {5, 4, 3, 2, 1};

        customArray.setArray(newArray);

        assertArrayEquals(newArray, customArray.getArray(), "Arrays should be equal");

        newArray[0] = 404;
        assertNotEquals(404, customArray.getArray()[0], "Array copy should not match original array");
    }
}
