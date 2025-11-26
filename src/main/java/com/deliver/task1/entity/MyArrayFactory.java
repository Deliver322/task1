package com.deliver.task1.entity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MyArrayFactory implements MyArray.Factory {
    private final Logger logger = LogManager.getLogger(MyArrayFactory.class);

    @Override
    public MyArray create(int id, int[] array) {
        logger.debug("Creating MyArray with id {} ", id);
        return new MyArray(id, array);
    }
}
