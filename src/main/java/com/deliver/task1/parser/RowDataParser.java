package com.deliver.task1.parser;

import com.deliver.task1.exeption.CustomException;

import java.util.List;

public interface RowDataParser {
    List<int[]> readData(List<String> stringLines) throws CustomException;
}
