package com.deliver.task2.repository;

import com.deliver.task2.entity.CustomArray;
import com.deliver.task2.exeption.CustomException;

import java.util.Comparator;
import java.util.List;

public interface CustomArrayRepository {
    void add(CustomArray customArray) throws CustomException;
    void remove(CustomArray customArray) throws CustomException;

//    List<CustomArray> findAll(Specification specification);

    List<CustomArray> sort(Comparator<CustomArray> comparator);
}
