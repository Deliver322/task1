package com.deliver.task2.repository.impl;

import com.deliver.task2.entity.CustomArray;
import com.deliver.task2.exeption.CustomException;
import com.deliver.task2.repository.CustomArrayRepository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.deliver.task2.specification.CustomArraySpecification;
import com.deliver.task2.warehouse.impl.CustomArrayWarehouseImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CustomArrayRepositoryImpl implements CustomArrayRepository {
    public static final Logger logger = LogManager.getLogger();
    private static CustomArrayRepositoryImpl instance;
    private final List<CustomArray> arraysList = new ArrayList<>();


    private CustomArrayRepositoryImpl() {
    }

    public static CustomArrayRepositoryImpl getInstance() {
        if (instance == null) {
            logger.info("CustomArrayRepositoryImpl instance created");
            instance = new CustomArrayRepositoryImpl();
        }
        return instance;
    }

    @Override
    public void add(CustomArray customArray) throws CustomException {
        if (customArray == null) {
            throw new CustomException("CustomArray is null");
        }

        arraysList.add(customArray);
        logger.info("CustomArray added to the Repository");
    }

    @Override
    public void remove(CustomArray customArray) throws CustomException {
        if (customArray == null) {
            throw new CustomException("CustomArray is null");
        }

        arraysList.remove(customArray);
        CustomArrayWarehouseImpl.getInstance().remove(customArray.getId());
        logger.info("CustomArray removed from the Repository");
    }

    @Override
    public List<CustomArray> sort(Comparator<CustomArray> comparator) {
        List<CustomArray> result = new ArrayList<>(arraysList);
        result.sort(comparator);
        return result;
    }

    @Override
    public List<CustomArray> findAll(CustomArraySpecification specification) {
        return arraysList.stream()
                .filter(specification::specify)
                .toList();
    }
}
