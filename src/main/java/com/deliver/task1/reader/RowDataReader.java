package com.deliver.task1.reader;

import com.deliver.task1.exeption.CustomException;

import java.util.List;

public interface RowDataReader {
    int[] readData(List<String> stringLines) throws CustomException;
}
