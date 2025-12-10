package com.deliver.task2.service;

import com.deliver.task2.entity.CustomArray;
import com.deliver.task2.exeption.CustomException;

public interface CustomArraySortService {
    CustomArray bubbleSort(CustomArray customArray) throws CustomException;
    CustomArray quickSort(CustomArray customArray) throws CustomException;
}
