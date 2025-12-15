package com.deliver.task2.specification.impl;

import com.deliver.task2.entity.CustomArray;
import com.deliver.task2.entity.CustomArrayInfo;
import com.deliver.task2.specification.CustomArraySpecification;
import com.deliver.task2.warehouse.CustomArrayWarehouse;
import com.deliver.task2.warehouse.impl.CustomArrayWarehouseImpl;

public class FindExactlyLikeSum implements CustomArraySpecification {
    private int neededSum;

    public FindExactlyLikeSum(int neededSum) {
        this.neededSum = neededSum;
    }

    @Override
    public boolean specify(CustomArray customArray) {
        CustomArrayWarehouse warehouse = CustomArrayWarehouseImpl.getInstance();
        int id = customArray.getId();
        CustomArrayInfo arrayInfo = warehouse.getInfo(id);
        if (arrayInfo == null) {
            return false;
        }
        int arraySum = arrayInfo.sum();
        return arraySum == neededSum;
    }
}
