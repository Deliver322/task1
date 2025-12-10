package com.deliver.task2.parser;

import com.deliver.task2.exeption.CustomException;

import java.util.List;

public interface RowDataParser {
    List<int[]> readData(List<String> stringLines) throws CustomException;
}
