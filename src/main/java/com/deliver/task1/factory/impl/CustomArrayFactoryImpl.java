package com.deliver.task1.factory.impl;

import com.deliver.task1.entity.CustomArray;
import com.deliver.task1.exeption.CustomException;
import com.deliver.task1.factory.CustomArrayFactory;
import com.deliver.task1.reader.FileReader;
import com.deliver.task1.reader.RowDataReader;
import com.deliver.task1.reader.impl.FileReaderImpl;
import com.deliver.task1.reader.impl.RowDataReaderImpl;
import com.deliver.task1.validator.CustomArrayValidator;
import com.deliver.task1.validator.impl.CustomArrayValidatorImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class CustomArrayFactoryImpl implements CustomArrayFactory {

    private static final Logger logger = LogManager.getLogger();

    @Override
    public CustomArray create(int id, int[] array) throws CustomException {
        logger.debug("Creating CustomArray with id {} and given array ", id);
        CustomArrayValidator customArrayValidator = new CustomArrayValidatorImpl();
        boolean isValidArray = customArrayValidator.isValidArray(array);
        if (isValidArray) {
            return new CustomArray(id, array);
        } else {
            throw new CustomException("Invalid array");
        }
    }

    @Override
    public CustomArray createFromFile(int id) throws CustomException {
        logger.debug("Creating CustomArray with id {}", id);
        FileReader fileReader = new FileReaderImpl();
        List<String> numberRow = fileReader.readLine();
        RowDataReader rowDataReader = new RowDataReaderImpl();

        logger.info("Reading data from stings");
        int[] readArray = rowDataReader.readData(numberRow);
        logger.info("Created CustomArray from file with id {}", id);
        return new CustomArray(id, readArray);
    }
}
