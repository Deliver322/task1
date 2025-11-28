package com.deliver.task1.factory;

import com.deliver.task1.entity.CustomArray;
import com.deliver.task1.exeption.CustomException;

public interface CustomArrayFactory {

    CustomArray create(int id, int[] array) throws CustomException;

    CustomArray createFromFile();
}
