package com.deliver.task1.validator;

import com.deliver.task1.entity.CustomArray;
import com.deliver.task1.exeption.CustomException;

public interface CustomArrayValidator {

    boolean isValidCustomArray(CustomArray customArray);
    boolean isValidArray(int[] array);
    boolean isValidSize(int size) throws CustomException;
}
