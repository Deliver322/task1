package com.deliver.task2.factory.impl;

import com.deliver.task2.entity.CustomArray;
import com.deliver.task2.exeption.CustomException;
import com.deliver.task2.factory.CustomArrayFactory;
import com.deliver.task2.reader.CustomFileReader;
import com.deliver.task2.parser.RowDataParser;
import com.deliver.task2.reader.impl.CustomFileReaderImpl;
import com.deliver.task2.parser.impl.RowDataParserImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class CustomArrayFactoryImpl implements CustomArrayFactory {

    private static final Logger logger = LogManager.getLogger();
    private final CustomFileReader customFileReader;
    private final RowDataParser rowDataParser;
    private int id = 0;

    public CustomArrayFactoryImpl() {
        this.customFileReader = new CustomFileReaderImpl();
        this.rowDataParser = new RowDataParserImpl();
    }

    @Override
    public CustomArray create(int id, int[] array) throws CustomException {
        logger.debug("Creating CustomArray with id {} and given array ", id);
        if (array != null && array.length > 0) {
            return new CustomArray(id, array);
        }
        throw new CustomException("Array is null");
    }

    @Override
    public List<CustomArray> createArraysFromFile(int id, String filePath) throws CustomException {
        logger.debug("Creating CustomArray with id {}", id);
        List<String> linesFromFile = customFileReader.readLines(filePath);
        List<int[]> listNumberArray = rowDataParser.readData(linesFromFile);
        List<CustomArray> resultList = new ArrayList<>();

        for (int[] array : listNumberArray) {
            resultList.add(create(id++ ,array));
        }
        return resultList;
    }
}
