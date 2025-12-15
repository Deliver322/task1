package com.deliver.task2.specification.impl;

import com.deliver.task2.entity.CustomArray;
import com.deliver.task2.entity.CustomArrayInfo;
import com.deliver.task2.specification.CustomArraySpecification;
import com.deliver.task2.warehouse.CustomArrayWarehouse;
import com.deliver.task2.warehouse.impl.CustomArrayWarehouseImpl;

public class FindMoreThanMin implements CustomArraySpecification {
    private int neededMin;

    public FindMoreThanMin(int neededMin) {
        this.neededMin = neededMin;
    }

    @Override
    public boolean specify(CustomArray customArray) {
        CustomArrayWarehouse warehouse = CustomArrayWarehouseImpl.getInstance();
        int id = customArray.getId();
        CustomArrayInfo arrayInfo = warehouse.getInfo(id);
        if (arrayInfo == null) {
            return false;
        }
        int arrayMin = arrayInfo.min();
        return arrayMin > neededMin;
    }
}
