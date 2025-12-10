package com.deliver.task2.warehouse;

import com.deliver.task2.entity.CustomArray;
import com.deliver.task2.entity.CustomArrayInfo;

public interface CustomArrayWarehouse {
    void put(int id, CustomArrayInfo customArrayInfo);
    void remove(int id);
    CustomArrayInfo getInfo(int id);
}
