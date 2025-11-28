package com.deliver.task1.validator;

import com.deliver.task1.entity.CustomArray;
import com.deliver.task1.exeption.CustomException;

public interface CustomArrayValidator {

    boolean isValidCustomArray(CustomArray customArray);
    boolean isValidArray(int[] array);
    boolean isValidBounds(int index, int arrayLength) throws CustomException;
    boolean isValidNonNegativeSize(int size) throws CustomException;
}
