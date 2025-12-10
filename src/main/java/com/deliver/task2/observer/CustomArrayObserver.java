package com.deliver.task2.observer;

import com.deliver.task2.entity.CustomArray;
import com.deliver.task2.entity.CustomArrayInfo;

public interface CustomArrayObserver {
    void onCustomArrayChanged(CustomArray customArray);
}
