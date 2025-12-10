package com.deliver.task2.comparator;

import com.deliver.task2.entity.CustomArray;

import java.util.Comparator;

public class CustomArrayLengthComparator implements Comparator<CustomArray> {
    @Override
    public int compare(CustomArray array1, CustomArray array2) {
        return Integer.compare(array1.getArray().length, array2.getArray().length);
    }
}
