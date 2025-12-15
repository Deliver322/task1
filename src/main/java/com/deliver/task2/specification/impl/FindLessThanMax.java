package com.deliver.task2.specification.impl;

import com.deliver.task2.entity.CustomArray;
import com.deliver.task2.entity.CustomArrayInfo;
import com.deliver.task2.specification.CustomArraySpecification;
import com.deliver.task2.warehouse.CustomArrayWarehouse;
import com.deliver.task2.warehouse.impl.CustomArrayWarehouseImpl;

public class FindLessThanMax implements CustomArraySpecification {
    private int neededMax;

    public FindLessThanMax(int neededMax) {
        this.neededMax = neededMax;
    }

    @Override
    public boolean specify(CustomArray customArray) {
        CustomArrayWarehouse warehouse = CustomArrayWarehouseImpl.getInstance();
        int id = customArray.getId();
        CustomArrayInfo arrayInfo = warehouse.getInfo(id);
        if (arrayInfo == null) {
            return false;
        }
        int arrayMax = arrayInfo.max();
        return arrayMax < neededMax;
    }
}
