package com.deliver.task2.service;

import com.deliver.task2.entity.CustomArray;
import com.deliver.task2.exeption.CustomException;

public interface CustomArrayCalculateService {
    int findMax(CustomArray customArray) throws CustomException;
    int findMin(CustomArray customArray) throws CustomException;
    int sum(CustomArray customArray) throws CustomException;
}
