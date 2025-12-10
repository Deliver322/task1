package com.deliver.task2.observer.impl;

import com.deliver.task2.entity.CustomArray;
import com.deliver.task2.entity.CustomArrayInfo;
import com.deliver.task2.exeption.CustomException;
import com.deliver.task2.observer.CustomArrayObserver;
import com.deliver.task2.service.impl.CustomArrayCalculateServiceImpl;
import com.deliver.task2.warehouse.CustomArrayWarehouse;
import com.deliver.task2.warehouse.impl.CustomArrayWarehouseImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CustomArrayObserverImpl implements CustomArrayObserver {
    public static final Logger logger = LogManager.getLogger();

    @Override
    public void onCustomArrayChanged(CustomArray customArray) {
        CustomArrayCalculateServiceImpl calculator = new CustomArrayCalculateServiceImpl();
        logger.debug("onCustomArrayChanged started calculation");

        try {
            int min = calculator.findMin(customArray);
            int max = calculator.findMax(customArray);
            int sum = calculator.sum(customArray);
            //add int avg = ...

            CustomArrayInfo customArrayInfo = new CustomArrayInfo(min, max, sum);

            CustomArrayWarehouse warehouse = CustomArrayWarehouseImpl.getInstance();
            warehouse.put(customArray.getId(), customArrayInfo);
        } catch (CustomException e) {
            logger.error("Error on customArray id {}", customArray.getId(), e.getMessage());
        }
    }
}
