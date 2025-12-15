package com.deliver.task2.specification.impl;

import com.deliver.task2.entity.CustomArray;
import com.deliver.task2.specification.CustomArraySpecification;

public class IdSpecification implements CustomArraySpecification {
    private int neededId;

    public IdSpecification(int lookupId) {
        this.neededId = lookupId;
    }

    @Override
    public boolean specify(CustomArray customArray) {
        return customArray.getId() == neededId;
    }
}
