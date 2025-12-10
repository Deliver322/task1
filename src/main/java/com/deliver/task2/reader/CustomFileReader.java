package com.deliver.task2.reader;

import com.deliver.task2.exeption.CustomException;

import java.util.List;

public interface CustomFileReader {
    List<String> readLines(String filePath) throws CustomException;
}
