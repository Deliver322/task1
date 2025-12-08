package com.deliver.task1.factory;

import com.deliver.task1.entity.CustomArray;
import com.deliver.task1.exeption.CustomException;

import java.util.List;

public interface CustomArrayFactory {

    CustomArray create(int id, int[] array) throws CustomException;

    List<CustomArray> createArraysFromFile(int id, String filePath) throws CustomException;
}
