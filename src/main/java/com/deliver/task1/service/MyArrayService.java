package com.deliver.task1.service;

import com.deliver.task1.entity.MyArray;

public interface MyArrayService {
    int findMax(MyArray myArray);
    int findMin(MyArray myArray);
    int sum(MyArray myArray);
    MyArray bubbleSort(MyArray myArray);
    MyArray quickSort(MyArray myArray);
}
