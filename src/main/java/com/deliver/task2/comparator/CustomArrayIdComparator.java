package com.deliver.task2.comparator;

import com.deliver.task2.entity.CustomArray;

import java.util.Comparator;

public class CustomArrayIdComparator implements Comparator<CustomArray> {
    @Override
    public int compare(CustomArray array1, CustomArray array2) {
        return Integer.compare(array1.getId(), array2.getId());
    }
}
