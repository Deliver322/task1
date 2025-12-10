package com.deliver.task2.factory;

import com.deliver.task2.entity.CustomArray;
import com.deliver.task2.exeption.CustomException;

import java.util.List;

public interface CustomArrayFactory {

    CustomArray create(int id, int[] array) throws CustomException;

    List<CustomArray> createArraysFromFile(int id, String filePath) throws CustomException;
}
