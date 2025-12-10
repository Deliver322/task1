package com.deliver.task2.comparator;

import com.deliver.task2.entity.CustomArray;

import java.util.Comparator;

public class CustomArrayFirstElementComparator implements Comparator<CustomArray> {
    @Override
    public int compare(CustomArray array1, CustomArray array2) {
        return Integer.compare(array1.getArray()[0], array2.getArray()[0]);
    }
}
