package com.deliver.task1.service;

import com.deliver.task1.entity.CustomArray;
import com.deliver.task1.exeption.CustomException;

public interface CustomArrayCalculateService {
    int findMax(CustomArray customArray) throws CustomException;
    int findMin(CustomArray customArray) throws CustomException;
    int sum(CustomArray customArray) throws CustomException;
}
