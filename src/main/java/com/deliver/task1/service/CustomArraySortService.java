package com.deliver.task1.service;

import com.deliver.task1.entity.CustomArray;
import com.deliver.task1.exeption.CustomException;

public interface CustomArraySortService {
    CustomArray bubbleSort(CustomArray customArray) throws CustomException;
    CustomArray quickSort(CustomArray customArray);
}
