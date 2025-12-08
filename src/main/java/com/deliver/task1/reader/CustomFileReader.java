package com.deliver.task1.reader;

import com.deliver.task1.exeption.CustomException;

import java.util.List;

public interface CustomFileReader {
    List<String> readLines(String filePath) throws CustomException;
}
