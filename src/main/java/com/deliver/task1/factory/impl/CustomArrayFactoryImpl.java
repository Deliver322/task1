package com.deliver.task1.factory.impl;

import com.deliver.task1.entity.CustomArray;
import com.deliver.task1.exeption.CustomException;
import com.deliver.task1.factory.CustomArrayFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CustomArrayFactoryImpl implements CustomArrayFactory {

    private static final Logger logger = LogManager.getLogger();

    @Override
    public CustomArray create(int id, int[] array) throws CustomException {
        logger.debug("Creating CustomArray with id {} ", id);
        //add a validator to it
        return new CustomArray(id, array);
    }

    @Override
    public CustomArray createFromFile() {
        //add a validator to it AND DO THE TESTS!!!
        return null;
    }
}
