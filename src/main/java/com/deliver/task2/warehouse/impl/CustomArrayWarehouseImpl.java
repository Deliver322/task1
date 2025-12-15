package com.deliver.task2.warehouse.impl;

import com.deliver.task2.entity.CustomArrayInfo;
import com.deliver.task2.warehouse.CustomArrayWarehouse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class CustomArrayWarehouseImpl implements CustomArrayWarehouse {
    public static final Logger logger = LogManager.getLogger();
    private static CustomArrayWarehouse instance;
    private final Map<Integer, CustomArrayInfo> warehouseInfo = new HashMap<>();

    //implement Observer to warehouse?

    private CustomArrayWarehouseImpl(){}

    public static CustomArrayWarehouse getInstance() {
        if (instance == null) {
            logger.info("CustomArrayWarehouseImpl instance created");
            instance = new CustomArrayWarehouseImpl();
        }
        return instance;
    }

    @Override
    public void put(int id, CustomArrayInfo customArrayInfo) {
        warehouseInfo.put(id, customArrayInfo);
        logger.info("Info has been added for array by ID: {}", id);
    }

    @Override
    public void remove(int id) {
        warehouseInfo.remove(id);
        logger.info("Info has been removed for array by ID: {}", id);
    }

    @Override
    public CustomArrayInfo getInfo(int id) {
        return warehouseInfo.get(id);
    }
}
